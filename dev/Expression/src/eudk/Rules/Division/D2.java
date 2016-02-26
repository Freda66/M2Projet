package eudk.Rules.Division;

import eudk.Rules.Rule;
import structure.NoeudDeCoupure;
import structure.operator.Division;
import structure.operator.Multiplication;

public class D2 extends Rule {
	

	@Override
	protected void build() {		
		// Le model 
		//( A * B ) / C 
		
		
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		NoeudDeCoupure C = new NoeudDeCoupure();
		
		
		
		Division root = new Division();
		Multiplication node = new Multiplication();
		
		node.setFG(A);
		node.setFD(B);
		root.setFG(node);
		root.setFD(C);
		
		setModel(root);
		
		
		// transformations
		//( A * B ) / C -> A * ( B / C )
		
		Multiplication root2 = new Multiplication();
		Division node2 = new Division();
		
		
		root2.setFG(A);
		root2.setFD(node2);
		node2.setFG(B);
		node2.setFD(C);
		
		addToInstances(root2);
		
		//( A * B ) / C ->  B * ( A / C )
		
		Multiplication root3 = new Multiplication();
		Division node3 = new Division();
		
		root3.setFG(B);
		root3.setFD(node3);
		node3.setFG(A);
		node3.setFD(C);
				
		addToInstances(root3);
	}

}
