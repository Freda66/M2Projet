package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class Modulo extends Operator {

	@Override
	public String type() {
		return "Modulo";
	}
	@Override
	public String toString() {
		return " % ";
	}
	@Override
	public SimpleNodeA clone() {
		return new Modulo();
	}
	
	// Evaluation pour 2 terminaux
	@Override
	public float[] Eval(float[] range1, float[] range2) {
		float[] retour= new float[2];
		retour[0]=range1[0] % range2[0];
		retour[1]=range1[1] % range2[1];
		return retour;
	}
	
	// Decouverte des arbres equivalents
	@Override
	public LinkedList<NodeA> NESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();
		return l;
	}

}
