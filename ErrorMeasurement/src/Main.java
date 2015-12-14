import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.Database;
import db.Measurement;
import db.Resultat;

public class Main {
 
    public static void main(String[] args) {
    	// Connexion à la bdd
        Database db = new Database("../db/PrecisionNumerique.db");
        db.connect();
        
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
        
        // Get 
        
        // Get Liste Measurement
        for(Measurement m : measurement.getListeMeasurement(db)){
        	System.out.println("Var:"+ m.getNomVar() + ", min:max["+ m.getMin() + ":"+ m.getMax() +"]");
        }
 
        // Déconnexion de la bdd
        db.close();
    }
 
}