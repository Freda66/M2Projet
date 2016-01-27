package eudk.Rules;

import java.util.LinkedList;
import java.util.ListIterator;

import eudk.Rules.Addition.RAddition;
import structure.NodeA;
import structure.NoeudDeCoupure;
import structure.operator.*;

public class Rules {

	static LinkedList<Rule> Rules = null;
	
	static void buildRules(){
		if(Rules == null)
			return;
		
		Rules = new LinkedList<Rule>();
		Rules.add(new RAddition());		
	}
	
	
	//
	public void NESOE(Operator root,LinkedList<NodeA> ESOE){
		
		
		
		ListIterator<Rule> rli = Rules.listIterator();
		
		while(rli.hasNext()){
			rli.next().NESOE(root, ESOE);
		}		
	}
	
	
	
	
	
	
	
}
