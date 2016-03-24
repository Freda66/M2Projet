package eudk.Rules.Division;

import eudk.Rules.Rule;
import structure.NoeudDeCoupure;
import structure.operator.Division;
import structure.operator.Multiplication;

public class D3 extends Rule {
	

	@Override
	protected void build() {		
		// Le model 
		//A / B * C / D
		
		
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		NoeudDeCoupure C = new NoeudDeCoupure();
		NoeudDeCoupure D = new NoeudDeCoupure();
		
		
		
		Multiplication root = new Multiplication();
		Division node1 = new Division();
		Division node2 = new Division();
		
		node1.setFG(A);
		node1.setFD(B);
		node2.setFG(C);
		node2.setFD(D);
		
		root.setFG(node1);
		root.setFD(node2);
		
		setModel(root);
		
		
		// transformations
		//A / B * C / D -> ( A * C ) / ( B * D )
		
		Division root1 = new Division();
		Multiplication node3 = new Multiplication();
		Multiplication node4 = new Multiplication();
		
		node3.setFG(A);
		node3.setFD(C);
		node4.setFG(B);
		node4.setFD(D);
		
		root.setFG(node3);
		root.setFD(node4);
		
		addToInstances(root1);
		
		
	}

}
