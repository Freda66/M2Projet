package ermes.dump;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DumpC {
	
	public boolean includeMpfr = false;
	public String fileName;
	public File dir;
	public String exeName;
	private String line;
	
	public DumpC(){
		
	}
	
	public DumpC(String f, File dir, boolean isMpfr)
	{
		this.fileName=f;
		this.dir=dir;
		this.exeName = fileName.substring(0, fileName.length() - 2);
		this.includeMpfr = isMpfr;
		if(includeMpfr) exeName= exeName+"_mpfr.c";
        else exeName = exeName+".c";
		
	}
	
	public void DumpInitFileC(){
		BufferedReader fis = null;
		FileWriter fos = null;
		line = "";
		
	    try
	    {
	    	// Buffer de lecture du fichier c
		    fis = new BufferedReader(new FileReader(dir+"/"+fileName));
		    // Buffer d'ecriture du nouveau fichier c
	        fos = new FileWriter(new File(dir+"/"+exeName));
	        
	        // Ecrit les include MPFR si le boolen vaut vrai dans le nouveau fichier c
	        if(includeMpfr){
		        // On met les header
		        fos.write("#include <gmp.h>\n");
		        fos.write("#include <mpfr.h>\n");
	        }
	        
	        // Lecture des données ligne par ligne
	        while((line = fis.readLine()) != null)
	        {
	        	if(line.startsWith("#")){
		        	// Ecriture les données
		            fos.write(line+"\n");
	        	}
	        }
	        fos.write("\n");
	        
        // Gestion des exeptions
		} catch (FileNotFoundException e) {
	        // Cette exception est levée si l'objet FileInputStream ne trouve aucun fichier
	        e.printStackTrace();
	     } catch (IOException e) {
	        // Celle-ci se produit lors d'une erreur d'écriture ou de lecture
	        e.printStackTrace();
	     } finally {
	        // On ferme nos flux de données dans un bloc finally pour s'assurer que ces instructions seront exécutées dans tous les cas même si une exception est levée !
	        try {
	           if (fis != null) fis.close();
	        } catch (IOException e) {
	           e.printStackTrace();
	        }
	
	        try {
	           if (fos != null) fos.close();
	        } catch (IOException e) {
	           e.printStackTrace();
	        }
	     }
	    
	}
	
	// Fonction qui ajoute une ligne au fichier
	public void addNextLine(String line, boolean newLine) {
		FileWriter fos = null;
		
		try{
			// Buffer d'ecriture fichier c
	        fos = new FileWriter(new File(dir+"/"+exeName),true); // True permet d'ajouter à la suite du fichier
			// Ecrit la ligne à la suite du fichier
			fos.write(line);
			// Saute une ligne dans le fichier
			if(newLine) fos.write("\n"); 
			
		// Gestion des exeptions
		} catch (FileNotFoundException e) {
	        // Cette exception est levée si l'objet FileInputStream ne trouve aucun fichier
	        e.printStackTrace();
	     } catch (IOException e) {
	        // Celle-ci se produit lors d'une erreur d'écriture ou de lecture
	        e.printStackTrace();
	     } finally {
	        // On ferme nos flux de données dans un bloc finally pour s'assurer que ces instructions seront exécutées dans tous les cas même si une exception est levée !
	        try {
	           if (fos != null) fos.close();
	        } catch (IOException e) {
	           e.printStackTrace();
	        }
	     }
	}	
	
}
