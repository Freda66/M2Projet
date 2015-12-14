package structure.operator;

import structure.Node;

public abstract class Operator extends Node {

	public abstract float Eval(float val1,float val2);
	@Override
	public String type() {
		return "Operator";
	}

}
