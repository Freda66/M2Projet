package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class EtEt extends Operator {

	@Override
	public String type() {
		return "EtEt";
	}
	@Override
	public String toString() {
		return " && ";
	}
	@Override
	public SimpleNodeA clone() {
		return new EtEt();
	}
	
	@Override
	protected String getSignature() {
		return Signature.EtEt.toString()  + super.getSignature();
	}

}
