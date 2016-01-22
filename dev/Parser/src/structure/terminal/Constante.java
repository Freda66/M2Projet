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
		return "["+ getRange()[0] + ", " + getRange()[1] + "]";
	}

	@Override
	public SimpleNodeA clone() {
		return new Constante(this.getRange());
	}

	

	
}
