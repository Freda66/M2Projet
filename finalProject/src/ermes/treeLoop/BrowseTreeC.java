package ermes.treeLoop;

import java.io.File;
import ermes.dump.DumpC;

public class BrowseTreeC {
	/**
	 * Attributs de la classe
	 */
	DumpC fileC;
	
	/**
	 * Constructeur surchargée
	 * @param nameFile
	 * @param dir
	 */
	public BrowseTreeC(String nameFile, String dir){
		// Creer le fichier c mpfr
		fileC = new DumpC(nameFile,new File(dir));
		// Appel la fonction qui ecrit le fichier initialement
		fileC.DumpInitFileC();
		// Appel la fonction qui parcours l'arbre
		BrowseTree();
	}

	/**
	 * Fonction qui parcours un arbre
	 */
	public void BrowseTree(){
		//fileC.addNextLine("");
	}
}
