package evaluation;

import structure.NodeA;
import structure.SimpleNodeA;
import structure.operator.*;
import structure.terminal.*;

public class Evaluation {

	// TODO Ajout des calculs d'erreurs
	// Fonction d'evaluation de l'arbre
	public void Eval(SimpleNodeA toTest){
		SimpleNodeA term1=toTest;
		SimpleNodeA term2=toTest;
		
		// Parcours de l'arbre de facon recursive
		if (toTest instanceof NodeA){
			//if(((NodeA) toTest).range == null){
				toTest.range=new float[2];
				//System.out.println("------------------------- New Step -------------------------------------");
				// Fils Gauche
				if(((NodeA) toTest).Fg() instanceof NodeA){
					this.Eval(((NodeA) toTest).Fg());
					term1.setRange(((NodeA) toTest).Fg().getRange());
					//System.out.println("Term1 Operator : " + term1.getRange()[0]+ " "+term1.getRange()[1]);
					
				}else if (((NodeA) toTest).Fg() instanceof Terminal){
					term1=((NodeA) toTest).Fg();
					//System.out.println("Term1 Terminal : " + term1.getRange()[0]+ " "+term1.getRange()[1]);
				}
				
				//Fils Droit
				if(((NodeA) toTest).Fd() instanceof NodeA){
					Eval(((NodeA) toTest).Fd());
					term2.setRange(((NodeA) toTest).Fd().getRange());
					//System.out.println("Term2 Operator : " + term2.getRange()[0]+ " "+term2.getRange()[1]);
					
				}else if (((NodeA) toTest).Fd() instanceof Terminal){
					term2=((NodeA) toTest).Fd();
					//System.out.println("Term2 Terminal : " + term2.getRange()[0]+ " "+term2.getRange()[1]);
				}
				
				// Calc 
				if(toTest instanceof Operator){
					((Operator) toTest).Eval(term1, term2);
				}
			//}else{
				//retour=((NodeA) toTest).range;
			//}
			System.out.println("Test "+toTest.type()+" : " + toTest.getRange()[0]+ " "+toTest.getRange()[1]);
		}
		
	}
	
	// Function to call 
	public NodeA Expression(NodeA test){
		return test;
	}
	
	/*
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
		test.Eval(tmp);
		System.out.println("Etape 1 : "+ tmp.getRange()[0]+ " "+tmp.getRange()[1]);
		//Niveau 0
		Operator tmp2=new Plus();
		tmp2.setFG(tmp);
		testRange=new float[2];
		testRange[0]=5;
		testRange[1]=5;
		tmp2.setFD(new Constante(testRange));
		
		test.Eval(tmp2);
		System.out.println("Final : "+ tmp2.getRange()[0]+ " "+tmp2.getRange()[1]);

	}*/
}
