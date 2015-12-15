package structure;

public abstract class SimpleNode {

	public int level;
	public abstract String type();

	public void SetLevel(int lvl){
			level = lvl;
		}
	
	public abstract SimpleNode clone();
} 
