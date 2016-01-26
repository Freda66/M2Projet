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
 *
 */
public class Database {

	// ==============================================================
	// ATTRIBUTES
	// ==============================================================

	protected String databasePath;
	protected Connection connection = null;
	protected Statement statement = null;

	// ==============================================================
	// CONSTRUCTOR
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
	 */
	public void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
			statement = connection.createStatement();
			System.out.println("Connection to " + databasePath + " succeed.");
		} catch (ClassNotFoundException notFoundException) {
			notFoundException.printStackTrace();
			System.out.println("Connection failed. NotFoundException");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Connection failed. SQLException");
		}
	}

	// --------------------------------------------------------------

	/**
	 * Action method : Disconnect from Database.
	 */
	public void close() {
		try {
			statement.close();
			connection.close();
			System.out.println("Disconect from " + databasePath + " succeed.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Disconnect failed.");
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
			System.out.println("Error in : " + query);
		}
		return res;
	}

}