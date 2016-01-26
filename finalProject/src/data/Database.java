package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Relative class to Databse access
 * 
 * @author fred, pev
 * @version 1.0.1
 */
public class Database {

	// ==============================================================
	// ATTRIBUTES
	// ==============================================================

	protected String databasePath;
	protected Connection connection = null;
	protected Statement statement = null;

	// ==============================================================
	// CONSTRUCTORS
	// ==============================================================

	/**
	 * Initialize Database properties
	 * 
	 * @param db
	 *            : Database object
	 */
	public Database(Database db) {
		databasePath = db.getDatabasePath();
		connection = db.getConnection();
		statement = db.getStatement();
	}
	
	// --------------------------------------------------------------

	/**
	 * Initialize Database properties - Overloaded constructor
	 * 
	 * @param db
	 *            : String path do Database
	 */
	public Database(String db) {
		databasePath = db;
	}

	// ==============================================================
	// GETTERS
	// ==============================================================

	public String getDatabasePath() {
		return this.databasePath;
	}

	// --------------------------------------------------------------

	public Connection getConnection() {
		return connection;
	}

	// --------------------------------------------------------------

	public Statement getStatement() {
		return statement;
	}

	// ==============================================================
	// METHODS
	// ==============================================================

	/**
	 * Action method : Connect to Database.
	 * @return 
	 */
	public boolean connect() {
		boolean ret = false;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
			statement = connection.createStatement();
			ret = true;
		} catch (ClassNotFoundException notFoundException) {
			notFoundException.printStackTrace();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return ret;
	}

	// --------------------------------------------------------------

	/**
	 * Action method : Disconnect from Database.
	 */
	public void disconnect() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Execute SQL query and return result.
	 * 
	 * @param query
	 *            : SQL string query
	 * @return : Result from SQL query
	 */
	public ResultSet query(String query) {
		ResultSet res = null;
		try {
			res = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}