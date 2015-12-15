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
            Process p = Runtime.getRuntime().exec("cmd /C gcc " + fileName + " -o " + exeName, null, dir);   
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("sa marche!");
		String fileName="helloWorld.c";
		File dir = new File("/ProgramC");
		CCompiler test = new CCompiler(fileName,dir);
		test.Compile();
		

	}

}