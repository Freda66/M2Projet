package structure;

public abstract class SimpleNode {

	public int level;
	public abstract String type();


	public abstract SimpleNode clone();
} 
