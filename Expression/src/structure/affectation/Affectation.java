package structure.affectation;

import structure.Node;

public class Affectation extends Node {

	@Override
	public String type() {
		return "Affectation";
	}
	@Override
	public String toString() {
		return " = ";
	}

}
