package Compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

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
            Process p = Runtime.getRuntime().exec("gcc " + fileName + " -o " + exeName, null, dir);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
		
		System.out.println("Compile succès.\n");
	}
	
	/**
	 * Fonction qui execute le fichier c
	 */
	public void Execute()
	{
		System.out.println("Affichage programme "+ exeName +" : ");
		
		try {
            Process p = Runtime.getRuntime().exec("./"+exeName, null, dir);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            } 
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
		
		System.out.println("\nExecute succès.\n");
	}
	
}