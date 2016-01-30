package eudk.Rules;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

import structure.NodeA;
import structure.operator.*;

public abstract class Rule {

	
	//modele qui va donner plusieurs expressions
	Operator model;
	//equivalent set of expression
	LinkedList<NodeA> esoe;
	
	
	public Rule() {
		// TODO Auto-generated constructor stub
		//this.esoe = new LinkedList<NodeA>();
		System.out.println("BUILD");
		build();
	}
	
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
	
	public void addToInstances(NodeA toAdd){
		if(this.esoe == null){
			System.out.println("LOL");
			this.esoe = new LinkedList<NodeA>();
			
		}
		else  System.out.println("NOT LOL");
		
		this.esoe.add(toAdd);
	}
	
	
	protected abstract void build();
	
	
	boolean applyModel(Operator root){
		return root.applyPattern(this.model);
	}
	
	void addSOE_To_NSOE(LinkedList<NodeA> NESOE, TreeMap<String,LinkedList<NodeA>> tm){
		ListIterator<NodeA> li = esoe.listIterator();
		while(li.hasNext()){
			Operator totest = (Operator) li.next().Clone();
			if(!totest.inTreeMap(tm))
				NESOE.add( totest);
		}
	}
	//if you want postrocessing 
	public void postProcess(){
		// Add code here for post processing on ESO
	}
	
	
	
	//rule equivalent set of expression add into pool equivalent set of expression
	void RESOE(Operator root, LinkedList<NodeA> NESOE, TreeMap<String,LinkedList<NodeA>> tm){
		
		System.out.println("RESOE");
		//si le modele est juste
		if(this.applyModel(root)){
			/*System.out.println("pattern Ok");
			this.model.Displayln();
			root.Displayln();*/
			postProcess();
			addSOE_To_NSOE(NESOE,tm);
		}
		
		
	}
	
}
