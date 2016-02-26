package eudk.Rules.Division;

import eudk.Rules.Rule;
import structure.NoeudDeCoupure;
import structure.operator.Division;
import structure.operator.Multiplication;
import structure.operator.Plus;

public class D4 extends Rule {
	

	@Override
	protected void build() {		
		// Le model 
		//A + ( B / C )
		
		
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		NoeudDeCoupure C = new NoeudDeCoupure();
		
		
		
		Plus root = new Plus();
		Division node = new Division();
		
		root.setFG(A);
		root.setFD(node);
		node.setFG(B);
		node.setFD(C);
		
		
		setModel(root);
		
		
		// transformations
		//A + ( B / C ) -> ( ( A * C ) + B ) / C
		
		Division root2 = new Division();
		Multiplication node2 = new Multiplication();
		Plus node3 = new Plus();
		
		node2.setFG(A);
		node2.setFD(C);
		node3.setFG(node2);
		node3.setFD(B);
		
		root2.setFG(node3);
		root2.setFD(C);
		
		addToInstances(root2);
		
		
	}

}
