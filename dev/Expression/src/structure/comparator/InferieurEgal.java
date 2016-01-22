package structure.comparator;

import structure.SimpleNodeA;

public class InferieurEgal extends Comparator {

	@Override
	public String type() {
		return "InferieurEgal";
	}
	@Override
	public String toString() {
		return " <= ";
	}
	@Override
	public SimpleNodeA clone() {
		return new InferieurEgal();
	}

}
