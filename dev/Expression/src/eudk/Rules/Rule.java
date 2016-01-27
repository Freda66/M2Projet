package eudk.Rules;

import java.util.LinkedList;

import structure.NodeA;
import structure.operator.*;

public class Rule {

	Operator model;
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
	
}
