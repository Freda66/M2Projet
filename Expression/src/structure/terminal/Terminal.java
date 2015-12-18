package structure.terminal;

import structure.SimpleNodeA;

public abstract class Terminal extends SimpleNodeA {
	private float[] range;

	public Terminal(float[] testRange) {
		this.range= new float[2];
		this.range[0] = testRange[0];
		this.range[1] = testRange[1];
		
	}
	@Override
	public String type() {
		return "Terminal";
	}
	public float[] getRange() {
		return range;
	}
	public void setRange(float[] range) {
		this.range = range;
	}
	
	public boolean equals(Terminal term){
		boolean retour = true;
		if(this.range[0] != term.range[0]){
			retour=false;
		}else if(this.range[0] != term.range[0]){
			retour=false;
		}
		return retour;
	}
	
	@Override
	protected String getSignature() {
		return Signature.ter.toString();
	}
	

}
