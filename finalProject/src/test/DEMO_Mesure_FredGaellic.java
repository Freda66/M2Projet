package test;

import structure.PVirg;
import structure.Function;
import structure.terminal.Variable;
import structure.affectation.Affectation;
import structure.terminal.Constante;

import java.util.ArrayList;

import ermes.Ermes;


public class DEMO_Mesure_FredGaellic {
	
	static ArrayList<String> listVariables = new ArrayList<String>();
	
	public static void main ( String args [ ] ) {
		// Genere l'arbre de test
		PVirg arbre = Arbre();
		
		/**
		 * Initialise un objet Ermes
		 * @param "demo_mesure" : Nom du programme génèré
		 * @param "res" : Répertoire des tests
		 * @param arbre : Arbre de génération
		 * @param "fileParams.txt" : Fichier des paramètres 
		 */
		Ermes ermes = new Ermes("demo_mesure","res", arbre, "fileParams.txt");

		// Execute le Run pour le fichier d'origine
		ermes.RunErmes();
		
		// Recupere un arbre optimisé 
		//arbre = ArbreOpt();
		
		// Execute le Run pour le fichier optimisé
		//ermes.RunErmesOpt(arbre);
	}
	
	public static PVirg Arbre(){
		PVirg Code = new PVirg();
		Function fct1 = new Function();
		
		Code.setFD(null);
		Code.setFG(fct1);

		fct1.setName("main");
		ArrayList<Variable> fct1Params = new ArrayList<Variable>();
		float[] range = new float[2];
		range[0] = -1;
		range[1] = -1;
		
		Variable fct1Param = new Variable("argc",range,"int");	
		fct1Params.add(fct1Param);
		
		Variable fct1Param2 = new Variable("argv",range,"char **");	
		fct1Params.add(fct1Param2);
		
		fct1.setParams(fct1Params); 
		Variable fct1RV = new Variable("y",range,"float");	
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
		range2[0] = 2;
		range2[1] = 2;
		aff.setFD(new Constante(range2));
		
		return Code;
	}

}
