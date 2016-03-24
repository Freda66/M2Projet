package eudk.Rules;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

import eudk.Rules.Addition.Associatif;
import eudk.Rules.Addition.RAddition;
import eudk.Rules.Division.*;
import eudk.Rules.Multiplication.*;
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
		Rules.add(new Associatif());
		//division
		Rules.add(new D1());
		Rules.add(new D2());
		Rules.add(new D3());
		Rules.add(new D4());
		//multiplication
		Rules.add(new M1());
		Rules.add(new M2());
		
	}
	
	
	//
	public static void NESOE(Operator root,LinkedList<NodeA> ESOE, TreeMap<String,LinkedList<NodeA>> tm){
		ListIterator<Rule> rli = Rules.listIterator();
		while(rli.hasNext()){
			rli.next().RESOE(root, ESOE,tm);
		}		
	}
	
	
	
	
	
	
	
}
