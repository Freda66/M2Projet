package structure;


public abstract class Node extends SimpleNode{
	public SimpleNode fg;
	public SimpleNode fd;
	public float[] eval=null;
	
	public void SetFilsGauche(SimpleNodeA sn){
		this.fg = sn;
		this.fg.SetLevel(this.level+1);
	}
	public void SetFilsDroit(SimpleNodeA sn){
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
