package ermes.treeLoop;

import java.io.File;
import java.util.ArrayList;

import ermes.dump.DumpC;
import structure.Function;
import structure.PVirg;
import structure.SimpleNodeA;
import structure.affectation.Affectation;
import structure.terminal.Constante;
import structure.terminal.Variable;

public class BrowseTreeC {
	/**
	 * Attributs de la classe
	 */
	static DumpC fileC;
	static ArrayList<String> listVariables = new ArrayList<String>();
	
	/**
	 * Constructeur surchargée
	 * @param nameFile
	 * @param dir
	 */
	public BrowseTreeC(String nameFile, String dir, boolean isOpt){
		// Creer le fichier c mpfr
		fileC = new DumpC(nameFile,new File(dir), false, isOpt);
		// Appel la fonction qui ecrit le fichier initialement
		fileC.DumpInitFileC();
	}

	/**
	 * Fonction qui parcours un arbre
	 */
	public void BrowseTree(SimpleNodeA myNode){
		
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
			fileC.addNextLine(((Function) myNode).getReturnedValue().getTypeDef() + " ", false); // Type de retour de la fonction
			fileC.addNextLine(((Function) myNode).getName(),false); // Nom de la fonction
			fileC.addNextLine("(",false);

			ArrayList<Variable> lesParams = ((Function) myNode).getParams();
			int nbIteration = 0;
			for(Variable param : lesParams){
				nbIteration++;

				if(listVariables.contains(param.getName()) == false){
					listVariables.add(param.getName()); // Ajoute la variable a la liste
				}
				fileC.addNextLine(param.getTypeDef() + " ",false); // Affiche le type de la variable
				fileC.addNextLine(param.getName(),false); // Affiche le nom de la variable
				if(nbIteration < lesParams.size()) fileC.addNextLine(", ",false);
			}
			fileC.addNextLine(") {",false);
			
			// Traitement du contenu de la fonction
			if(((Function)myNode).getContent() != null) BrowseTree(((Function) myNode).getContent()); 
			
			// Ecrit la valeur de retour de la fonction une fois que le contenu soit ecrit
			fileC.addNextLine("",true);
			
			// Stock le resultat de l'execution
			String nameVar = ((Function)myNode).getReturnedValue().getName();
			fileC.addNextLine("\tprintf(\"BDDResult:"+nameVar+";%.19f\\n\","+nameVar,false);
			fileC.addNextLine(");",true);
			
			fileC.addNextLine("\treturn ",false);
			fileC.addNextLine(((Function)myNode).getReturnedValue().getName(),false); // Nom de la variable de retour
			fileC.addNextLine(";",true);
			fileC.addNextLine("}",false);
		}
		
		// myNode est une Affectation (gauche variable)
		if(myNode instanceof Affectation){
			// Traitement du fils gauche de l'affectation (Variable)
			if(((Affectation)myNode).Fg() != null) BrowseTree(((Affectation) myNode).Fg());
			
			// Ecrit le signe de l'affectation
			fileC.addNextLine("= ",false); 
			
			// Fils droit de l'affectation (Constante)
			if(((Affectation)myNode).Fd() != null) BrowseTree(((Affectation) myNode).Fd());
			
			// Fin de l'affectation + Saut de ligne
			fileC.addNextLine(";",false);
			fileC.addNextLine("",true);
			
			// Ajoute le print d'insert dans la bdd
			String nameVar = ((Variable) ((Affectation) myNode).Fg()).getName(); // Recupere le nom de la variable
			//fileC.addNextLine("\tprintf(\"BDDVariable:"+nameVar+";%.19f\\n\","+nameVar,false);
			// EN DESSOUS A SUPPRIMER APRES LA DEMO ET AU DESSUS A DECOMMENTER
			fileC.addNextLine("\tprintf(\"BDDVariable:"+nameVar+";%.19f\\n\",("+nameVar+"+atof(argv[1]))",false);
			fileC.addNextLine(");",true);
		}

		// myNode est une variable (type, nom, valeur)
		if(myNode instanceof Variable){
			if(listVariables.contains(((Variable)myNode).getName()) == false){
				listVariables.add(((Variable)myNode).getName()); // Ajoute la variable a la liste
				fileC.addNextLine("",true);
				fileC.addNextLine("\t"+((Variable)myNode).getTypeDef()+" ",false); // Ecrit le type de la variable
				fileC.addNextLine(((Variable)myNode).getName(),false); // Affiche le nom de la variable
				fileC.addNextLine(";",false);
			} else {
				fileC.addNextLine("",true); // Saute une ligne
				fileC.addNextLine("\t"+((Variable)myNode).getName() + " ",false); // Affiche le nom de la variable	
			}
		}
		
		// myNode est une constante Traitement du fils droit de l'affectation (Constante)
		if(myNode instanceof Constante)	
		{
			float[] range = ((Constante) myNode).getRange();
			fileC.addNextLine(Float.toString(range[0]),false); // Ecrit la valeur de la variable 
		}
		
	}
}
