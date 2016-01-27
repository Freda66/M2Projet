package test;

import java.io.File;

import ermes.dump.DumpC;

public class TestDumpC {
	 
	public static void main(String[] args) {
    	// Créer un objet dump
		DumpC fileC = new DumpC("myProg.c",new File("programmeC"), false);
    	
		// Appel la fonction qui ecrit le fichier initialement
		fileC.DumpInitFileC();	
		
		// Ajoute de ligne dans le fichier
		fileC.addNextLine("Fred", true);
		fileC.addNextLine("Gaellic", true);
		fileC.addNextLine("Pour le fun", true);
    }
	 
}
