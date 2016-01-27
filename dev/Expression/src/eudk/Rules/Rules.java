package eudk.Rules;

import java.util.LinkedList;

import structure.NodeA;
import structure.NoeudDeCoupure;
import structure.operator.*;

public class Rules {

	
	LinkedList<NodeA> GetRules(){
		
		//regles sur l'addition
		
		
		Plus root = new Plus();
		
		root.setFD(sn);
		root.setFG(sn);
		
		
		NoeudDeCoupure A = new NoeudDeCoupure();
		NoeudDeCoupure B = new NoeudDeCoupure();
		
		
		
		
		return new LinkedList<NodeA>();
	}
}
