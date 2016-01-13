package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class Inferieur extends Operator {

	@Override
	public String type() {
		return "Inferieur";
	}
	@Override
	public String toString() {
		return " < ";
	}
	@Override
	public SimpleNodeA clone() {
		return new Inferieur();
	}
	
	@Override
	protected String getSignature() {
		return Signature.Inferieur.toString()  + super.getSignature();
	}

}
