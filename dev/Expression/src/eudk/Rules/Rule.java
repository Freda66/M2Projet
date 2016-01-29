package eudk.Rules;

import java.util.LinkedList;
import java.util.ListIterator;

import structure.NodeA;
import structure.operator.*;

public abstract class Rule {

	
	//modele qui va donner plusieurs expressions
	Operator model;
	//equivalent set of expression
	LinkedList<NodeA> esoe;
	
	
	
	public Operator getModel() {
		return model;
	}
	public void setModel(Operator model) {
		this.model = model;
	}
	public LinkedList<NodeA> getInstances() {
		return esoe;
	}
	public void setInstances(LinkedList<NodeA> instances) {
		this.esoe = instances;
	}
	
	protected abstract void build();
	
	
	//rule equivalent set of expression add into pool equivalent set of expression
	void RESOE(Operator root, LinkedList<NodeA> NESOE){
		build();
		System.out.println("RESOE");
		//si le modele est juste
		if(root.applyPattern(this.model)){
			System.out.println("pattern Ok");
			this.model.Displayln();
			root.Displayln();
			ListIterator<NodeA> li = esoe.listIterator();
			while(li.hasNext()){
				NESOE.add( (NodeA) li.next().Clone());
			}
		}
		
		
	}
	
}
