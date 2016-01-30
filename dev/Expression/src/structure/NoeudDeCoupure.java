package structure;

public class NoeudDeCoupure extends SimpleNodeA{

	private NodeA father;
	public enum fils{df,fg};
	public enum acceptType{ALL,T}; //all ou terminal uniquement
	acceptType acceptedtype;
	public fils fils;
	private SimpleNodeA son;
	
	public NoeudDeCoupure(){
		acceptedtype = acceptType.ALL;
	}
	
	public NoeudDeCoupure(acceptType t){
		acceptedtype = t;
	}
	
	
	@Override
	public String type() {
		return son.type();
	}

	@Override
	public String toString() {
		if(son != null)
			return son.toString();
		return "Ncoupure";
	}

	@Override
	protected String getSignature() {
		return null;
	}
	public void setFather(NodeA F,fils f){
		this.father = F;
		fils = f;
	}
	
	public void setSon(SimpleNodeA s){
		this.son = s;
	}
	public NodeA getFather(){
		return this.father;
	}
	public SimpleNodeA getSon(){
		return this.son;
	}
	@Override
	public SimpleNodeA Clone(){
		return this.son.Clone();
	}
	
	public boolean isAcceptingAll(){
		if(acceptedtype == acceptType.ALL)
			return true;
		return false;
	}
	public boolean isAcceptingConstanteOnly(){
		if(acceptedtype == acceptType.T)
			return true;
		return false;
	}
	
	public void setAcceptType(acceptType at){
		acceptedtype = at;
	}
	public void acceptAll(){
		acceptedtype = acceptType.ALL;
	}
	
	

}
