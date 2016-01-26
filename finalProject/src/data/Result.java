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
	
	// ==============================================================
	// METHODS
	// ==============================================================
	
	
	// --------------------------------------------------------------
	
	// --------------------------------------------------------------
	
	// --------------------------------------------------------------
	

}
