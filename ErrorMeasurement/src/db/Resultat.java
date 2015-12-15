package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Resultat extends Database{
	/**
	 * Attributs de la table/classe
	 */
	private int idRun;
	private double resultInit;
	private double resultOpt;
	private double resultMpfr;
	
	/** 
	 * Constructeur par defaut
	 */
	public Resultat(Database db){
		super(db);
	}
	
	/**
	 * Constructeur surchargé de la classe
	 * @param ResultatIdRun
	 * @param ResultatResultInit
	 * @param ResultatResultOpt
	 * @param ResultatResultMpfr
	 */
	public Resultat(Database db, int ResultatIdRun, double ResultatResultInit, double ResultatResultOpt, double ResultatResultMpfr){
		super(db);
		setIdRun(ResultatIdRun);
		setResultInit(ResultatResultInit);
		setResultOpt(ResultatResultOpt);
		setResultMpfr(ResultatResultMpfr);
	}
	
	/**
	 * Fonction qui permet d'ajouter un enregistrement dans la bdd
	 */
	public void addResultat() {
        try {
            PreparedStatement preparedStatement = super.getConnection().prepareStatement("INSERT INTO Resultat VALUES(?,?,?,?)");
            preparedStatement.setNull(1, 0);
            preparedStatement.setDouble(2, this.getResultInit());
            preparedStatement.setDouble(3, this.getResultOpt());
            preparedStatement.setDouble(4, this.getResultMpfr());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Fonction qui permet de modifier un enregistrement dans la bdd
	 */
	public void updateResultat() {
        try {
            PreparedStatement preparedStatement = super.getConnection().prepareStatement("UPDATE Resultat SET resultInit=?, resultOpt=?, resultMpfr=? WHERE idRun=?");
            preparedStatement.setDouble(1, this.getResultInit());
            preparedStatement.setDouble(2, this.getResultOpt());
            preparedStatement.setDouble(3, this.getResultMpfr());
            preparedStatement.setInt(4, this.getIdRun());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/** 
	 * Fonction qui ajoute les resultats dans la liste
	 */
	public ArrayList<Resultat> getListeResultat(Database db){
		ArrayList<Resultat> lesResultats = new ArrayList<Resultat>();
		// Requete SQL
        ResultSet resultSet = super.query("SELECT * FROM Resultat");
        try {
            // Parcours la requete
            while (resultSet.next()) {
            	// Ajoute l'objet resultat à la liste
            	lesResultats.add(new Resultat(db, resultSet.getInt("idRun"), resultSet.getDouble("resultInit"), resultSet.getDouble("resultOpt"), resultSet.getDouble("resultMpfr")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        // Retourne la liste des resultats
        return lesResultats;
	}
	
	/** 
	 * Fonction qui recupere un Resultat par son id
	 */
	public void getResultatById(int mId){
		// Met à jour l'objet
        ResultSet resultSet = super.query("SELECT * FROM Resultat WHERE idRun="+mId);
        try {
        	this.setIdRun(resultSet.getInt("idRun"));
        	this.setResultInit(resultSet.getDouble("resultInit"));
        	this.setResultOpt(resultSet.getDouble("resultOpt"));
        	this.setResultMpfr(resultSet.getDouble("resultMpfr"));
        } catch (SQLException e) { e.printStackTrace(); }
	}
	
	/**
	 * Fonction qui affiche l'objet courant
	 */
	public void printObject(){
		System.out.println("ID: "+ this.getIdRun() +", ResultInit:"+ this.getResultInit() + ", ResultOpt:"+ this.getResultOpt() + ",Result mpfr:"+ this.getResultMpfr());
	}

	/**
	 * Accesseurs (Getters/Setters)
	 */
	// Id Run
	public int getIdRun() {
		return idRun;
	}
	public void setIdRun(int idRun) {
		this.idRun = idRun;
	}
	// Result Opt
	public double getResultOpt() {
		return resultOpt;
	}
	public void setResultOpt(double resultOpt) {
		this.resultOpt = resultOpt;
	}
	// Result Init
	public double getResultInit() {
		return resultInit;
	}
	public void setResultInit(double resultInit) {
		this.resultInit = resultInit;
	}
	// Result Mpfr
	public double getResultMpfr() {
		return resultMpfr;
	}
	public void setResultMpfr(double resultMpfr) {
		this.resultMpfr = resultMpfr;
	}
	
}
