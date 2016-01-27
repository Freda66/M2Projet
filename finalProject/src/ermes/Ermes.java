package ermes;

import java.io.File;

import ermes.compiler.CCompiler;
import ermes.treeLoop.BrowseTreeC;
import ermes.treeLoop.BrowseTreeMpfr;
import structure.PVirg;

public class Ermes {
	private boolean isMpfr; // Fichier pour le traitement MPFR
	private String nameFileC; // Nom du fichier c
	private String dirFileC; // Nom du repertoire du fichier c
	private PVirg tree; // Arbre
	
	/**
	 * Constructeur par defaut
	 */
	public Ermes(){
		this.setMpfr(false);
	}
	
	/**
	 * Constructeur surchargee 
	 * @param nameFile : nom du fichier c
	 * @param dir : repertoire du fichier c
	 * @param t : arbre
	 */
	public Ermes(String nameFile, String dir, PVirg t){
		this.setNameFileC(nameFile);
		this.setDirFileC(dir);
		this.setTree(t);
		this.setMpfr(false);
	}
	
	/**
	 * Fonction qui 
	 * - Genère le fichier c avec les insert bdd 
	 * - Genère le fichier mpfr avec les insert bdd
	 * - Compile le fichier c
	 * - Execute le fichier c
	 * - Compile le fichier mpfr
	 * - Execute le fichier mpfr
	 * @return true or false : en fonction du bon deroulement du la fonction
	 */
	public boolean RunErmes(){
		try{
			/**
			 * Fichier c initiale
			 */
			// Initialise le fichier c init a génèrer
			BrowseTreeC browserTree = new BrowseTreeC(nameFileC+".c",dirFileC, false);
			
			// Parcours l'arbre et génère le nouveau fichier c
			browserTree.BrowseTree(tree);
			
			// Creer l'objet pour la compilation et l'execution du fichier
			CCompiler compiler = new CCompiler(nameFileC+"_init.c",new File(dirFileC));
			
			// Compile le fichier c
			if(compiler.Compile(false)) compiler.Execute();
			
			/**
			 * Fichier c mpfr
			 */
			// Initialise le fichier mpfr a génèrer
			BrowseTreeMpfr browserTreeMpfr = new BrowseTreeMpfr(nameFileC+"_mpfr.c",dirFileC);
			
			// Parcours l'arbre et génère le nouveau fichier mpfr
			browserTreeMpfr.BrowseTree(tree);
			
			// Creer l'objet pour la compilation et l'execution du fichier
			CCompiler compilerMpfr = new CCompiler(nameFileC+"_mpfr.c",new File(dirFileC));
			
			// Compile le fichier mpfr
			if(compilerMpfr.Compile(true)) compilerMpfr.Execute();
		} catch(Exception e){
			return false;
		}
				
		return true;
	}

	/**
	 * Fonction qui 
	 * - Genère le fichier c optimisé avec les insert bdd 
	 * - Compile le fichier c optimisé 
	 * - Execute le fichier c optimisé 
	 * @return true or false : en fonction du bon deroulement du la fonction
	 */
	public boolean RunErmesOpt(PVirg t){
		// Met à jours l'arbre
		this.setTree(t);
	
		try{
			/**
			 * Fichier c optimisé
			 */
			// Initialise le fichier c optimisé a génèrer
			BrowseTreeC browserTree = new BrowseTreeC(nameFileC+".c",dirFileC, true);
			
			// Parcours l'arbre et génère le nouveau fichier c optimisé
			browserTree.BrowseTree(tree);
			
			// Creer l'objet pour la compilation et l'execution du fichier optimisé
			CCompiler compiler = new CCompiler(nameFileC+"_opt.c",new File(dirFileC));
			
			// Compile le fichier c
			if(compiler.Compile(false)) compiler.Execute();
		} catch(Exception e){
			return false;
		}
				
		return true;
	}

	
	/**
	 * *******************
	 * Getteurs / Setteurs
	 * *******************
	 */
	public String getDirFileC() {
		return dirFileC;
	}

	public void setDirFileC(String dirFileC) {
		this.dirFileC = dirFileC;
	}

	public boolean isMpfr() {
		return isMpfr;
	}

	public void setMpfr(boolean isMpfr) {
		this.isMpfr = isMpfr;
	}

	public String getNameFileC() {
		return nameFileC;
	}

	public void setNameFileC(String nameFileC) {
		this.nameFileC = nameFileC;
	}

	public PVirg getTree() {
		return tree;
	}

	public void setTree(PVirg tree) {
		this.tree = tree;
	}
}
