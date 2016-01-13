package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class Superieur extends Operator {

	@Override
	public String type() {
		return "Superieur";
	}
	@Override
	public String toString() {
		return " > ";
	}
	@Override
	public SimpleNodeA clone() {
		return new Superieur();
	}
	
	@Override
	protected String getSignature() {
		return Signature.Superieur.toString()  + super.getSignature();
	}

}
