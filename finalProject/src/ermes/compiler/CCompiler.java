package ermes.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import data.Database;
import data.Measurement;

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
	public void Compile(boolean isMpfr)
	{
		try {
			// Compile le fichier c
			if(isMpfr)Runtime.getRuntime().exec("gcc " + fileName + " -o " + exeName + " -lmpfr -lgmp ", null, dir);
			else Runtime.getRuntime().exec("gcc " + fileName + " -o " + exeName, null, dir);
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
            	// Appel la fonction qui gère les lignes du programme avec la bdd
            	HandlePrintBddProgramme(measurement, line);
            }
            
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
		
		System.out.println("\nExecution programme "+ exeName + " terminé.\n");
	}
	
	/**
	 * Fonction qui gère les lignes du programmme c avec la bdd
	 * Affiche dans la console la ligne OU
	 * Parse la chaine, puis insert les données dans la table Measurement de la bdd
	 * @param line
	 */
	public void HandlePrintBddProgramme(Measurement measurement, String line){
		// Initialise les variables
		String[] lineSplit;

		// Si la ligne est destiné à la bdd
    	if(line.contains("BDDMeasurement")){
    		// Recupere la partie droite de la chaine (nomVar, val)
    		lineSplit = line.split(":")[1].split(";");

    		// Recupere le nom et la valeur de la variable
    		String nomVar = lineSplit[0];
			Double val = Double.parseDouble(lineSplit[1]);
    		
    		// Recupere l'objet measurement de la variable (si existant dans la bdd)
    		if(measurement.getMeasurementByNomVar(nomVar)){
    			// Si la valeur est inférieur à la borne min de la variable (dans la bdd) 
    			if(measurement.getMin() > val){
    				measurement.setMin(val); // Affecte la valeur à la borne min
    				measurement.updateMeasurement(); // Met à jour la variable dans la bdd
    			}
    			// Si la valeur est supérieur à la borne max de la variable (dans la bdd)
    			else if(measurement.getMax() < val){
    				measurement.setMax(val); // Affecte la valeur à la borne max
        			measurement.updateMeasurement(); // Met à jour la variable dans la bdd
    			} 
    		} 
    		// Ajout la variable dans la bdd
    		else {
    			// Rempli l'objet Measurement
        		measurement.setNomVar(nomVar);
        		measurement.setMin(val);
        		measurement.setMax(val);
        		// Insert les données dans la table Measurement de la bdd
        		measurement.addMeasurement();
    		}
    	} else {
            System.out.println(line);
    	}  
	}
	
}