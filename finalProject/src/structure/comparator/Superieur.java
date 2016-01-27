package structure.comparator;

import structure.SimpleNodeA;

public class Superieur extends Comparator {

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

}
