import db.Database;

public class Main {
 
    public static void main(String[] args) {
    	// Connexion à la bdd
        Database db = new Database("../db/PrecisionNumerique.db");
        db.connect(); 
        
        // Déconnexion de la bdd
        db.close();
    }
 
}