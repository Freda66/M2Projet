package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class EgalEgal extends Operator {

	@Override
	public String type() {
		return "EgalEgal";
	}
	@Override
	public String toString() {
		return " == ";
	}
	@Override
	public SimpleNodeA clone() {
		return new EgalEgal();
	}
	
	@Override
	protected String getSignature() {
		return Signature.EgalEgal.toString()  + super.getSignature();
	}

}
