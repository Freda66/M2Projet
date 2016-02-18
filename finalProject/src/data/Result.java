package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class contains methods to access data in the "Result" table.
 * 
 * @author fred, pev
 * @version 1.0.0
 */
public class Result extends Database {

	// ==============================================================
	// ATTRIBUTES
	// ==============================================================

	/**
	 * Params format : JSON. We don't know how many parameters the C code needs.
	 * That's why, we will focus on this JSON prototype for each input row :
	 * 
	 * { 'nbParams:3, 'parameters'=[ { 'p_1':1, 'p_2':2, 'p_3':3 } ] }
	 * 
	 * If we execute a query to get all entries based on idRun, we will return :
	 * { 'p_1':1, 'p_2':2, 'p_3':3 }
	 * 
	 */
	private int idRes;
	private String params;
	private double resInit = 0.0;
	private double resOpt = 0.0;
	private double resMpfr = 0.0;
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
	public Result(Database db) {
		super(db);
	}

	// --------------------------------------------------------------

	/**
	 * Overloaded constructor.
	 * 
	 * @param db
	 *            : Database object
	 * @param idRes
	 *            : Identification number
	 * @param params
	 *            : Parameters for this result
	 * @param resInit
	 *            : Initialize result
	 * @param resOpt
	 *            : Optimal result
	 * @param resMpfr
	 *            : MPFR result
	 * @param fkRun
	 *            : Foreign Key to Runner id
	 */
	public Result(Database db, int idRes, String params, double resInit, double resOpt, double resMpfr, int fkRun) {
		super(db);
		this.idRes = idRes;
		this.params = params;
		this.resInit = resInit;
		this.resOpt = resOpt;
		this.resMpfr = resMpfr;
		this.fkRun = fkRun;
	}

	// ==============================================================
	// GETTERS & SETTERS
	// ==============================================================

	public int getIdRes() {
		return idRes;
	}

	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}

	// --------------------------------------------------------------

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	// --------------------------------------------------------------

	public double getResInit() {
		return resInit;
	}

	public void setResInit(double resInit) {
		this.resInit = resInit;
	}

	// --------------------------------------------------------------

	public double getResOpt() {
		return resOpt;
	}

	public void setResOpt(double resOpt) {
		this.resOpt = resOpt;
	}

	// --------------------------------------------------------------

	public double getResMpfr() {
		return resMpfr;
	}

	public void setResMpfr(double resMpfr) {
		this.resMpfr = resMpfr;
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
	 * Add one entry into Runner table based on current attributes.
	 */
	public void addEntry() {
		try {
			PreparedStatement preparedStatement = super.getConnection().prepareStatement(
					"INSERT INTO Result (params, res_init, res_opt, res_mpfr, fk_run) VALUES(?,?,?,?,?)");
			preparedStatement.setString(1, this.getParams());
			preparedStatement.setDouble(2, this.getResInit());
			preparedStatement.setDouble(3, this.getResOpt());
			preparedStatement.setDouble(4, this.getResMpfr());
			preparedStatement.setInt(5, this.getFkRun());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Add one entry into Result table based on current attributes. Overloaded
	 * methods. Update the current object. The id_res is automatically generate.
	 * 
	 * @param params
	 *            : Parameters for this result
	 * @param resInit
	 *            : Initial result
	 * @param resOpt
	 *            : Optimal result
	 * @param resMpfr
	 *            : MPFR result
	 * @param fkRun
	 *            : Foreign Key to Runner id
	 */
	public void addEntry(String params, Double resInit, Double resOpt, Double resMpfr, int fkRun) {
		try {
			PreparedStatement preparedStatement = super.getConnection().prepareStatement(
					"INSERT INTO Result (params, res_init, res_opt, res_mpfr, fk_run) VALUES(?,?,?,?,?)");
			preparedStatement.setString(1, params);
			preparedStatement.setDouble(2, resInit);
			preparedStatement.setDouble(3, resOpt);
			preparedStatement.setDouble(4, resMpfr);
			preparedStatement.setInt(5, fkRun);
			preparedStatement.executeUpdate();
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
			PreparedStatement preparedStatement = super.getConnection().prepareStatement(
					"UPDATE Result SET params=?, res_init=?, res_opt=?, res_mpfr=?, fk_run=? WHERE id_res=?");
			preparedStatement.setString(1, this.getParams());
			preparedStatement.setDouble(2, this.getResInit());
			preparedStatement.setDouble(3, this.getResOpt());
			preparedStatement.setDouble(4, this.getResMpfr());
			preparedStatement.setInt(5, this.getFkRun());
			preparedStatement.setInt(6, this.getIdRes());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Delete one entry from Result table based on current attributes.
	 */
	public void deleteEntry() {
		try {
			PreparedStatement preparedStatement = super.getConnection()
					.prepareStatement("DELETE FROM Result WHERE id_res=?");
			preparedStatement.setDouble(1, this.getIdRes());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Test if there is data based on idRun into Runner table.
	 * 
	 * @param idRes
	 *            : Identification number
	 * @return
	 */
	public boolean isResultExists(int idRes) {

		// Execute query
		ResultSet resultSet = super.query("SELECT * FROM Result WHERE id_run=" + idRes);

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
	 * @param idRes
	 *            : Identification number
	 */
	public void updateRunnerObject(int idRes) {

		// Execute query
		ResultSet resultSet = super.query("SELECT * FROM Result WHERE id_res=" + idRes);

		try {

			// If there is a result
			if (!resultSet.isClosed()) {
				this.setIdRes(resultSet.getInt("id_run"));
				this.setParams(resultSet.getString("params"));
				this.setResInit(resultSet.getDouble("res_init"));
				this.setResOpt(resultSet.getDouble("res_opt"));
				this.setResMpfr(resultSet.getDouble("res_mpfr"));
				this.setFkRun(resultSet.getInt("fk_run"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------

	/**
	 * Get all entries from table Result.
	 * 
	 * @param db
	 *            : Database object
	 * @return list of Runner objects
	 */
	public ArrayList<Result> getEntries(Database db) {

		// Init returner list
		ArrayList<Result> listRunners = new ArrayList<Result>();

		// Query
		ResultSet resultSet = super.query("SELECT * FROM Result");
		try {
			while (resultSet.next()) {
				listRunners.add(new Result(db, resultSet.getInt("id_res"), resultSet.getString("params"),
						resultSet.getDouble("res_init"), resultSet.getDouble("res_opt"),
						resultSet.getDouble("res_mpfr"), resultSet.getInt("fk_run")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listRunners;
	}

	// --------------------------------------------------------------

	/**
	 * Get all entries from table Result.
	 * 
	 * @param db
	 *            : Database object
	 * @return list of Runner objects
	 */
	public ArrayList<Result> getEntriesWhere(Database db, String condition) {

		// Init returner list
		ArrayList<Result> listRunners = new ArrayList<Result>();

		String query = "SELECT * FROM Result WHERE " + condition;

		// Query
		ResultSet resultSet = super.query(query);
		try {
			while (resultSet.next()) {
				listRunners.add(new Result(db, resultSet.getInt("id_res"), resultSet.getString("params"),
						resultSet.getDouble("res_init"), resultSet.getDouble("res_opt"),
						resultSet.getDouble("res_mpfr"), resultSet.getInt("fk_run")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listRunners;
	}
	
	// --------------------------------------------------------------

	/**
	* Get all entries from table Runner.
	* 
	* @param db
	*            : Database object
	* @return list of Runner objects
	*/
	public boolean getEntrieByIdRun(int idRun) {
		// Query
		ResultSet resultSet = super.query("SELECT * FROM Result WHERE fk_run="+idRun);
        try {
	        // Si il y a un resultat
	        if(!resultSet.isClosed()){
	        	this.setIdRes(resultSet.getInt("id_res")); 
	        	this.setParams(resultSet.getString("params"));
	        	this.setResInit(resultSet.getDouble("res_init"));
	        	this.setResOpt(resultSet.getDouble("res_opt"));
	        	this.setResMpfr(resultSet.getDouble("res_mpfr"));
	        	this.setFkRun(resultSet.getInt("fk_run"));

	        	return true; // Ligne trouvée
	        }
	        // Aucun resultat
	        else return false;	
        } catch (SQLException e) { e.printStackTrace(); }

	    return false; // Ligne non trouvée
	}

	// --------------------------------------------------------------

	/**
	 * Remove all rows from Result table
	 */
	public void clearResult() {

		try {
			PreparedStatement preparedStatement = super.getConnection().prepareStatement("DELETE FROM Result");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// --------------------------------------------------------------

	@Override
	public String toString() {
		return "{" 
				+ "'id_res':" + this.idRes + ", " 
				+ "'params':" + this.params + ", " 
				+ "'res_opt':" + this.resOpt + ", "
				+ "'res_mpfr':" + this.resMpfr + ", " 
				+ "'fk_run':" + this.fkRun + "}";
	}

}
