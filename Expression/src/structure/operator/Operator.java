package structure.operator;

import structure.Node;

public abstract class Operator extends Node {


	public abstract float[] Eval(float[] range1,float[] range2);
	@Override
	public String type() {
		return "Operator";
	}

}
