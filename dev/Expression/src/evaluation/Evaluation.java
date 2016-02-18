package evaluation;

import java.util.LinkedList;
import java.util.ListIterator;

import eudk.TestEUDK;
import eudk.eudK;
import eudk.Rules.Rules;
import structure.NodeA;
import structure.SimpleNodeA;
import structure.operator.*;
import structure.terminal.*;

public class Evaluation {


	// Fonction d'evaluation de l'arbre
	public static void eval(SimpleNodeA toTest){
		SimpleNodeA term1=toTest;
		SimpleNodeA term2=toTest;
		// Parcours de l'arbre de facon recursive
		if (toTest instanceof NodeA){
			//if(((NodeA) toTest).range == null){
				//toTest.range=new float[2];
				System.out.println("------------------------- New Step -------------------------------------");
				// Fils Gauche
				if(((NodeA) toTest).Fg() instanceof NodeA){
					eval(((NodeA) toTest).Fg());
					term1=((NodeA) toTest).Fg();
					term1.setRange(((NodeA) toTest).Fg().getRange());
					//term1.setError(((NodeA) toTest).Fg().getError());
					//System.out.println("Term1 Operator : " + term1.getRange()[0]+ " "+term1.getRange()[1]);
					
				}else if (((NodeA) toTest).Fg() instanceof Terminal){
					term1=((NodeA) toTest).Fg();
					//System.out.println("Term1 Terminal : " + term1.getRange()[0]+ " "+term1.getRange()[1]);
				}
				
				//Fils Droit
				if(((NodeA) toTest).Fd() instanceof NodeA){
					eval(((NodeA) toTest).Fd());
					term2=((NodeA) toTest).Fd();
					term2.setRange(((NodeA) toTest).Fd().getRange());
					//term2.setError(((NodeA) toTest).Fg().getError());
					//System.out.println("Term2 Operator : " + term2.getRange()[0]+ " "+term2.getRange()[1]);
					
				}else if (((NodeA) toTest).Fd() instanceof Terminal){
					term2=((NodeA) toTest).Fd();
					//System.out.println("Term2 Terminal : " + term2.getRange()[0]+ " "+term2.getRange()[1]);
				}
				
				// Calc 
				if(toTest instanceof Operator){
					((Operator) toTest).Eval(term1, term2);
					// NOT USE
					//((Operator) toTest).Error(term1, term2);
				}
			//}else{
				//retour=((NodeA) toTest).range;
			//}
			System.out.println("Test "+toTest.type()+" : " + toTest.getRange()[0]+ " "+toTest.getRange()[1]);
		}
		
	}
	
	// Function to call 
	public static NodeA expression(NodeA root){
		LinkedList<NodeA> ESOE = new LinkedList<NodeA>();
			
		Rules.buildRules();
		ESOE.add(root);
		
		ESOE = eudK.EUD_K(ESOE, 3);
		
		
		NodeA best = root;
		eval(root);
		float[] c = root.range;
		float bestScore = c[1] - c[0];
		
		ListIterator<NodeA> li = ESOE.listIterator();
		while(li.hasNext()){
			NodeA tmp = li.next();
			//System.out.println("New Line");
			tmp.Displayln();
			eval(tmp);
			c = tmp.range;
			if(c[1] - c[0] < bestScore ){
				best = (NodeA) tmp.Clone();
				bestScore = c[1] - c[0];
			}
		}
		return best;
	}
	
	
	// Main de Test
	public static void main(String args[]){
		
		Operator root = new Plus();
		float[] Range=new float[2];
		Range[0] = 2;
		Range[1] = 2;
		
		Constante c = new Constante(Range);
		root.setFD(c);
		
		Operator addition = new Plus();
		root.setFG(addition);
		
		Range[0] = 4.7f;
		Range[1] = 4.9f;
		addition.setFD(new Constante(Range));
		Range[0] = 1.2f;
		Range[1] = 1.6f;
		
		
		Operator mult2 = new Multiplication();
		Range[0] = 6;
		Range[1] = 6.2f;
		mult2.setFD(new Constante(Range));
		Range[0] = 5.2f;
		Range[1] = (float) 5.5;
		mult2.setFG(new Constante(Range));
		
		addition.setFG(mult2);
		
		root.Displayln();
		
		NodeA optimal = expression(root);
		System.out.println("Optimal");
		optimal.Displayln();
		
		
		
		
		
		/*float[] testRange=new float[2];

		// Niveau 1
		Operator tmp=new Puiss();
		testRange[0]=-2;
		testRange[1]=4;
		tmp.setFG(new Constante(testRange));
		testRange=new float[2];
		testRange[0]=(float) (1.0/2.0);
		testRange[1]=(float) (1.0/2.0);
		tmp.setFD(new Constante(testRange));
		eval(tmp);
		System.out.println("Etape 1 : "+ tmp.getRange()[0]+ " "+tmp.getRange()[1]);
		
		//Niveau 0
		Operator tmp2=new Plus();
		tmp2.setFG(tmp);
		testRange=new float[2];
		testRange[0]=5;
		testRange[1]=5;
		tmp2.setFD(new Constante(testRange));
		
		
		System.out.println("Final : "+ tmp2.getRange()[0]+ " "+tmp2.getRange()[1]);
	*/
	}
}
