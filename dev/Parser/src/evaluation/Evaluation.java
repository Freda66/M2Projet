package evaluation;

import structure.NodeA;
import structure.SimpleNodeA;
import structure.operator.*;
import structure.terminal.*;

public class Evaluation {

	// Fonction d'evaluation de l'arbre
	public float[] Eval(SimpleNodeA toTest){
		float[] retour= new float[2];
		SimpleNodeA tmp=toTest;
		Terminal value;
		float[] range1= new float[2];
		float[] range2= new float[2];

		// Parcours de l'arbre de facon recursive
		if (tmp instanceof NodeA){
			if(((NodeA) tmp).eval == null){
				((NodeA) tmp).eval=new float[2];
				
				// Fil Gauche
				if(((NodeA) tmp).fg instanceof NodeA){
					range1=Eval(((NodeA) tmp).fg);
					System.out.println(range1[0]+" "+range1[1]);
				}else if (((NodeA) tmp).fg instanceof Terminal){
					value=(Terminal) ((NodeA) tmp).fg;
					range1=value.getRange();
					System.out.println(range1[0]+" "+range1[1]);
				}
				
				//Fil Droit
				if(((NodeA) tmp).fd instanceof NodeA){
					range2=Eval(((NodeA) tmp).fd);
					System.out.println(range2[0]+" "+range2[1]);
				}else if (((NodeA) tmp).fd instanceof Terminal){
					value=(Terminal) ((NodeA) tmp).fd;
					range2=value.getRange();
					System.out.println(range2[0]+" "+range2[1]);
				}
				if(tmp instanceof Operator){
					System.out.println("Operation");
					retour=((Operator) tmp).Eval(range1, range2);
				}
				((NodeA) tmp).eval=retour;
			}
		}
		return retour;
	}
	
	// Main de Test
	public static void main(String args[]){
		Evaluation test=new Evaluation();
		float[] testRange=new float[2];

		// Niveau 1
		Operator tmp=new Multiplication();
		testRange[0]=2;
		testRange[1]=2;
		tmp.fd=new Constante(testRange);
		testRange=new float[2];
		testRange[0]=3;
		testRange[1]=3;
		tmp.fg=new Constante(testRange);
		
		//Niveau 0
		Operator tmp2=new Plus();
		testRange=new float[2];
		testRange[0]=5;
		testRange[1]=5;
		tmp2.fd=new Constante(testRange);
		tmp2.fg=tmp;
		
		testRange=test.Eval(tmp2);
		System.out.println(testRange[0]+ " "+testRange[1]);

	}
}
