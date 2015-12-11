import db.Database;

public class Main {
 
    public static void main(String[] args) {
        Database connexion = new Database("Database.db");
        connexion.connect();
        connexion.close();
    }
 
}