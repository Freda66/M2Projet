package structure.terminal;

import structure.SimpleNodeA;

public class Constante extends Terminal {
	
	public Constante(float[] testRange) {
		super(testRange);
	}
	
	@Override
	public String type() {
		return "Constante";
	}
	@Override
	public String toString() {
		return "";
	}

	@Override
	public SimpleNodeA clone() {
		return new Constante(this.getRange());
	}

	

	
}
