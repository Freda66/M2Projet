package eudk.Rules;

import java.util.LinkedList;
import java.util.ListIterator;

import structure.NodeA;
import structure.NoeudDeCoupure;
import structure.operator.*;

public class Rules {

	static LinkedList<Rule> Rules = null;
	
	static void buildRules(){
		if(Rules == null)
			return;
		
		
		
		
		
	}
	
	
	
	public void BESOE(NodeA Root,LinkedList<NodeA> ESOE){
		
		LinkedList<NodeA> work;
		if(this == Root){			
			work = this.NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				ESOE.add(li.next());
			}
			
		}
		if(this.Fd() instanceof Operator){
			Operator initialFD = (Operator)this.Fd();
			work = ((Operator)this.Fd()).NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				this.setFD(li.next());
				//ESOE.add((NodeA) NodeA.Clone(Root));
				ESOE.add((NodeA) Root.Clone());
			}
			this.setFD(initialFD);
			initialFD.BESOE(Root,ESOE);
			
		}
		if(this.Fg() instanceof Operator){
			Operator initialFG = (Operator) this.Fg();
			work = ((Operator)this.Fg()).NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				this.setFG( li.next());
				//ESOE.add((NodeA) NodeA.Clone(Root));
				ESOE.add((NodeA) Root.Clone());
			}
			this.setFG(initialFG);
			initialFG.BESOE(Root,ESOE);
		}
		
	}
	
	
	
	
	
	
	
}
