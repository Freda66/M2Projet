package structure.terminal;

import structure.SimpleNodeA;

public class Variable extends Terminal{
	private String name;
	private String typeDef;
	
	public Variable(String name,float[] range) {
		super(range);
		this.name = name;
	}
	
	public String getTypeDef() {
		return typeDef;
	}

	public void setTypeDef(String typeDef) {
		this.typeDef = typeDef;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String type() {
		return "Variable";
	}
	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public SimpleNodeA clone() {
		return new Variable(this.getName(),this.getRange());
	}
	
	public boolean equals(Variable term){
		boolean retour = super.equals(term);
		if(this.name != term.name){
			retour=false;
		}
		return retour;
	}
}
