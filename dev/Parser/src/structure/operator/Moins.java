package structure.operator;

import structure.SimpleNodeA;

public class Moins extends Operator {
	
	@Override
	public String type() {
		return "Soustraction";
	}
	@Override
	public String toString() {
		return " * ";
	}
	@Override
	public float[] Eval(float[] range1, float[] range2) {
		float[] retour= new float[2];
		retour[0]=range1[0] - range2[1];
		retour[1]=range1[1] - range2[0];
		return retour;
	}
	@Override
	public SimpleNodeA clone() {
		return new Moins();
	}
}
