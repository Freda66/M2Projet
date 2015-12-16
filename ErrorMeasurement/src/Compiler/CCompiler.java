package Compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import db.Database;
import db.Measurement;

public class CCompiler {

	/**
	 * Attributs de la classe
	 */
	public String fileName;
	public File dir;
	public String exeName;
	
	/**
	 * Constructeur surchargé
	 * @param f : Nom du fichier c
	 * @param dir : Repertoire du fichier
	 */
	public CCompiler(String f, File dir)
	{
		this.fileName=f;
		this.dir=dir;
		this.exeName = fileName.substring(0, fileName.length() - 2);
	}
	
	/**
	 * Fonction qui compile le fichier c
	 */
	public void Compile()
	{
		try {
			// Compile le fichier c
            Runtime.getRuntime().exec("gcc " + fileName + " -o " + exeName, null, dir);
        } catch (IOException e) {  
            e.printStackTrace();  
        }
		System.out.println("Compile succès.");
	}
	
	/**
	 * Fonction qui execute le fichier c
	 */
	public void Execute()
	{
		System.out.println("Execution programme "+ exeName + " en cours.");
		
		try {
			// Connexion à la bdd
			Database db = new Database("../db/PrecisionNumerique.db");
	        db.connect();
			Measurement measurement = new Measurement(db);
			System.out.println("");
	        
			// Execute le programme c
            Process p = Runtime.getRuntime().exec("./"+exeName, null, dir);
            
            // Lit les print du programme
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            // Chaine de lecture des valeurs du programme
            String line = null;
            // Parcours l'affichage du programme
            while ((line = in.readLine()) != null) {
            	// Appel la fonction qui gère les lignes du programme
            	HandlePrintProgramme(measurement, line);
            }
            
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
		
		System.out.println("\nExecution programme "+ exeName + " terminé.\n");
	}
	
	/**
	 * Fonction qui gère les lignes du programmme c
	 * Affiche dans la console la ligne OU
	 * Parse la chaine, puis insert les données dans la table Measurement de la bdd
	 * @param line
	 */
	public void HandlePrintProgramme(Measurement measurement, String line){
		// Initialise les variables
		String[] lineSplit;

		// Si la ligne est destiné à la bdd
    	if(line.contains("BDDMeasurement")){
    		// Recupere la partie droite de la chaine (nomVar, min, max)
    		lineSplit = line.split(":")[1].split(";");
    		// Rempli l'objet Measurement
    		measurement.setNomVar(lineSplit[0]);
    		measurement.setMin(Double.parseDouble(lineSplit[1]));
    		measurement.setMax(Double.parseDouble(lineSplit[2]));
    		// Insert les données dans la table Measurement de la bdd
    		measurement.addMeasurement();
    	} else {
            System.out.println(line);
    	}  
	}
	
}