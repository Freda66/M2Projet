package evaluation;

import structure.NodeA;
import structure.SimpleNodeA;
import structure.operator.*;
import structure.terminal.*;

public class Evaluation {

	// Fonction d'evaluation de l'arbre
	public float[] Eval(SimpleNodeA toTest){
		float[] retour= new float[2];
		Terminal value;
		float[] range1= new float[2];
		float[] range2= new float[2];
		
		// Parcours de l'arbre de facon recursive
		if (toTest instanceof NodeA){
			if(((NodeA) toTest).eval == null){
				((NodeA) toTest).eval=new float[2];
				
				// Fils Gauche
				if(((NodeA) toTest).Fg() instanceof NodeA){
					range1=this.Eval(((NodeA) toTest).Fg());
					
				}else if (((NodeA) toTest).Fg() instanceof Terminal){
					value=(Terminal) ((NodeA) toTest).Fg();
					range1=value.getRange();
				}
				
				//Fils Droit
				if(((NodeA) toTest).Fd() instanceof NodeA){
					range2=Eval(((NodeA) toTest).Fd());;
					
				}else if (((NodeA) toTest).Fd() instanceof Terminal){
					value=(Terminal) ((NodeA) toTest).Fd();
					range2=value.getRange();
				}
				
				if(toTest instanceof Operator){
					retour=((Operator) toTest).Eval(range1, range2);
				}
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
		tmp.setFG(new Constante(testRange));
		testRange=new float[2];
		testRange[0]=3;
		testRange[1]=5;
		tmp.setFD(new Constante(testRange));
		testRange=test.Eval(tmp);
		System.out.println("Etape 1 : " +testRange[0]+ " "+testRange[1]);
		//Niveau 0
		Operator tmp2=new Plus();
		//System.out.println("Test : " +tmp.eval[0]+ " "+tmp.eval[1]);
		tmp2.setFG(tmp);
		testRange=new float[2];
		testRange[0]=5;
		testRange[1]=5;
		tmp2.setFD(new Constante(testRange));
		
		
		testRange=test.Eval(tmp2);
		System.out.println("Final : " +testRange[0]+ " "+testRange[1]);

	}
}
