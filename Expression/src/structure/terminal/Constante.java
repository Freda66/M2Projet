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
		float[] range = this.getRange();
		return "["+range[0]+","+range[1]+"]";
	}

	@Override
	public SimpleNodeA clone() {
		return new Constante(this.getRange());
	}
	
	public boolean equals(Constante term){
		boolean retour = super.equals(term);
	
		return retour;
	}
	

	
}
