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
	
	public void setValue(float val){
		float[] tmp=new float [2];
		tmp[0]=val;
		tmp[1]=val;
		setRange(tmp);
	}
	
	public boolean equals(Constante term){
		boolean retour = super.equals(term);
	
		return retour;
	}
	

	
}
