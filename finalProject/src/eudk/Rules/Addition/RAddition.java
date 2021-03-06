package eudk.Rules.Addition;

import java.util.LinkedList;

import eudk.Rules.Rule;
import structure.NodeA;
import structure.NoeudDeCoupure;
import structure.NoeudDeCoupure.acceptType;
import structure.operator.Plus;
import structure.terminal.Variable;

public class RAddition extends Rule{


	protected void build(){
		
		Plus root = new Plus();
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		
		root.setFG(A);
		root.setFD(B);
		
		
		Plus instance1 = new Plus();
		instance1.setFG(B);
		instance1.setFD(A);
		
		
		addToInstances(instance1);
		this.setModel(root);
		
		
		//this.setInstances(instances);
	}
}
