package structure.operator;

import structure.SimpleNodeA;

public class Plus extends Operator {

	@Override
	public String type() {
		return "Addition";
	}
	@Override
	public String toString() {
		return "" + fg + " + " + fd ;
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
	
}
