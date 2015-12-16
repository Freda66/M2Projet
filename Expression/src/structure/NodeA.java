package structure;


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
		//this.fd.SetLevel(this.level+1);
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
	
	public void Display(){
		
		System.out.print("( ");
		if(fg instanceof NodeA )
			((NodeA) fg).Display();
		else
			System.out.print(fg.toString());
		
		System.out.print(" " + this.toString() + " ");
		
		if(fd instanceof NodeA )
			((NodeA) fd).Display();
		else
			System.out.print(fd.toString());
		
		System.out.print(" )");
		
	}
	public void Displayln(){
		this.Display();
		System.out.println("");
	}
	public boolean equals(NodeA term){
		boolean retour = super.equals(term);
		if(!this.Fd().equals(term.Fd())){
			retour=false;
		}else if(!this.Fg().equals(term.Fg())){
			retour=false;
		}
		return retour;
	}
	
}
	
	
	
	
	

