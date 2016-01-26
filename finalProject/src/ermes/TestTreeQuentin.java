package ermes;

import structure.PVirg;
import structure.SimpleNodeA;
import structure.Function;
import structure.terminal.Variable;
import structure.affectation.Affectation;
import structure.terminal.Constante;
import java.util.ArrayList;


public class TestTreeQuentin{

	public static SimpleNodeA BrowseTree(SimpleNodeA myNode){
		
		/**
		 * Fils Gauche ou Droit
		 */
		// myNode est un PVirg (il a un fils gauche)
		if(myNode instanceof PVirg){
			// Fils Gauche
			if(((PVirg)myNode).Fg() != null) BrowseTree(((PVirg)myNode).Fg()); 
			
			// Fils Droit
			// Traitement si le fils droite est null pour un Pvirg
			if(((PVirg)myNode).Fd() == null) return null;
			// Renvoi le noeud du fils droit afin qu'ils soient traités par la fonction
			else BrowseTree(myNode); 
		}
		// myNode est une fonction (pas de fils gauche ou droite mais un content)
		if(myNode instanceof Function){
			// Ecrit le debut de la fonction (type, nom, params)
			System.out.println(); // Type de retour de la fonction
			System.out.println(); // Nom de la fonction
			System.out.println(); // Paramètre de la fonction
			
			// Traitement du contenu de la fonction
			if(((Function)myNode).getContent() != null) BrowseTree(((Function) myNode).getContent()); 
			
			// Ecrit la valeur de retour de la fonction une fois que le contenu soit ecrit
			System.out.println(((Function)myNode).getReturnedValue().getTypeDef()); // Type de la variable de retour
			System.out.println(((Function)myNode).getReturnedValue().getName());  // Nom de la variable de retour
			System.out.println(((Function)myNode).getReturnedValue().getRange()); // Valeur de la variable de retour
		}
		// myNode est une Affectation (gauche variable)
		if(myNode instanceof Affectation){
			// Traitement du fils gauche de l'affectation (Variable)
			if(((Affectation)myNode).Fg() != null) BrowseTree(((Affectation) myNode).Fg());
			
			// Ecrit le signe de l'affectation
			System.out.println("="); 
			
			// Traitement du fils droit de l'affectation (Constante)
			if(myNode instanceof Constante)	System.out.println(((Constante) myNode).getRange()); // Ecrit la valeur de la variable
		}
		
		/**
		 * Traitement
		 */
		// myNode est une variable (type, nom, valeur)
		if(myNode instanceof Variable){
			System.out.println(((Variable)myNode).getTypeDef()); // Affiche le type de la variable
			System.out.println(((Variable)myNode).getName()); // Affiche le nom de la variable
			System.out.println(((Variable)myNode).getRange()); // Affiche la valeur de la variable
			return null; // Retour null
		}
		
		return null;
	}
	
	public static void main ( String args [ ] ) {

		System.out.println("Hello world !");
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
		range[0] = 2;
		range[1] = 2;
		aff.setFD(new Constante(range2));

		
		BrowseTree(Code);

	}

}
