package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class SuperieurEgal extends Operator {

	@Override
	public String type() {
		return "SuperieurEgal";
	}
	@Override
	public String toString() {
		return " >= ";
	}
	@Override
	public SimpleNodeA clone() {
		return new SuperieurEgal();
	}
	
	@Override
	protected String getSignature() {
		return Signature.SuperieurEgal.toString()  + super.getSignature();
	}

}
