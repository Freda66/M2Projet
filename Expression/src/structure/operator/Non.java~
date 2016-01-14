package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

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
	
	@Override
	protected String getSignature() {
		return Signature.Non.toString()  + super.getSignature();
	}

}
