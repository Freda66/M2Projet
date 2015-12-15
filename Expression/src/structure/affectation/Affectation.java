package structure.affectation;

import structure.NodeA;
import structure.SimpleNodeA;

public class Affectation extends NodeA {

	@Override
	public String type() {
		return "Affectation";
	}
	@Override
	public String toString() {
		return " = ";
	}
	@Override
	public SimpleNodeA clone() {
		return new Affectation();
	}

}
