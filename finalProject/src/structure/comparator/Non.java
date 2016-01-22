package structure.comparator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;
import structure.operator.Operator;

public class Non extends Operator {

	@Override
	public String type() {
		return "Non";
	}
	@Override
	public String toString() {
		return " ! ";
	}
	@Override
	public SimpleNodeA clone() {
		return new Non();
	}
	
	// Evaluation pour 2 terminaux
	@Override
	public void Eval(SimpleNodeA term1, SimpleNodeA term2) {
		float[] retour= new float[2];
		retour[0]=0;
		retour[1]=0;
	}
	
	// Decouverte des arbres equivalents
	@Override
	public LinkedList<NodeA> NESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();
		return l;
	}

}
