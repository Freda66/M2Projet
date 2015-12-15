package structure.terminal;

import structure.SimpleNode;

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
	public SimpleNode clone() {
		return new Constante(this.getRange());
	}

	

	
}
