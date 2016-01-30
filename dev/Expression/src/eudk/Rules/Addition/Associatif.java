package eudk.Rules.Addition;

import eudk.Rules.Rule;
import structure.NoeudDeCoupure;
import structure.operator.Plus;

public class Associatif extends Rule{

	@Override
	protected void build() {
		// TODO Auto-generated method stub
		
		Plus root = new Plus();
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		NoeudDeCoupure C = new NoeudDeCoupure();
		
		
		Plus node = new Plus();
		node.setFD(B);
		node.setFG(A);
		
		root.setFD(node);
		root.setFG(C);

		setModel(root);
		
		
		// transformations
		
		
		Plus root2 = new Plus();
		Plus node2 = new Plus();
		node2.setFD(B);
		node2.setFG(C);
		
		root2.setFD(node2);
		root2.setFG(A);
		
		addToInstances(root2);
		
		Plus root3 = new Plus();
		Plus node3 = new Plus();
		node3.setFD(A);
		node3.setFG(C);
		
		root3.setFD(node3);
		root3.setFG(B);
		addToInstances(root3);
		
		
		
	}
	
	@Override
	public void postProcess() {
		// TODO Auto-generated method stub
		
	}
	

}
