package ermes;

import data.Database;
import data.Measurement;
import data.Resultat;

public class TestBddJavaFred {
 
    public static void main(String[] args) {
    	// Connexion à la bdd
        Database db = new Database("../db/PrecisionNumerique.db");
        db.connect(); 
        System.out.println();
        
        /**
         * MEASUREMENT
         */
        System.out.println();
        System.out.println("MEASUREMENT");
        // Objet Measurement
        Measurement measurement = new Measurement(db);

        // Insert
        measurement.setNomVar("testInsert");
        measurement.setMin(1.0);
        measurement.setMax(6.0);
        measurement.addMeasurement();
        
        // Update
        measurement.setNomVar("testUpdate");
        measurement.setMin(1.0);
        measurement.setMax(6.0);
        measurement.setId(3);
        measurement.updateMeasurement();
        
        // Get measurement id 2
        measurement.getMeasurementById(2);
        measurement.printObject();
        System.out.println();

        // Get measurement nomVar toto
        measurement.getMeasurementByNomVar("toto");
        measurement.printObject();
        System.out.println();
        
        // Get Liste Measurement
        for(Measurement m : measurement.getListeMeasurement(db)){
        	System.out.println("Var:"+ m.getNomVar() + ", min:max["+ m.getMin() + ":"+ m.getMax() +"]");
        }
        System.out.println();
        
        /**
         * RESULTAT
         */
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
    }
 
}