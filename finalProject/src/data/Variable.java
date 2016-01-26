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
	 */
	public Variable(Database db, int idVar, String name, double valueMin, double valueMax) {
		super(db);
		this.idVar = idVar;
		this.name = name;
		this.valueMin = valueMin;
		this.valueMax = valueMax;
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

	// ==============================================================
	// METHODS
	// ==============================================================

	/**
	 * Add one entry into Variable table based on current attributes.
	 */
	public void addEntry() {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("INSERT INTO Variable (name, value_min, value_max) VALUES(?,?,?)");
			preparedStatement.setString(1, this.getName());
			preparedStatement.setDouble(2, this.getValueMin());
			preparedStatement.setDouble(3, this.getValueMax());
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
	 */
	public void addEntry(String name, double valueMin, double valueMax) {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("INSERT INTO Variable (name, value_min, value_max) VALUES(?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, valueMin);
			preparedStatement.setDouble(3, valueMax);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			this.idVar = rs.getInt(1);
			this.name = name;
			this.valueMin = valueMin;
			this.valueMax = valueMax;
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
					.prepareStatement("UPDATE Variable SET name=?, value_min=?, value_max=? WHERE id_var=?");
			preparedStatement.setString(1, this.name);
			preparedStatement.setDouble(2, this.valueMin);
			preparedStatement.setDouble(3, this.valueMax);
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
		ResultSet resultSet = super.query("SELECT * FROM Variable WHERE id_run=" + idVar);

		try {

			// If there is a result
			if (!resultSet.isClosed()) {
				this.setIdVar(resultSet.getInt("id_var"));
				this.setName(resultSet.getString("name"));
				this.setValueMin(resultSet.getDouble("value_min"));
				this.setValueMax(resultSet.getDouble("value_max"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	public ArrayList<Variable> getEntries(Database db) {

		// Init returner list
		ArrayList<Variable> listVariables = new ArrayList<Variable>();

		// Query
		ResultSet resultSet = super.query("SELECT * FROM Runner");
		try {
			while (resultSet.next()) {
				listVariables.add(new Variable(db, 
						resultSet.getInt("id_var"), 
						resultSet.getString("name"),
						resultSet.getDouble("value_min"), 
						resultSet.getDouble("value_max")
				));
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
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("DELETE FROM Variable");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// --------------------------------------------------------------

	@Override
	public String toString() {
		return "{" 
				+ "id_var:" + this.idVar + ", " 
				+ "name:" + this.name + ", " 
				+ "value_min:" + this.valueMin + ", "
				+ "value_max:" + this.valueMax 
			+ "}";
	}

}
