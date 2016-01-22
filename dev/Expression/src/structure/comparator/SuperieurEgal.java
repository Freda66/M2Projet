package structure.comparator;

import structure.SimpleNodeA;

public class SuperieurEgal extends Comparator {

	@Override
	public String type() {
		return "SuperieurEgal";
	}
	@Override
	public String toString() {
		return " >= ";
	}
	@Override
	public SimpleNodeA clone() {
		return new SuperieurEgal();
	}

}
