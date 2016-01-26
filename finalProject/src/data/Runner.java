package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * This class contains methods to access data in the "Runner" table
 * 
 * @author fred, pev
 * @version 1.0.0
 *
 */

public class Runner extends Database {

	// ==============================================================
	// ATTRIBUTES
	// ==============================================================

	private int idRun;
	private Timestamp timeIn;
	private Timestamp timeOut;

	// ==============================================================
	// CONSTRUCTOR
	// ==============================================================

	/**
	 * Default constructor.
	 * 
	 * @param db
	 *            : Database object
	 */
	public Runner(Database db) {
		super(db);
	}

	// --------------------------------------------------------------

	/**
	 * Overloaded constructor.
	 * 
	 * @param db
	 *            : Database object
	 * @param idRun
	 *            : Identification number
	 * @param timeIn
	 *            : Input timer
	 * @param timeOut
	 *            : Output timer
	 */
	public Runner(Database db, int idRun, Timestamp timeIn, Timestamp timeOut) {
		super(db);
		this.idRun = idRun;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}

	// ==============================================================
	// GETTERS
	// ==============================================================

	public int getIdRun() {
		return idRun;
	}

	public void setIdRun(int idRun) {
		this.idRun = idRun;
	}

	// --------------------------------------------------------------

	public Timestamp getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Timestamp timeIn) {
		this.timeIn = timeIn;
	}

	// --------------------------------------------------------------

	public Timestamp getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Timestamp timeOut) {
		this.timeOut = timeOut;
	}

	// ==============================================================
	// METHODS
	// ==============================================================

	/**
	 * Add one entry into Runner table based on current attributes.
	 */
	public void addEntry() {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("INSERT INTO Runner (time_in, time_out) VALUES(?,?)");
			preparedStatement.setTimestamp(1, this.getTimeIn());
			preparedStatement.setTimestamp(2, this.getTimeOut());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Add one entry into Runner table based on current attributes. Overloaded
	 * methods. Update the current object. The id_run is automatically generate.
	 * 
	 * @param timeIn
	 *            : Input timer
	 * @param timeOut
	 *            : Output timer
	 */
	public void addEntry(Timestamp timeIn, Timestamp timeOut) {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("INSERT INTO Runner (time_in, time_out) VALUES(?,?)");
			preparedStatement.setTimestamp(1, timeIn);
			preparedStatement.setTimestamp(2, timeOut);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			this.idRun = rs.getInt(1);
			this.timeIn = timeIn;
			this.timeOut = timeOut;
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
					.prepareStatement("UPDATE Runner SET time_in=?, time_out=? WHERE id_run=?");
			preparedStatement.setTimestamp(1, this.getTimeIn());
			preparedStatement.setTimestamp(2, this.getTimeOut());
			preparedStatement.setDouble(3, this.getIdRun());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Delete one entry from Runner table based on current attributes.
	 */
	public void deleteEntry() {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("DELETE FROM Runner WHERE id_run=?");
			preparedStatement.setDouble(1, this.getIdRun());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Test if there is data based on idRun into Runner table.
	 * 
	 * @param idRun
	 *            : Identification number
	 * @return
	 */
	public boolean isRunnerExists(int idRun) {

		// Execute query
		ResultSet resultSet = super.query("SELECT * FROM Runner WHERE id_run=" + idRun);

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
	 * Update the current attributes Runner object based on idRun.
	 * 
	 * @param idRun
	 *            : Identification number
	 */
	public void updateRunnerObject(int idRun) {

		// Execute query
		ResultSet resultSet = super.query("SELECT * FROM Runner WHERE id_run=" + idRun);

		try {

			// If there is a result
			if (!resultSet.isClosed()) {
				this.setIdRun(resultSet.getInt("id_run"));
				this.setTimeIn(resultSet.getTimestamp("time_in"));
				this.setTimeOut(resultSet.getTimestamp("time_out"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Get all entries from table Runner.
	 * 
	 * @param db
	 *            : Database object
	 * @return list of Runner objects
	 */
	public ArrayList<Runner> getEntries(Database db) {

		// Init returner list
		ArrayList<Runner> listRunners = new ArrayList<Runner>();

		// Query
		ResultSet resultSet = super.query("SELECT * FROM Runner");
		try {
			while (resultSet.next()) {
				// Ajoute l'objet measurement à la liste
				listRunners.add(new Runner(db, resultSet.getInt("id_run"), resultSet.getTimestamp("time_in"),
						resultSet.getTimestamp("id_out")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listRunners;
	}

	// --------------------------------------------------------------
	
	/**
	 * Remove all rows from Runner table
	 */
	public void clearRunner() {
		
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("DELETE FROM Runner");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// --------------------------------------------------------------

	@Override
	public String toString() {
		return "{" 
				+ "id_run:" + this.idRun + ", " 
				+ "time_in:" + this.timeIn + ", " 
				+ "time_out:" + this.timeOut 
			+ "}";
	}

}
