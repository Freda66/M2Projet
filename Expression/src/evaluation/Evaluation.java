package evaluation;

import structure.Node;
import structure.SimpleNode;

public class Evaluation {
	public float Eval(SimpleNode toTest){
		float retour=0;
		SimpleNode tmp=toTest;
		
		// Parcours de l'arbre de facon recursive
		if (tmp instanceof Node){
			if(((Node) tmp).fg instanceof Node){
				Eval(((Node) tmp).fg);
			}
			if(((Node) tmp).fd instanceof Node){
				Eval(((Node) tmp).fd);
			}
		}else{
			
		}

		return retour;
	}
}
