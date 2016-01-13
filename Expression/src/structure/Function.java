package structure;

import java.util.ArrayList;

import structure.terminal.Variable;

public class Function extends NodeA {
	private Variable returnedValue;
	private String name;
	private ArrayList<Variable> params;
	private PVirg content;
	
	// Constructor
	public Function(){
	}
	public Function(String name){
		this.name=name;
	}
	public Function(String name,Variable returnedValue){
		this.params=new ArrayList<>();
		this.name=name;
		this.returnedValue=returnedValue;
	}
	public Function(String name,Variable returnedValue,ArrayList<Variable> params){
		this.params=params;
		this.name=name;
		this.returnedValue=returnedValue;
	}
	
	// Inherit function
	@Override
	public String type() {
		return "Function";
	}
	@Override
	public SimpleNodeA clone() {
		return new Function();
	}
	@Override
	// TODO
	public String toString() {
		return "";
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Variable> getParams() {
		return params;
	}
	public void setParams(ArrayList<Variable> params) {
		this.params = params;
	}
	public PVirg getContent() {
		return content;
	}
	public void setContent(PVirg content) {
		this.content = content;
	}
	public Variable getReturnedValue() {
		return returnedValue;
	}
	public void setReturnedValue(Variable returnedValue) {
		this.returnedValue = returnedValue;
	}

}
