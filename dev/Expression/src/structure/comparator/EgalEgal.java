package structure.comparator;

import structure.SimpleNodeA;

public class EgalEgal extends Comparator {

	@Override
	public String type() {
		return "EgalEgal";
	}
	@Override
	public String toString() {
		return " == ";
	}
	@Override
	public SimpleNodeA clone() {
		return new EgalEgal();
	}

}
