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

public class BrowseTreeMpfr {
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
	public BrowseTreeMpfr(String nameFile, String dir){
		// Creer le fichier c mpfr
		fileC = new DumpC(nameFile,new File(dir), true);
		// Appel la fonction qui ecrit le fichier initialement
		fileC.DumpInitFileC();
	}

	/**
	 * Fonction qui parcours un arbre
	 */
	public void BrowseTree(SimpleNodeA myNode){
		
		/*
		ligne à inserer en debut de programme.
	mpfr_set_default_prec (53); //Fixer la precision par defaut
	mpfr_set_emin (-1073); //Fixer l'exposant emin (en realite, emin-precision+2)
	mpfr_set_emax (1024); // Fixer l'exposant emax (en realite, emax+1) 
		 * */
		
		
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
				param.setTypeDef("mpfr_t");

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
			fileC.addNextLine("\treturn ",false);
			fileC.addNextLine(((Function)myNode).getReturnedValue().getName(),false); // Nom de la variable de retour
			fileC.addNextLine(";",true);
			fileC.addNextLine("}",false);
		}
		
		// myNode est une Affectation (gauche variable)
		if(myNode instanceof Affectation){
			// Traitement du fils gauche de l'affectation (Variable)
			
			//mpfr_set_d(cst1,111, MPFR_RNDN);
			fileC.addNextLine("\t"+"mpfr_set_d( ",false);
			if(((Affectation)myNode).Fg() != null) BrowseTree(((Affectation) myNode).Fg());
			
			// Ecrit le signe de l'affectation
			fileC.addNextLine(", ",false); 
			
			// Fils droit de l'affectation (Constante)
			if(((Affectation)myNode).Fd() != null) BrowseTree(((Affectation) myNode).Fd());
			
			// Fin de l'affectation + Saut de ligne
			fileC.addNextLine(",GMP_RNDN);",false);
			fileC.addNextLine("",true);
			
			// Ajoute le print d'insert dans la bdd -> inutile dans la version MPFR
			//String nameVar = ((Variable) ((Affectation) myNode).Fg()).getName(); // Recupere le nom de la variable
			//Float valueVar = ((Constante) ((Affectation) myNode).Fd()).getRange()[0]; // Recupere la valeur de la variable
			//fileC.addNextLine("\tprintf(\"BDDMeasurement:"+nameVar+";"+valueVar+"\\n\");",true);
		}

		// myNode est une variable (type, nom, valeur)
		if(myNode instanceof Variable){
			if(listVariables.contains(((Variable)myNode).getName()) == false){
				listVariables.add(((Variable)myNode).getName()); // Ajoute la variable a la liste
				fileC.addNextLine("",true);
				fileC.addNextLine("\t"+"mpfr_t"+" ",false); // Ecrit le type de la variable
				fileC.addNextLine(((Variable)myNode).getName(),false); // Affiche le nom de la variable
				fileC.addNextLine(";",true);
				fileC.addNextLine("\t"+"mpfr_init2 ("+((Variable)myNode).getName()+",256);",true);
			} else {
				fileC.addNextLine("",false); // Saute une ligne
				fileC.addNextLine(((Variable)myNode).getName() + " ",false); // Affiche le nom de la variable	
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
