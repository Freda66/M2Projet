package structure;

import java.util.ArrayList;

public class IfCondition extends NodeA {
	private Expression myExpression;
	private PVirg ifContent;
	private PVirg elseContent;
	
	// Constructor
	public IfCondition(Expression myExpression){
		this.myExpression=myExpression;
	}
	
	// Inherit function
	@Override
	public String type() {
		return "If";
	}
	@Override
	public SimpleNodeA clone() {
		return new IfCondition();
	}
	@Override
	// TODO
	public String toString() {
		return "";
	}
	
	// Getters and Setters
	public String getMyExpression() {
		return myExpression;
	}
	public void setMyExpression(Expression myExpression) {
		this.myExpression = myExpression;
	}
	public PVirg getIfContent() {
		return ifContent;
	}
	public void setIfContent(PVirg ifContent) {
		this.ifContent = ifContent;
	}
	public PVirg getElseContent() {
		return elseContent;
	}
	public void setElseContent(PVirg elseContent) {
		this.elseContent = elseContent;
	}

}
