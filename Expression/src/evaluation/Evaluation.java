package evaluation;

import structure.NodeA;
import structure.SimpleNodeA;
import structure.operator.*;
import structure.terminal.*;

public class Evaluation {

	// Fonction d'evaluation de l'arbre
	public float[] Eval(SimpleNodeA toTest){
		float[] retour= new float[2];
		//SimpleNodeA toTest=toTest;
		Terminal value;
		float[] range1= new float[2];
		float[] range2= new float[2];
		
		//System.out.println(toTest.getClass().getName());
		// Parcours de l'arbre de facon recursive
		if (toTest instanceof NodeA){
			if(((NodeA) toTest).eval == null){
				((NodeA) toTest).eval=new float[2];
				
				// Fils Gauche
				if(((NodeA) toTest).fg instanceof NodeA){
					range1=this.Eval(((NodeA) toTest).fg);
					//System.out.println("Node1 "+range1[0]+" "+range1[1]);
					
				}else if (((NodeA) toTest).fg instanceof Terminal){
					value=(Terminal) ((NodeA) toTest).fg;
					range1=value.getRange();
					//System.out.println(range1[0]+" "+range1[1]);
				}
				
				//Fils Droit
				if(((NodeA) toTest).fd instanceof NodeA){
					range2=Eval(((NodeA) toTest).fd);
					//System.out.println("Node2 "+range2[0]+" "+range2[1]);
					
				}else if (((NodeA) toTest).fd instanceof Terminal){
					value=(Terminal) ((NodeA) toTest).fd;
					range2=value.getRange();
					//System.out.println(range2[0]+" "+range2[1]);
				}
				
				if(toTest instanceof Operator){
					retour=((Operator) toTest).Eval(range1, range2);
				}
				((NodeA) toTest).eval=retour;
			}else{
				retour=((NodeA) toTest).eval;
			}
			//System.out.println("Test : " +((NodeA) toTest).eval[0]+ " "+((NodeA) toTest).eval[1]);
		}
		
		return retour;
	}
	
	// Main de Test
	public static void main(String args[]){
		Evaluation test=new Evaluation();
		float[] testRange=new float[2];

		// Niveau 1
		Operator tmp=new Division();
		testRange[0]=2;
		testRange[1]=4;
		tmp.fg=new Constante(testRange);
		testRange=new float[2];
		testRange[0]=3;
		testRange[1]=5;
		tmp.fd=new Constante(testRange);
		testRange=test.Eval(tmp);
		System.out.println("Etape 1 : " +testRange[0]+ " "+testRange[1]);
		//Niveau 0
		Operator tmp2=new Plus();
		//System.out.println("Test : " +tmp.eval[0]+ " "+tmp.eval[1]);
		tmp2.fg=tmp;
		testRange=new float[2];
		testRange[0]=5;
		testRange[1]=5;
		tmp2.fd=new Constante(testRange);
		
		
		testRange=test.Eval(tmp2);
		System.out.println("Final : " +testRange[0]+ " "+testRange[1]);

	}
}
