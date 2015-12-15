package Compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCompiler {

	/**
	 * @param args
	 */
	
	public String fileName;
	public File dir;
	
	public CCompiler(String f, File dir)
	{
		this.fileName=f;
		this.dir=dir;
	}
	
	
	void Compile()
	{
		
		try {  
            String exeName = fileName.substring(0, fileName.length() - 2);
            Process p = Runtime.getRuntime().exec("gcc " + fileName + " -o " + exeName, null, dir);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
		
		System.out.println("Compile!");

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName="helloWorld.c";
		File dir = new File("programmeC");
		///home/gaellic/workspace/M2Projet/ErrorMeasurement/
		CCompiler test = new CCompiler(fileName,dir);
		test.Compile();
		

		
		System.out.print("sa marche!");
		

	}

}