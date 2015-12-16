package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class Plus extends Operator {

	@Override
	public String type() {
		return "Addition";
	}
	@Override
	public String toString() {
		return " + ";
	}
	@Override
	public float[] Eval(float[] range1, float[] range2) {
		float[] retour= new float[2];
		retour[0]=range1[0] + range2[0];
		retour[1]=range1[1] + range2[1];
		return retour;
	}
	@Override
	public SimpleNodeA clone() {
		return new Plus();
	}
	@Override
	public LinkedList<NodeA> NESOE() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
