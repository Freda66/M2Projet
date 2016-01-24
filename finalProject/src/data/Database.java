package data;

/**
 * Importe les librairies sql
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	/**
	 * Attributs de la classe
	 */
    protected String DBPath; // Chemin de la bdd sqlite
    protected Connection connection = null;
    protected Statement statement = null;
 
    /**
     * Constructeur qui initialise l'objet pour les enfants de la classe
     * @param p : DBPath
     * @param c : Connection
     * @param s : Statement
     */
    public Database(Database db) {
    	DBPath = db.getDBPath();
    	connection = db.getConnection();
    	statement = db.getStatement();
    }
    
    /**
     * Constructeur surchargé
     * @param dBPath : Chemin de la bdd
     */
    public Database(String dBPath) {
        DBPath = dBPath;
    }
 
    /**
     * Fonction de connexion à la bdd
     */
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succès");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connexion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connexion");
        }
    }
 
    /**
     * Fonction de deconnexion à la bdd
     */
    public void close() {
        try {
            statement.close();
            connection.close();
            System.out.println("Déconnexion a " + DBPath + " avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de déconnexion");
        }
    }
    
    /**
     * Fonction qui permet l'execution d'une requete sql dans la bdd et renvoi le resultat
     * @param requet : Requete sql (String)
     * @return resultat : Resultat de la requete sql
     */
    public ResultSet query(String requet) {
        ResultSet resultat = null;
        try {
            resultat = statement.executeQuery(requet);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requet : " + requet);
        }
        return resultat;
    }
    
    // Getteurs bdd
    public String getDBPath() {
		return DBPath;
    }
    public Connection getConnection() {
		return connection;
    }
    public Statement getStatement() {
		return statement;
    }
    
}