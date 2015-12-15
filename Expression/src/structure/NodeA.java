package structure;


import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public abstract class NodeA extends SimpleNodeA{

	public SimpleNodeA fg;
	public SimpleNodeA fd;
	public float[] eval=null;
	
	//build set of equivalent graph
	
	public void setFG(SimpleNodeA sn){
		this.fg = sn;
		this.fg.SetLevel(this.level+1);
	}
	public void setFD(SimpleNodeA sn){
		this.fd = sn;
		this.fd.SetLevel(this.level+1);
	}
	
	public SimpleNodeA Fd(){return this.fd;}
	public SimpleNodeA Fg(){return this.fg;}
	
	
	
	public static SimpleNodeA Clone(SimpleNodeA n){
		SimpleNodeA A = n.clone();
		if(n instanceof NodeA){
			((NodeA)A).fd = Clone(((NodeA) n).fd);
			((NodeA)A).fg = Clone(((NodeA) n).fg);
		}
		return A;
			
	}
}
	
	
	
	
	

