package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;
import structure.SimpleNodeA.Signature;

public class Moins extends Operator {
	
	@Override
	public String type() {
		return "Soustraction";
	}
	@Override
	public String toString() {
		return " * ";
	}
	@Override
	public float[] Eval(float[] range1, float[] range2) {
		float[] retour= new float[2];
		retour[0]=range1[0] - range2[1];
		retour[1]=range1[1] - range2[0];
		return retour;
	}
	@Override
	public SimpleNodeA clone() {
		return new Moins();
	}
	
	@Override
	public LinkedList<NodeA> NESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();

		Operator copy = (Operator)Clone(this);
		
		// Factorise la multiplication
		if (copy.Fg() instanceof Multiplication && copy.Fd() instanceof Multiplication){
			Multiplication root = new Multiplication();
			Moins MGauche = new Moins();
			
			root.setFD(null);
			
			if(((NodeA) copy.Fg()).Fg().equals(((NodeA) copy.Fd()).Fg())){
				MGauche.setFG(NodeA.Clone(((NodeA) copy.Fg()).Fd()));
				MGauche.setFD(NodeA.Clone(((NodeA) copy.Fd()).Fd()));
				root.setFD(NodeA.Clone(((NodeA) copy.Fg()).Fg()));

			}else if(((NodeA) copy.Fg()).Fg().equals(((NodeA) copy.Fd()).Fd())){
				MGauche.setFG(NodeA.Clone(((NodeA) copy.Fg()).Fd()));
				MGauche.setFD(NodeA.Clone(((NodeA) copy.Fd()).Fg()));
				root.setFD(NodeA.Clone(((NodeA) copy.Fg()).Fg()));

			}else if(((NodeA) copy.Fg()).Fd().equals(((NodeA) copy.Fd()).Fg())){
				MGauche.setFG(NodeA.Clone(((NodeA) copy.Fg()).Fg()));
				MGauche.setFD(NodeA.Clone(((NodeA) copy.Fd()).Fd()));
				root.setFD(NodeA.Clone(((NodeA) copy.Fg()).Fd()));

			}else if(((NodeA) copy.Fg()).Fd().equals(((NodeA) copy.Fd()).Fd())){
				MGauche.setFG(NodeA.Clone(((NodeA) copy.Fg()).Fg()));
				MGauche.setFD(NodeA.Clone(((NodeA) copy.Fd()).Fg()));
				root.setFD(NodeA.Clone(((NodeA) copy.Fg()).Fd()));
			}
			if(root.Fd()!=null){
				root.setFG(MGauche);
				l.add((NodeA) NodeA.Clone(root));
			}
		}
		return l;
	}
	@Override
	protected String getSignature() {
		return Signature.moins.toString() + super.getSignature();
	}
}
