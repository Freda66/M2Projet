package ermes;

import data.Database;
import data.Variable;
import data.Resultat;

public class TestBddJavaFred {
 
    public static void main(String[] args) {
    	
    	System.out.println("---------- TEST BDD ----------");
    	
    	// Init Database
    	System.out.println("Database initialization...");
        Database db = new Database("db/database2.db");
        
        // Connect to Database
        System.out.println("Database connection...");
        boolean testCo = db.connect();
        
        // If true connection
        if(testCo){ 
        
	        // Create Variables table
	        System.out.println("Create variable object...");
	        Variable var = new Variable(db);
        
        }

        // Insert
/*        System.out.println("Insert values...");
        var.setName("testInsert");
        var.setValueMin(1.0);
        var.setValueMax(6.0);
        var.addEntry();
        
        // Update
        var.setName("testUpdate");
        var.setValueMin(1.0);
        var.setValueMax(6.0);
        var.setIdVar(3);
        var.updateEntry();
        
        // Get measurement id 2
        var.getMeasurementById(2);
        var.printObject();
        System.out.println();

        // Get measurement nomVar toto
        var.getMeasurementByNomVar("toto");
        var.printObject();
        System.out.println();
        
        // Get Liste Measurement
        for(Variables m : var.getEntries(db)){
        	System.out.println("Var:"+ m.getName() + ", min:max["+ m.getValueMin() + ":"+ m.getValueMax() +"]");
        }
        System.out.println();
        
        *//**
         * RESULTAT
         *//*
        System.out.println();
        System.out.println("RESULTAT");
        // Objet Resultat
        Resultat resultat = new Resultat(db);

        // Insert
        resultat.setResultInit(3.23);
        resultat.setResultOpt(1.23);
        resultat.setResultMpfr(6.232);
        resultat.addResultat();
        
        // Update
        resultat.setResultInit(14.04);
        resultat.setResultOpt(1.23);
        resultat.setResultMpfr(6.232);
        resultat.setIdRun(1);
        resultat.updateResultat();
        
        // Get resultat id 1
        resultat.getResultatById(1);
        resultat.printObject();
        System.out.println();

        
        
        // Déconnexion de la bdd
        db.close();
*/        
        System.out.println("---------- END TEST BDD ----------");
    }
 
}