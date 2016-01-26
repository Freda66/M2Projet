package ermes;

import structure.PVirg;
import structure.SimpleNodeA;
import structure.Function;
import structure.terminal.Variable;
import structure.affectation.Affectation;
import structure.terminal.Constante;
import java.util.ArrayList;


public class TestTreeQuentin{
	
	static ArrayList<String> listVariables = new ArrayList<String>();
	
	public static void BrowseTree(SimpleNodeA myNode){
		
		// myNode est un PVirg (il a un fils gauche)
		if(myNode instanceof PVirg){
			// Fils Gauche
			if(((PVirg)myNode).Fg() != null) BrowseTree(((PVirg)myNode).Fg()); 
			
			// Fils Droit
			// Traitement si le fils droite est null pour un Pvirg
			if(((PVirg)myNode).Fd() == null) {}//return null;
			// Renvoi le noeud du fils droit afin qu'ils soient traités par la fonction
			else BrowseTree(((PVirg)myNode).Fd());  
		}
		
		// myNode est une fonction (pas de fils gauche ou droite mais un content)
		if(myNode instanceof Function){
			// Ecrit le debut de la fonction (type, nom, params)
			System.out.print(((Function) myNode).getReturnedValue().getTypeDef() + " "); // Type de retour de la fonction
			System.out.print(((Function) myNode).getName()); // Nom de la fonction
			System.out.print("(");

			ArrayList<Variable> lesParams = ((Function) myNode).getParams();
			int nbIteration = 0;
			for(Variable param : lesParams){
				nbIteration++;

				if(listVariables.contains(param.getName()) == false){
					listVariables.add(param.getName()); // Ajoute la variable a la liste
				}
				System.out.print(param.getTypeDef() + " "); // Affiche le type de la variable
				System.out.print(param.getName()); // Affiche le nom de la variable
				if(nbIteration < lesParams.size()) System.out.print(", ");
			}
			System.out.print(") {");
			
			// Traitement du contenu de la fonction
			if(((Function)myNode).getContent() != null) BrowseTree(((Function) myNode).getContent()); 
			
			// Ecrit la valeur de retour de la fonction une fois que le contenu soit ecrit
			System.out.print("\nreturn ");
			System.out.print(((Function)myNode).getReturnedValue().getName() + ";\n}");  // Nom de la variable de retour
		}
		
		// myNode est une Affectation (gauche variable)
		if(myNode instanceof Affectation){
			// Traitement du fils gauche de l'affectation (Variable)
			if(((Affectation)myNode).Fg() != null) BrowseTree(((Affectation) myNode).Fg());
			
			// Ecrit le signe de l'affectation
			System.out.print("= "); 
			
			// Fils droit de l'affectation (Constante)
			if(((Affectation)myNode).Fd() != null) BrowseTree(((Affectation) myNode).Fd());
			
			System.out.print(";");
		}

		// myNode est une variable (type, nom, valeur)
		if(myNode instanceof Variable){
			if(listVariables.contains(((Variable)myNode).getName()) == false){
				listVariables.add(((Variable)myNode).getName()); // Ajoute la variable a la liste
				System.out.print("\n"+((Variable)myNode).getTypeDef() + " "); // Affiche le type de la variable
				System.out.print(((Variable)myNode).getName()); // Affiche le nom de la variable
				System.out.print(";");
			} else {
				System.out.print("\n"+((Variable)myNode).getName() + " "); // Affiche le nom de la variable	
			}
		}
		
		// myNode est une constante Traitement du fils droit de l'affectation (Constante)
		if(myNode instanceof Constante)	
		{
			float[] range = ((Constante) myNode).getRange();
			System.out.print(range[0]); // Ecrit la valeur de la variable 
		}
		
	}
	
	public static void main ( String args [ ] ) {
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

		listVariables.clear();
		BrowseTree(Code);

	}

}
