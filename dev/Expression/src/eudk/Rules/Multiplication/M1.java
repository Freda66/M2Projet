package eudk.Rules.Multiplication;

import eudk.Rules.Rule;
import structure.NoeudDeCoupure;
import structure.operator.Multiplication;
import structure.operator.Plus;

public class M1 extends Rule {
	

	@Override
	protected void build() {
		// TODO Auto-generated method stub
		
		// Le model 
		//A * B -> B * A
		
		Multiplication root = new Multiplication();
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
				
		root.setFD(A);
		root.setFG(B);

		setModel(root);
		
		
		// transformations
		//A * B -> B * A
		
		Multiplication root2 = new Multiplication();
		root2.setFD(B);
		root2.setFG(A);
		
		addToInstances(root2);
	}

}
