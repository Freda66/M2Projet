package eudk.Rules.Division;

import eudk.Rules.Rule;
import structure.NoeudDeCoupure;
import structure.operator.Division;
import structure.operator.Multiplication;

public class D1 extends Rule {
	

	@Override
	protected void build() {		
		// Le model 
		//A * ( B / C )
		
		Multiplication root = new Multiplication();
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		NoeudDeCoupure C = new NoeudDeCoupure();
		
		
		Division node = new Division();
		
		
		root.setFG(A);
		root.setFD(node);
		node.setFG(B);
		node.setFD(C);
		
		setModel(root);
		
		
		// transformations
		//A * ( B / C ) -> ( A * B ) / C 
		
		Division root2 = new Division();
		Multiplication node2 = new Multiplication();
		
		node2.setFG(A);
		node2.setFD(B);
		root2.setFG(node2);
		root2.setFD(C);
		
		addToInstances(root2);
		
		//A * ( B / C ) ->  B * ( A / C )
		
		Multiplication root3 = new Multiplication();
		Division node3 = new Division();
		
		root3.setFG(B);
		root3.setFD(node3);
		node3.setFG(A);
		node3.setFD(C);
				
		addToInstances(root3);
	}

}
