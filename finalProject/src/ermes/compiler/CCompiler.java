package ermes.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import data.Database;
import data.Result;
import data.Variable;

public class CCompiler {

	/**
	 * Attributs de la classe
	 */
	public String fileName;
	public File dir;
	public String exeName;
	private Variable variable;
	private Result result;
	private int typeExecution; // Type de l'execution (0 prog init; 1 prog mpfr; 2 prog opt)
	
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
	public boolean Compile(boolean isMpfr)
	{
		try {
			// Compile le fichier c
			if(isMpfr)Runtime.getRuntime().exec("gcc " + fileName + " -o " + exeName + " -lmpfr -lgmp ", null, dir);
			else Runtime.getRuntime().exec("gcc " + fileName + " -o " + exeName, null, dir);
			System.out.println("Compile succès.");
			return true;
        } catch (IOException e) {  
            e.printStackTrace();
            System.out.println("Compile erreur.");
			return false;
        }
		
	}
	
	/**
	 * Fonction qui execute le fichier c
	 * @param idRun : Id du runner
	 * @param typeExec : 0 Prog init; 1 Prog Mpfr; 2 Prog Opt
	 */
	public void Execute(int idRun, int typeExec)
	{
		System.out.println("Execution programme "+ exeName + " en cours.");
		
		// Met à jours le type d'execution
		this.typeExecution = typeExec;
		
		try {
			// Connexion à la bdd
			Database db = new Database("./db/database.db");
	        db.connect();
	        // Creer un objet Variable (ancien measurement)
	        variable = new Variable(db);
			// Creer un objet Result
	        result = new Result(db);
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
            	HandlePrintBddProgramme(line, idRun);
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
	public void HandlePrintBddProgramme(String line, int idRun){
		// Initialise les variables
		String[] lineSplit;

		System.out.println(line);
		
		/**
		 * Variable
		 */
		// Si la ligne est destiné à la bdd
    	if(line.contains("BDDVariable")){
    		// Recupere la partie droite de la chaine (nomVar, val)
    		lineSplit = line.split(":")[1].split(";");

    		// Recupere le nom et la valeur de la variable
    		String nomVar = lineSplit[0];
			Double val = Double.parseDouble(lineSplit[1]);
    					
    		// Recupere l'objet measurement de la variable (si existant dans la bdd)
    		if(variable.getMeasurementByNomVar(nomVar, idRun)){
    			// Si la valeur est inférieur à la borne min de la variable (dans la bdd) 
    			if(variable.getValueMin() > val) variable.setValueMin(val); // Affecte la valeur à la borne min
    			
    			// Si la valeur est supérieur à la borne max de la variable (dans la bdd)
    			else if(variable.getValueMax() < val) variable.setValueMax(val); // Affecte la valeur à la borne max
    			
    			// Met à jour la variable dans la bdd
    			variable.updateEntry(); 
    		} 
    		// Ajout la variable dans la bdd
    		else {
    			// Rempli l'objet Measurement
    			variable.setName(nomVar);
        		variable.setValueMin(val);
        		variable.setValueMax(val);
        		variable.setFkRun(idRun);
        		// Insert les données dans la table Measurement de la bdd
        		variable.addEntry();
    		}
    	}
    	
		/**
		 * Result
		 */
		// Si la ligne est destiné à la bdd
    	else if(line.contains("BDDResult")){
    		// Recupere la partie droite de la chaine (nomVar, val)
    		lineSplit = line.split(":")[1].split(";");

    		// Recupere la valeur du resultat retourné
			Double val = Double.parseDouble(lineSplit[1]);
    		
			System.out.println(val);
			
			// Recupere l'objet result à partir de l'id du run
			if(result.getEntrieByIdRun(idRun)){
				// Resultat Initial
				if(typeExecution == 0) result.setResInit(val);
				// Resultat Mpfr
				else if(typeExecution == 1) result.setResMpfr(val);
				// Resultat Optimisé
				else result.setResOpt(val);
				
				// Met à jours les valeurs dans la bdd
				result.updateEntry();
			};
    	} 
    	
    	/**
    	 * Affiche le message sur la console
    	 */
    	else {
            System.out.println(line);
    	} 
	}
	
}