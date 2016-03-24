package eudk.Rules.Multiplication;

import eudk.Rules.Rule;
import structure.NoeudDeCoupure;
import structure.operator.Multiplication;
import structure.operator.Plus;

public class M2 extends Rule{

	@Override
	protected void build() {
		// Le model 
		//A * (B * C)
		
		Multiplication root = new Multiplication();
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		NoeudDeCoupure C = new NoeudDeCoupure();
		
		
		Multiplication node = new Multiplication();
		
		
		root.setFG(A);
		root.setFD(node);
		node.setFG(B);
		node.setFD(C);
		
		setModel(root);
		
		
		// transformations
		//A * (B * C) -> (A * B) * C 
		
		Multiplication root2 = new Multiplication();
		Multiplication node2 = new Multiplication();
		
		node2.setFG(A);
		node2.setFD(B);
		root2.setFG(node2);
		root2.setFD(C);
		
		addToInstances(root2);
		
		//A * (B * C) ->  (A * C) * B
		
		Multiplication root3 = new Multiplication();
		Multiplication node3 = new Multiplication();
		
		node3.setFG(A);
		node3.setFD(C);
		root3.setFG(node3);
		root3.setFD(B);
		
		addToInstances(root3);
	}

}
