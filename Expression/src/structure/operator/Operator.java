package structure.operator;


import java.util.LinkedList;

import structure.NodeA;


public abstract class Operator extends NodeA {


	public abstract float[] Eval(float[] range1,float[] range2);
	@Override
	public String type() {
		return "Operator";
	}
	
	//Build equivalent set of expression
	public abstract LinkedList<NodeA> BESOE ();	
	
	
	

}
