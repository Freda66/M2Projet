package evaluation;

import structure.Node;
import structure.SimpleNode;
import structure.operator.*;
import structure.terminal.*;

public class Evaluation {

	// Fonction d'evaluation de l'arbre
	public float[] Eval(SimpleNode toTest){
		float[] retour= new float[2];
		SimpleNode tmp=toTest;
		Terminal value;
		float[] range1= new float[2];
		float[] range2= new float[2];

		// Parcours de l'arbre de facon recursive
		if (tmp instanceof Node){
			if(((Node) tmp).eval == null){
				((Node) tmp).eval=new float[2];
				
				// Fil Gauche
				if(((Node) tmp).fg instanceof Node){
					range1=Eval(((Node) tmp).fg);
					System.out.println(range1[0]+" "+range1[1]);
				}else if (((Node) tmp).fg instanceof Terminal){
					value=(Terminal) ((Node) tmp).fg;
					range1=value.getRange();
					System.out.println(range1[0]+" "+range1[1]);
				}
				
				//Fil Droit
				if(((Node) tmp).fd instanceof Node){
					range2=Eval(((Node) tmp).fd);
					System.out.println(range2[0]+" "+range2[1]);
				}else if (((Node) tmp).fd instanceof Terminal){
					value=(Terminal) ((Node) tmp).fd;
					range2=value.getRange();
					System.out.println(range2[0]+" "+range2[1]);
				}
				if(tmp instanceof Operator){
					System.out.println("Operation");
					retour=((Operator) tmp).Eval(range1, range2);
				}
				((Node) tmp).eval=retour;
			}
		}
		return retour;
	}
	
	// Main de Test
	public static void main(String args[]){
		Evaluation test=new Evaluation();
		float[] testRange=new float[2];
		testRange[0]=2;
		testRange[1]=10;
		Operator tmp=new Multiplication();
		tmp.fd=new Constante(testRange);
		testRange=new float[2];
		testRange[0]=3;
		testRange[1]=3;
		tmp.fg=new Constante(testRange);
		testRange=test.Eval(tmp);
		System.out.println(testRange[0]+ " "+testRange[1]);

	}
}
