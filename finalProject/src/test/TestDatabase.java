package test;

import java.sql.Timestamp;
import java.util.Date;

import data.Database;
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

		// TODO : TestDB Create Result table object
		//System.out.println("\tCreate Result table object");

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

		// TODO : TestDB Add Result entry
		//System.out.println("\tAdd Result entry");

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

		// TODO : TestDB Edit Result entry
		//System.out.println("\tEdit Result entry");

		// --------------------------------------------------------------
		
		System.out.println("Remove process ----------");

		System.out.println("\tDelete Runner entry");
		run.deleteEntry();

		// TODO : TestDB Delete Variables entry
		System.out.println("\tDelete Variables entry");
		var.deleteEntry();

		// TODO : TestDB Delete Result entry
		//System.out.println("\tDelete Result entry");
		
		// --------------------------------------------------------------

		System.out.println("Clear Database ----------");

		System.out.println("\tRemove all entries in Runner");
		run.clearRunner();
		
		System.out.println("\tRemove all entreies in Variable");
		var.clearVariable();
		
		// TODO : TestDB Remove all entries in Result
		//System.out.println("\tRemove all entries in Result");

		// --------------------------------------------------------------
		
		System.out.println("========== TEST BDD OUT =========");

	}

}
