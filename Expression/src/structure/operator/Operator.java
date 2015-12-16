package structure.operator;


import java.util.LinkedList;
import java.util.ListIterator;

import structure.NodeA;


public abstract class Operator extends NodeA {


	public abstract float[] Eval(float[] range1,float[] range2);
	@Override
	public String type() {
		return "Operator";
	}
	
	//Build equivalent set of expression
	public abstract LinkedList<NodeA> NESOE ();	
	
	//parcourt en profondeur
	public void BESOE(NodeA Root,int k,LinkedList<NodeA> ESOE){
		if(this == Root) ESOE.add(this);
		
		LinkedList<NodeA> work;
		
		if(Fd() instanceof Operator){
			work = this.NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				this.fd = li.next();
				ESOE.add((NodeA) NodeA.Clone(Root));
			}
		}
		if(this.Fg() instanceof Operator){
			work = this.NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				this.fg = li.next();
				ESOE.add((NodeA) NodeA.Clone(Root));
			}
		}
		
	
		
	}
	

}

