package ermes;

import java.io.File;
import ermes.compiler.CCompiler;

public class TestCompileExecFileCGaellic {

	public static void main(String[] args) {
		// Creer l'objet pour la compilation et l'execution du fichier
		CCompiler compiler = new CCompiler("myProg.c",new File("programmeC"));
		
		// Compile le fichier c
		compiler.Compile(false);
		
		// Execute le fichier c
		compiler.Execute();
	}
	
}
