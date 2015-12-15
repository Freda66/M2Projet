package structure;

public abstract class SimpleNodeA {

	public int level;

	public abstract String type();
	
	public void SetLevel(int lvl){
		level = lvl;
	}

	public abstract SimpleNodeA clone();


} 
