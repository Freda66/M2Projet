package structure.comparator;

import structure.SimpleNodeA;

public class Inferieur extends Comparator {

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

}
