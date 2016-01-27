package structure.comparator;

import structure.SimpleNodeA;

public class EtEt extends Comparator {

	@Override
	public String type() {
		return "EtEt";
	}
	@Override
	public String toString() {
		return " && ";
	}
	@Override
	public SimpleNodeA clone() {
		return new EtEt();
	}

}
