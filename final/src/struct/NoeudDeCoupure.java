package structure;

public class NoeudDeCoupure extends SimpleNodeA{

	private NodeA father;
	public enum fils{df,fg};
	private SimpleNodeA son;
	public fils fils;
	@Override
	public String type() {
		return son.type();
	}

	@Override
	public String toString() {
		return son.toString();
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
	

}
