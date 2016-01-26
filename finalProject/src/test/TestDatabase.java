package test;

import java.sql.Timestamp;
import java.util.Date;

import data.Database;
import data.Result;
import data.Runner;
import data.Variable;

/**
 * This class contains main method to test Database access
 * 
 * @author pev
 * @version 1.0.0
 *
 */
public class TestDatabase {

	public static void main(String[] args) {

		System.out.println("========== TEST BDD IN ==========");

		// --------------------------------------------------------------

		System.out.println("Init process ----------");

		System.out.println("\tCreate Database object");
		Database db = new Database("db/database2.db");

		System.out.println("\tDatabase connection");
		db.connect();

		System.out.println("\tCreate Runner table object");
		Runner run = new Runner(db);

		System.out.println("\tCreate Variables table object");
		Variable var = new Variable(db);

		System.out.println("\tCreate Result table object");
		Result res = new Result(db);

		// --------------------------------------------------------------

		System.out.println("Runner process ----------");

		System.out.println("\tAdd Runner entry");
		Date date = new Date();
		run.addEntry(new Timestamp(date.getTime()), new Timestamp(date.getTime()));
		System.out.println(run.toString());
		run.addEntry(new Timestamp(date.getTime()), new Timestamp(date.getTime()));
		System.out.println(run.toString());

		System.out.println("\tAdd Variables entry");
		var.addEntry("tagada", 0, 10);
		System.out.println(var.toString());
		var.addEntry("banana", 20, 30);
		System.out.println(var.toString());

		System.out.println("\tAdd Result entry");
		res.addEntry("{e: 10}", 1.10, 1.20, 1.30, run.getIdRun());
		System.out.println(var.toString());
		res.addEntry("{e: 15}", 1.15, 1.25, 1.35, run.getIdRun());
		System.out.println(var.toString());

		// --------------------------------------------------------------

		System.out.println("Update process ----------");

		System.out.println("\tEdit Runner entry");
		System.out.println(run.toString());
		run.setTimeIn(new Timestamp(date.getTime()));
		run.updateEntry();
		System.out.println(run.toString());

		System.out.println("\tEdit Variables entry");
		System.out.println(var.toString());
		var.setName("nounours");
		var.updateEntry();
		System.out.println(var.toString());

		System.out.println("\tEdit Result entry");
		System.out.println(res.toString());
		res.setResMpfr(10.23);
		res.updateEntry();
		System.out.println(res.toString());

		// --------------------------------------------------------------
		
		System.out.println("Remove process ----------");

		System.out.println("\tDelete Runner entry");
		run.deleteEntry();

		System.out.println("\tDelete Variables entry");
		var.deleteEntry();

		System.out.println("\tDelete Result entry");
		res.deleteEntry();
		
		// --------------------------------------------------------------

		System.out.println("Clear Database ----------");

		System.out.println("\tRemove all entries in Runner");
		run.clearRunner();
		
		System.out.println("\tRemove all entreies in Variable");
		var.clearVariable();
		
		System.out.println("\tRemove all entries in Result");
		res.clearResult();

		// --------------------------------------------------------------
		
		System.out.println("========== TEST BDD OUT =========");

	}

}
