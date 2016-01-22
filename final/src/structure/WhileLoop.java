package structure;

import java.util.ArrayList;

public class WhileLoop extends NodeA {
	private Expression myExpression;
	private PVirg content;
	
	// Constructor
	public WhileLoop(){
	}
	public WhileLoop(Expression myExpression){
		this.myExpression=myExpression;
	}
	
	// Inherit function
	@Override
	public String type() {
		return "While";
	}
	@Override
	public SimpleNodeA clone() {
		return new WhileLoop();
	}
	@Override
	// TODO
	public String toString() {
		return "";
	}
	
	// Getters and Setters
	public Expression getMyExpression() {
		return myExpression;
	}
	public void setMyExpression(Expression myExpression) {
		this.myExpression = myExpression;
	}
	public PVirg getContent() {
		return content;
	}
	public void setContent(PVirg content) {
		this.content = content;
	}

}
