package test;

import java.io.File;
import java.sql.Timestamp;

import data.Database;
import data.Runner;
import ermes.compiler.CCompiler;

public class TestCompileExecFileCGaellic {

	public static void main(String[] args) {
		// Creer l'objet pour la compilation et l'execution du fichier
		CCompiler compiler = new CCompiler("ermesMyProg.c",new File("res"));
		
		// Compile le fichier c
		if(compiler.Compile(false)){
			// Connexion à la bdd
			Database db = new Database("./db/database.db");
	        db.connect();
	        // Creer l'objet Runner
			Runner run = new Runner(db);
			// Debut du run
			run.addEntry(new Timestamp(0)); // Insert le debut du run (met à jours l'id run de lobjet)
			
			// Execute le fichier c
			compiler.Execute(run.getIdRun(), 0, "cheminFichierParams");
		}	
	}
	
}
