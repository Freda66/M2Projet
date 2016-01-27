package ermes.parserC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParserMpfr {

	
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
	public ParserMpfr(String f, File dir)
	{
		this.fileName=f;
		this.dir=dir;
		this.exeName = fileName.substring(0, fileName.length() - 2);
	
	}
	
	/**
	 * Fonction qui parse le fichier c, remplace les float par des mpfr
	 */
	public void parse()
	{
		BufferedReader fis = null;
		FileWriter fos = null;
	    
		String ligne = "";
		
	    try
	    {
	    fis = new BufferedReader(new FileReader(dir+"/"+fileName));

        fos = new FileWriter(new File(dir+"/"+exeName+"_mpfr.c"));
        
   
        String header1 = "#include <gmp.h>\n";
        String header2 = "#include <mpfr.h>\n";

        //on met les header
        fos.write(header1);
        fos.write(header2);
        
        int i = 0;
        ligne = "";
        
        //Lecture des données ligne par ligne
        while((ligne = fis.readLine()) != null)
        {
        	//on remplace les float par des mpft
        	ligne=ligne.replace("float", "mpfr_t");
        	//ecriture des données
            fos.write(ligne+"\n");
        }
        
        
	    
        //gestion des exeptions
		} catch (FileNotFoundException e) {
	
	        // Cette exception est levée si l'objet FileInputStream ne trouve
	
	        // aucun fichier
	
	        e.printStackTrace();
	
	     } catch (IOException e) {
	
	        // Celle-ci se produit lors d'une erreur d'écriture ou de lecture
	
	        e.printStackTrace();
	
	     } finally {
	
	        // On ferme nos flux de données dans un bloc finally pour s'assurer
	
	        // que ces instructions seront exécutées dans tous les cas même si
	
	        // une exception est levée !
	
	        try {
	
	           if (fis != null)
	
	              fis.close();
	
	        } catch (IOException e) {
	
	           e.printStackTrace();
	
	        }
	
	
	        try {
	
	           if (fos != null)
	
	              fos.close();
	
	        } catch (IOException e) {
	
	           e.printStackTrace();
	
	        }

	     }
	    
	}
	

}
