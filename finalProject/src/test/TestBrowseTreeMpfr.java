package test;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;

import data.Database;
import data.Runner;
import ermes.compiler.CCompiler;
import ermes.treeLoop.BrowseTreeMpfr;
import structure.Function;
import structure.PVirg;
import structure.affectation.Affectation;
import structure.terminal.Constante;
import structure.terminal.Variable;

public class TestBrowseTreeMpfr {
		
	
	public static void main(String[] args) {
    	boolean isMpfr = true; // Fichier pour le traitement MPFR
		String nameFileC = "ermesMyProg"; // Nom du fichier c
		String dirFileC = "res"; // Nom du repertoire du fichier c
    	
		/**
    	 * Initialise le parcours de l'arbre
    	 */
		BrowseTreeMpfr t = new BrowseTreeMpfr(nameFileC+".c",dirFileC);
				
		/**
		 * ARBRE A LA MAIN
		 */
		PVirg Code = ArbreTest();
		
		/**
		 * Parcours de l'arbre et generation du nouveau fichier
		 */
		t.BrowseTree(Code);
		
		/**
		 * Compile et Execute le nouveau fichier c
		 */
		// Nom du nouveau fichier c
		String nameNewFileC;
		if(isMpfr) nameNewFileC = "dump_"+nameFileC+"_mpfr.c";
		else nameNewFileC = "dump_"+nameFileC+".c";
		// Creer l'objet pour la compilation et l'execution du fichier
		CCompiler compiler = new CCompiler(nameNewFileC,new File(dirFileC));
		
		// Compile le fichier c
		if(compiler.Compile(true)){
			// Connexion à la bdd
			Database db = new Database("./db/database.db");
	        db.connect();
	        // Creer l'objet Runner
			Runner run = new Runner(db);
			// Debut du run
			run.addEntry(new Timestamp(0)); // Insert le debut du run (met à jours l'id run de lobjet)
			
			// Execute le fichier c
			compiler.Execute(run.getIdRun(), 1, "cheminFichierParams");
		}
    }
	
	
	/**
	 * Generation d'un arbre à la main
	 */
	public static PVirg ArbreTest(){
		PVirg Code = new PVirg();
		Function fct1 = new Function();
		
		Code.setFD(null);
		Code.setFG(fct1);

		fct1.setName("main");
		ArrayList<Variable> fct1Params = new ArrayList<Variable>();
		float[] range = new float[2];
		range[0] = -1;
		range[1] = -1;
		
		//Variable fct1Param = new Variable("x",range,"float");	
		//fct1Params.add(fct1Param);
		
		//Variable fct1Param2 = new Variable("z",range,"int");	
		//fct1Params.add(fct1Param2);
		
		fct1.setParams(fct1Params); // Ajouté par Fred
		Variable fct1RV = new Variable("0",range,"int"); // y
		fct1.setReturnedValue(fct1RV);
		PVirg fct1Content = new PVirg();
		fct1.setContent(fct1Content);

		Variable var = new Variable("y",range,"float");
		fct1Content.setFG(var);
		PVirg toto = new PVirg();
		fct1Content.setFD(toto);

		Affectation aff = new Affectation();
		toto.setFD(null);
		toto.setFG(aff);

		aff.setFG(new Variable("y",range,"float"));
		float[] range2 = new float[2];
		range2[0] = (float) 2.0001; // avant range (c'est pour ca qu'on avait 0)
		range2[1] = (float) 2.0001; // avant range (c'est pour ca qu'on avait 0)
		aff.setFD(new Constante(range2));
	
		return Code;
	}
}
