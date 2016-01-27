package structure.terminal;

import structure.SimpleNodeA;
import structure.Expression;

public abstract class Terminal extends SimpleNodeA implements Expression{

	public Terminal(float[] testRange) {
		this.range= new float[2];
		this.range[0] = testRange[0];
		this.range[1] = testRange[1];
		this.error= new float[2];
		this.error[0] = 0;
		this.error[1] = 0;
	}
	
	@Override
	public boolean equal(SimpleNodeA term){
		boolean retour = true;
		//System.out.println("Super");
		if (this.type() != term.type()){
			//System.out.println("Type");
			retour=false;
		}else{
			if(this.range[0] != ((Terminal) term).range[0]){
				//System.out.println("Range0");
				retour=false;
			}else if(this.range[1] != ((Terminal) term).range[1]){
				//System.out.println("Range1");
				retour=false;
			}
		}
		return retour;
	}
	
	// Inherit function
	@Override
	protected String getSignature() {
		return Signature.ter.toString();
	}
	@Override
	public String type() {
		return "Terminal";
	}
}
