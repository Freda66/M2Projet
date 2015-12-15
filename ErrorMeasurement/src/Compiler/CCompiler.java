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
		/*
		try {  
            String exeName = fileName.substring(0, fileName.length() - 2);
            //Process p = Runtime.getRuntime().exec("gcc " + fileName + " -o " + exeName, null, dir);
            Process p = Runtime.getRuntime().exec("mkdir " + fileName, null, dir); 
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } */
		/*
		try {
		    // Execute a command with an argument that contains a space
		    String[] commands = new String[]{"grep", "hello world", "/tmp/f.txt"};
		     
		    commands = new String[]{"grep", "hello world", 
		            "/home/gaellic/Documents/f.txt"};
		             
		    Process child = Runtime.getRuntime().exec(commands);
		     
		} catch (IOException e) {
		}*/
		System.out.println("Compile!");

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName="helloWorld.c";
		File dir = new File("/home/gaellic/workspace/M2Projet/ErrorMeasurement/bin/Compiler");
		CCompiler test = new CCompiler(fileName,dir);
		test.Compile();
		
		Runtime runtime = Runtime.getRuntime();
		String[] arg = { "/bin/sh", "-c", "ls / >fichier.txt" };
		try {
			final Process process = runtime.exec(arg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("sa marche!");
		

	}

}