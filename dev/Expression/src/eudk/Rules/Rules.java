package eudk.Rules;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

import eudk.Rules.Addition.RAddition;
import structure.NodeA;
import structure.NoeudDeCoupure;
import structure.operator.*;

public class Rules {

	static LinkedList<Rule> Rules = null;
	
	public static void buildRules(){
		if(Rules != null)
			return;
		
		Rules = new LinkedList<Rule>();
		Rules.add(new RAddition());		
	}
	
	
	//
	public static void NESOE(Operator root,LinkedList<NodeA> ESOE, TreeMap<String,LinkedList<NodeA>> tm){
		ListIterator<Rule> rli = Rules.listIterator();
		while(rli.hasNext()){
			rli.next().RESOE(root, ESOE,tm);
		}		
	}
	
	
	
	
	
	
	
}
