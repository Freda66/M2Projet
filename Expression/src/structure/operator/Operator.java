package structure.operator;


import java.util.LinkedList;
import java.util.ListIterator;

import structure.NodeA;
import structure.SimpleNodeA;


public abstract class Operator extends NodeA {


	public abstract float[] Eval(float[] range1,float[] range2);
	@Override
	public String type() {
		return "Operator";
	}
	
	//Build equivalent set of expression
	public abstract LinkedList<NodeA> NESOE ();	
	
	//parcourt en profondeur
	//ESOE Equivalent set of expression
	//BESOE build equivalent set of expression 
	public void BESOE(NodeA Root,LinkedList<NodeA> ESOE,int k){
		if(this == Root) ESOE.add(this);
		
		LinkedList<NodeA> work;
		
		if(this.Fd() instanceof Operator){
			Operator initialFD = (Operator)this.Fd();
			work = this.NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				this.setFD(li.next());
				ESOE.add((NodeA) NodeA.Clone(Root));
			}
			this.setFD(initialFD);
			initialFD.BESOE(Root,ESOE,k);
			
		}
		if(this.Fg() instanceof Operator){
			Operator initialFG = (Operator) this.Fg();
			work = this.NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				this.setFG( li.next());
				ESOE.add((NodeA) NodeA.Clone(Root));
			}
			this.setFG(initialFG);
			initialFG.BESOE(Root,ESOE,k);
		}
		
	}
	

}

