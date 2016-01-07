package structure;

import structure.operator.Operator;


public abstract class NodeA extends SimpleNodeA{

	public SimpleNodeA fg;
	public SimpleNodeA fd;
	public float[] eval=null;
	
	//build set of equivalent graph
	
	public void setFG(SimpleNodeA sn){
		this.fg = sn;
		//this.fg.SetLevel(this.level+1);
	}
	public void setFD(SimpleNodeA sn){
		this.fd = sn;
		//this.fd.SetLevel(this.level+1);
	}
	
	public SimpleNodeA Fd(){return this.fd;}
	public SimpleNodeA Fg(){return this.fg;}
	
	
	
	public SimpleNodeA Clone(){
		NodeA A = (NodeA) super.Clone();
		A.fd = this.fd.Clone();
		A.fg = this.fg.Clone();
		return A;
			
	}
	
	/*public abstract NodeA clone();
	
	public static NodeA Clone(NodeA n){
		NodeA A =  n.clone();
		if(n instanceof NodeA){
			((NodeA)A).fd = Clone(((NodeA) n).fd);
			((NodeA)A).fg = Clone(((NodeA) n).fg);
		}
		return A;
			
	}*/
	
	
	
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
	
	@Override
	public boolean equal(SimpleNodeA term){
		boolean retour = super.equals(term);
		if (this.type() != term.type()){
			retour=false;
		}else{
			if(!this.Fd().equals(((NodeA)term).Fd())){
				retour=false;
			}else if(!this.Fg().equals(((NodeA)term).Fg())){
				retour=false;
			}
		}
		return retour;
	}
	/*
	 * Cette fonction permet de signer les graph en créant une image ne leur structure
	 * voir https://fr.wikipedia.org/wiki/Arbre_binaire
	 * Cette image est utilisé pour déterminer rapidement si un graph existe deja sur une
	 * base de donée de graph classé selon leur structure
	 * le format definit une clef spéciale pour déterminer si on arrive sur une feuille
	 */
	public String sign(){
		
		return getSignature();
	}
	
	@Override
	protected String getSignature() {
		return Fg().getSignature()+Fd().getSignature();
	}	
	
}
	
	
	
	
	

