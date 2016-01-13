package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class NonEgal extends Operator {

	@Override
	public String type() {
		return "NonEgal";
	}
	@Override
	public String toString() {
		return " != ";
	}
	@Override
	public SimpleNodeA clone() {
		return new NonEgal();
	}
	
	@Override
	protected String getSignature() {
		return Signature.NonEgal.toString()  + super.getSignature();
	}

}
