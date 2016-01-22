package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Measurement extends Database{
	/**
	 * Attributs de la table/classe
	 */
	private int id;
	private String nomVar;
	private double min;
	private double max;
	
	/** 
	 * Constructeur par defaut
	 */
	public Measurement(Database db){
		super(db);
	}
	
	/**
	 * Constructeur surchargé de la classe
	 * @param MeasurementId
	 * @param MeasurementNomVar
	 * @param MeasurementMin
	 * @param MeasurementMax
	 */
	public Measurement(Database db, int MeasurementId, String MeasurementNomVar, double MeasurementMin, double MeasurementMax){
		super(db);
		id = MeasurementId;
		nomVar = MeasurementNomVar;
		min = MeasurementMin;
		max = MeasurementMax;
	}
	
	/**
	 * Fonction qui permet d'ajouter un enregistrement dans la bdd
	 */
	public void addMeasurement() {
        try {
            PreparedStatement preparedStatement = super.getConnection().prepareStatement("INSERT INTO Measurement VALUES(?,?,?,?)");
            preparedStatement.setNull(1, 0);
            preparedStatement.setString(2, this.getNomVar());
            preparedStatement.setDouble(3, this.getMin());
            preparedStatement.setDouble(4, this.getMax());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Fonction qui permet de modifier un enregistrement dans la bdd
	 */
	public void updateMeasurement() {
        try {
            PreparedStatement preparedStatement = super.getConnection().prepareStatement("UPDATE Measurement SET nomVar=?, min=?, max=? WHERE id=?");
            preparedStatement.setString(1, this.getNomVar());
            preparedStatement.setDouble(2, this.getMin());
            preparedStatement.setDouble(3, this.getMax());
            preparedStatement.setInt(4, this.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/** 
	 * Fonction qui ajoute les measurements dans la liste
	 */
	public ArrayList<Measurement> getListeMeasurement(Database db){
		ArrayList<Measurement> lesMeasurements = new ArrayList<Measurement>();
		// Requete SQL
        ResultSet resultSet = super.query("SELECT * FROM Measurement");
        try {
            // Parcours la requete
            while (resultSet.next()) {
            	// Ajoute l'objet measurement à la liste
            	lesMeasurements.add(new Measurement(db, resultSet.getInt("id"), resultSet.getString("nomVar"), resultSet.getDouble("min"), resultSet.getDouble("max")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        // Retourne la liste des measurements
        return lesMeasurements;
	}
	
	/** 
	 * Fonction qui recupere un Measurement par son id
	 */
	public boolean getMeasurementById(int mId){
		// Met à jour l'objet
        ResultSet resultSet = super.query("SELECT * FROM Measurement WHERE id="+mId);
        try {
        	// Si il y a un resultat
        	if(!resultSet.isClosed()){
	        	this.setId(resultSet.getInt("id"));
	        	this.setNomVar(resultSet.getString("nomVar"));
	        	this.setMin(resultSet.getDouble("min"));
	        	this.setMax(resultSet.getDouble("max"));
	        	return true; // Ligne trouvée
        	} 
        	// Aucun resultat
        	else return false;
        } catch (SQLException e) { e.printStackTrace(); }
        
        return false; // Ligne non trouvée
	}
	
	/** 
	 * Fonction qui recupere un Measurement par son nom de variable
	 */
	public boolean getMeasurementByNomVar(String mNomVar){
		// Met à jour l'objet
        ResultSet resultSet = super.query("SELECT * FROM Measurement WHERE nomVar='"+mNomVar+"'");
        
        try {
        	// Si il y a un resultat
        	if(!resultSet.isClosed()){
	        	this.setId(resultSet.getInt("id"));
	        	this.setNomVar(resultSet.getString("nomVar"));
	        	this.setMin(resultSet.getDouble("min"));
	        	this.setMax(resultSet.getDouble("max"));
	        	return true; // Ligne trouvée
        	} 
        	// Aucun resultat
        	else return false;
        } catch (SQLException e) { e.printStackTrace(); }
        
        return false; // Ligne non trouvée
	}
	
	/**
	 * Fonction qui affiche l'objet courant
	 */
	public void printObject(){
		System.out.println("ID: "+ this.getId() +", Var:"+ this.getNomVar() + ", min:max["+ this.getMin() + ":"+ this.getMax() +"]");
	}
	
	/**
	 * Accesseurs (Getters/Setters)
	 */
	// Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	// NomVar
	public String getNomVar() {
		return nomVar;
	}
	public void setNomVar(String nomVar) {
		this.nomVar = nomVar;
	}
	// Min
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	// Max
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
}
