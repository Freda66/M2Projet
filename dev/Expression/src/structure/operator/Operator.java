package structure.operator;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

import structure.NodeA;
import structure.NoeudDeCoupure;
import structure.SimpleNodeA;
import structure.terminal.Constante;
import structure.terminal.Variable;
import structure.Expression;


public abstract class Operator extends NodeA implements Expression{


	public abstract void Eval(SimpleNodeA range1,SimpleNodeA range2);
	@Override
	public String type() {
		return "Operator";
	}
	
	//Build equivalent set of expression
	public abstract LinkedList<NodeA> NESOE ();	
	
	

}

