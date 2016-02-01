package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class contains methods to access data in the "Runner" table
 * 
 * @author fred, pev
 * @version 1.0.0
 *
 */

public class Variable extends Database {

	// ==============================================================
	// ATTRIBUTES
	// ==============================================================

	private int idVar;
	private String name;
	private double valueMin;
	private double valueMax;
	private int fkRun;

	// ==============================================================
	// CONSTRUCTOR
	// ==============================================================

	/**
	 * Default constructor.
	 * 
	 * @param db
	 *            : Database object
	 */
	public Variable(Database db) {
		super(db);
	}

	// --------------------------------------------------------------

	/**
	 * Overloaded constructor.
	 * 
	 * @param db
	 *            : Database object
	 * @param idVar
	 *            : Identification number
	 * @param name
	 *            : Variable name
	 * @param valueMin
	 *            : Minimal value
	 * @param valueMax
	 *            : Maximal value
	 * @param fkRun
	 *            : Foreign key to Runner
	 */
	public Variable(Database db, int idVar, String name, double valueMin, double valueMax, int fkRun) {
		super(db);
		this.idVar = idVar;
		this.name = name;
		this.valueMin = valueMin;
		this.valueMax = valueMax;
		this.fkRun = fkRun;
	}

	// ==============================================================
	// GETTERS
	// ==============================================================

	public int getIdVar() {
		return idVar;
	}

	public void setIdVar(int idVar) {
		this.idVar = idVar;
	}

	// --------------------------------------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// --------------------------------------------------------------

	public double getValueMin() {
		return valueMin;
	}

	public void setValueMin(double valueMin) {
		this.valueMin = valueMin;
	}

	// --------------------------------------------------------------

	public double getValueMax() {
		return valueMax;
	}

	public void setValueMax(double valueMax) {
		this.valueMax = valueMax;
	}

	// --------------------------------------------------------------

	public int getFkRun() {
		return fkRun;
	}

	public void setFkRun(int fkRun) {
		this.fkRun = fkRun;
	}

	// ==============================================================
	// METHODS
	// ==============================================================

	/**
	 * Add one entry into Variable table based on current attributes.
	 */
	public void addEntry() {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("INSERT INTO Variable (name, value_min, value_max, fk_run) VALUES(?,?,?,?)");
			preparedStatement.setString(1, this.getName());
			preparedStatement.setDouble(2, this.getValueMin());
			preparedStatement.setDouble(3, this.getValueMax());
			preparedStatement.setInt(4, this.getFkRun());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Add one entry into Variable table based on current attributes. Overloaded
	 * methods. Update the current object. The id_var is automatically generate.
	 * 
	 * @param name
	 *            : Variable name
	 * @param valueMin
	 *            : Minimal value
	 * @param valueMax
	 *            : Maximal value
	 * @param fkRun
	 *            : Foreign key to Runner
	 */
	public void addEntry(String name, double valueMin, double valueMax, int fkRun) {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("INSERT INTO Variable (name, value_min, value_max, fk_run) VALUES(?,?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, valueMin);
			preparedStatement.setDouble(3, valueMax);
			preparedStatement.setInt(4, fkRun);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			this.idVar = rs.getInt(1);
			this.name = name;
			this.valueMin = valueMin;
			this.valueMax = valueMax;
			this.fkRun = fkRun;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Update one entry into Runner table based on current attributes.
	 */
	public void updateEntry() {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("UPDATE Variable SET name=?, value_min=?, value_max=?, fk_run=? WHERE id_var=?");
			preparedStatement.setString(1, this.name);
			preparedStatement.setDouble(2, this.valueMin);
			preparedStatement.setDouble(3, this.valueMax);
			preparedStatement.setInt(4, this.fkRun);
			preparedStatement.setInt(5, this.idVar);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Delete one entry from Variable table based on current attributes.
	 */
	public void deleteEntry() {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("DELETE FROM Variable WHERE id_var=?");
			preparedStatement.setDouble(1, this.getIdVar());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Test if there is data based on idVar into Variable table.
	 * 
	 * @param idVar
	 *            : Identification number
	 * @return
	 */
	public boolean isVariableExists(int idVar) {

		// Execute query
		ResultSet resultSet = super.query("SELECT * FROM Variable WHERE id_var=" + idVar);

		try {
			// If there is a result
			if (!resultSet.isClosed()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	// --------------------------------------------------------------

	/**
	 * Update the current attributes Variable object based on idRun.
	 * 
	 * @param idVar
	 *            : Identification number
	 */
	public void updateRunnerObject(int idVar) {

		// Execute query
		ResultSet resultSet = super.query("SELECT * FROM Variable WHERE id_var=" + idVar);

		try {

			// If there is a result
			if (!resultSet.isClosed()) {
				this.setIdVar(resultSet.getInt("id_var"));
				this.setName(resultSet.getString("name"));
				this.setValueMin(resultSet.getDouble("value_min"));
				this.setValueMax(resultSet.getDouble("value_max"));
				this.setIdVar(resultSet.getInt("fk_run"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Get the current bounds for one variable based on variable id.
	 * 
	 * @param idVar
	 *            : Identification number
	 * @return String JSON like "{val_min: 1, val_max:2}"
	 */
	public String getMinMaxById(int idVar) {
		String ret = "";
		ResultSet resultSet = super.query("SELECT * FROM Variable WHERE id_var=" + idVar);
		try {
			ret = "{" + "value_min:" + resultSet.getDouble("value_min") + ", " + "value_max:"
					+ resultSet.getDouble("value_max") + "}";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	// --------------------------------------------------------------

	/**
	 * Get the current bounds for one variable based on variable name.
	 * 
	 * @param name
	 *            : Identification number
	 * @return String JSON like "{val_min: 1, val_max:2}"
	 */
	public String getMinMaxByName(String name) {
		String ret = "";
		ResultSet resultSet = super.query("SELECT * FROM Variable WHERE name=" + name);
		try {
			ret = "{" + "value_min:" + resultSet.getDouble("value_min") + ", " + "value_max:"
					+ resultSet.getDouble("value_max") + "}";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	// --------------------------------------------------------------
	
	/** 
	 * Fonction qui recupere un Measurement par son nom de variable
	 */
	public boolean getMeasurementByNomVar(String mNomVar, int fk_run){
		// Met à jour l'objet
        ResultSet resultSet = super.query("SELECT * FROM Variable WHERE fk_run = "+fk_run+" and name='"+mNomVar+"'");
        
        try {
        	// Si il y a un resultat
        	if(!resultSet.isClosed()){
	        	this.setIdVar(resultSet.getInt("id_var"));
	        	this.setName(resultSet.getString("name"));
	        	this.setValueMin(resultSet.getDouble("value_min"));
	        	this.setValueMax(resultSet.getDouble("value_max"));
	        	return true; // Ligne trouvée
        	} 
        	// Aucun resultat
        	else return false;
        } catch (SQLException e) { e.printStackTrace(); }
        
        return false; // Ligne non trouvée
	}

	// --------------------------------------------------------------

	/**
	 * Get all entries from the Variable table.
	 * 
	 * @param db
	 *            : Database object
	 * @return List of Variable object
	 */
	public ArrayList<Variable> getEntries(Database db) {

		// Init returner list
		ArrayList<Variable> listVariables = new ArrayList<Variable>();

		// Query
		ResultSet resultSet = super.query("SELECT * FROM Variable");
		try {
			while (resultSet.next()) {
				listVariables.add(new Variable(db, resultSet.getInt("id_var"), resultSet.getString("name"),
						resultSet.getDouble("value_min"), resultSet.getDouble("value_max"),
						resultSet.getInt("fk_run")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listVariables;
	}

	// --------------------------------------------------------------

	/**
	 * Remove all rows from Variable table
	 */
	public void clearVariable() {

		try {
			PreparedStatement preparedStatement = super.getConnection().prepareStatement("DELETE FROM Variable");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// --------------------------------------------------------------

	@Override
	public String toString() {
		return "{" 
				+ "'id_var':" + this.idVar + ", " 
				+ "'name':" + this.name + ", " 
				+ "'value_min':" + this.valueMin + ", "
				+ "'value_max':" + this.valueMax 
				+ "}";
	}

}
