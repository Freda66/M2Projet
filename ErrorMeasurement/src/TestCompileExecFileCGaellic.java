import java.io.File;

import Compiler.CCompiler;

public class TestCompileExecFileCGaellic {

	public static void main(String[] args) {
		// Creer l'objet pour la compilation et l'execution du fichier
		CCompiler compiler = new CCompiler("helloWorld.c",new File("programmeC"));
		
		// Compile le fichier c
		compiler.Compile();
		
		// Execute le fichier c
		compiler.Execute();
	}
	
}