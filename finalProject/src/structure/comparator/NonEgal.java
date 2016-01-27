package structure.comparator;

import structure.SimpleNodeA;

public class NonEgal extends Comparator {

	@Override
	public String type() {
		return "NonEgal";
	}
	@Override
	public String toString() {
		return " != ";
	}
	@Override
	public SimpleNodeA clone() {
		return new NonEgal();
	}

}
