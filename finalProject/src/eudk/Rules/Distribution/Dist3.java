package eudk.Rules.Distribution;

import eudk.Rules.Rule;
import structure.NoeudDeCoupure;
import structure.operator.Division;
import structure.operator.Moins;
import structure.operator.Multiplication;
import structure.operator.Plus;



public class Dist3  extends Rule {
	

	@Override
	protected void build() {		
		// Le model 
		// ( A - B ) * C -> ( C * A ) - ( C * B )
		
		Multiplication root = new Multiplication();
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		NoeudDeCoupure C = new NoeudDeCoupure();
		
		
		Moins node = new Moins();
		
		
		node.setFG(A);
		node.setFD(B);
		
		root.setFG(node);
		root.setFD(C);
		
		
		setModel(root);
		
		
		// transformations
		// ( A - B ) * C -> ( C * A ) - ( C * B )
		
		Moins root2 = new Moins();
		Multiplication node2 = new Multiplication();
		Multiplication node3 = new Multiplication();
		
		node2.setFG(C);
		node2.setFD(A);
		
		node3.setFG(C);
		node3.setFG(B);
		
		root2.setFG(node2);
		root2.setFD(node3);
		
		addToInstances(root2);
	}

}
