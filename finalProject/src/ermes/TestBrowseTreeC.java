package ermes;

import java.util.ArrayList;

import ermes.treeLoop.BrowseTreeC;
import structure.Function;
import structure.PVirg;
import structure.affectation.Affectation;
import structure.terminal.Constante;
import structure.terminal.Variable;

public class TestBrowseTreeC {
	public static void main(String[] args) {
    	/**
    	 * 
    	 */
		BrowseTreeC t = new BrowseTreeC("ermesMyProg.c","res");
		
		
		/**
		 * ARBRE A LA MAIN
		 */
		PVirg Code = new PVirg();
		Function fct1 = new Function();
		
		Code.setFD(null);
		Code.setFG(fct1);

		fct1.setName("main");
		ArrayList<Variable> fct1Params = new ArrayList<Variable>();
		float[] range = new float[2];
		range[0] = -1;
		range[1] = -1;
		
		Variable fct1Param = new Variable("x",range,"float");	
		fct1Params.add(fct1Param);
		
		Variable fct1Param2 = new Variable("z",range,"int");	
		fct1Params.add(fct1Param2);
		
		fct1.setParams(fct1Params); // Ajouté par Fred
		Variable fct1RV = new Variable("y",range,"int");	
		fct1.setReturnedValue(fct1RV);
		PVirg fct1Content = new PVirg();
		fct1.setContent(fct1Content);

		Variable var = new Variable("y",range,"int");
		fct1Content.setFG(var);
		PVirg toto = new PVirg();
		fct1Content.setFD(toto);

		Affectation aff = new Affectation();
		toto.setFD(null);
		toto.setFG(aff);

		aff.setFG(new Variable("y",range,"int"));
		float[] range2 = new float[2];
		range2[0] = 2; // avant range (c'est pour ca qu'on avait 0)
		range2[1] = 2; // avant range (c'est pour ca qu'on avait 0)
		aff.setFD(new Constante(range2));
	
		
		
		/**
		 * Parcours de l'arbre et generation du nouveau fichier
		 */
		t.BrowseTree(Code);
    }
}
