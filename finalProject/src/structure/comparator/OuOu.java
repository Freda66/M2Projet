package structure.comparator;

import structure.SimpleNodeA;

public class OuOu extends Comparator {

	@Override
	public String type() {
		return "OuOu";
	}
	@Override
	public String toString() {
		return " || ";
	}
	@Override
	public SimpleNodeA clone() {
		return new OuOu();
	}

}
