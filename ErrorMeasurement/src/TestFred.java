import db.Database;
import db.Measurement;
import db.Resultat;

public class TestFred {
 
    public static void main(String[] args) {
    	// Connexion à la bdd
        Database db = new Database("../db/PrecisionNumerique.db");
        db.connect(); 
        System.out.println();
        
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
        
        // Déconnexion de la bdd
        db.close();
    }
 
}