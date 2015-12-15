package structure.terminal;

import structure.SimpleNode;

public class Variable extends Terminal{
	private String name;
	
	public Variable(String name,float[] range) {
		super(range);
		this.name = name;
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
	public SimpleNode clone() {
		return new Variable(this.getName(),this.getRange());
	}
}
