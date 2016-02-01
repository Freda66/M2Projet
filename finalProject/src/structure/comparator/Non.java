package structure.comparator;

import structure.SimpleNodeA;

public class Non extends Comparator {

	@Override
	public String type() {
		return "Non";
	}
	@Override
	public String toString() {
		return " ! ";
	}
	@Override
	public SimpleNodeA clone() {
		return new Non();
	}

}
