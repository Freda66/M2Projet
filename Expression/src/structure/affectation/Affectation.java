package structure.affectation;

import structure.Node;
import structure.SimpleNode;

public class Affectation extends Node {

	@Override
	public String type() {
		return "Affectation";
	}
	@Override
	public String toString() {
		return " = ";
	}
	@Override
	public SimpleNode clone() {
		return new Affectation();
	}

}
