package structure;

public abstract class SimpleNodeA {

	public int level;

	public abstract String type();
	
	public void SetLevel(int lvl){
		level = lvl;
	}

	public abstract SimpleNodeA clone();
	
	public abstract String toString();

	public boolean equals(SimpleNodeA term){
		boolean retour=true;
		if(this.type()!=term.type()){
			retour=false;
		}
		return retour;
	}
} 
