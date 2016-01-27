package eudk.Rules.Addition;

import java.util.LinkedList;

import eudk.Rules.Rule;
import structure.NodeA;
import structure.NoeudDeCoupure;
import structure.operator.Plus;

public class RAddition extends Rule{

	
	public RAddition() {
		
		Plus root = new Plus();
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		
		root.setFG(A);
		root.setFD(B);
		
		
		Plus instance1 = new Plus();
		instance1.setFG(B);
		instance1.setFD(A);
		
		
		
		
		this.setModel(root);
		LinkedList<NodeA> instances = new LinkedList<NodeA>();
		instances.add(instance1);
		
		this.setInstances(instances);
		
		
	}
}
