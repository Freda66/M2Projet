package structure;

import structure.terminal.Constante;

public abstract class SimpleNodeA {

	public int level;

	public abstract String type();
	
	public void SetLevel(int lvl){
		level = lvl;
	}

	public SimpleNodeA Clone(){
		SimpleNodeA tmp=null;
		try {
			tmp= (SimpleNodeA) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	
	public abstract String toString();

	public boolean equal(SimpleNodeA term){
		boolean retour=true;
		if(this.type()!=term.type()){
			retour=false;
		}
		return retour;
	}
	
	protected abstract String getSignature();
	public enum Signature{
		Plus("+"),
		moins("-"),
		mult("*"),
		div("/"),
		ter("T"),
		egal("=");
		private String name;
		Signature(String a){
			this.name= a;
		}
		public String toString(){
			return this.name;
		}
	}
	
	public boolean isPattern( SimpleNodeA S){
	
		if(this instanceof NodeA){
			if (this.type() == S.type()){
				return 	((NodeA)this).fd.isPattern(((NodeA)S).fd) &&
						((NodeA)this).fg.isPattern(((NodeA)S).fg);
			}
			else
				return false;
		}
		else if (this instanceof Constante ){
			if(S instanceof Constante)
				return true;
			else
				return false;
		}
		return true;
	}
	
	
	
	
} 
