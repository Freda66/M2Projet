package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class Plus extends Operator {

	@Override
	public String type() {
		return "Addition";
	}
	@Override
	public String toString() {
		return " + ";
	}
	@Override
	public float[] Eval(float[] range1, float[] range2) {
		float[] retour= new float[2];
		retour[0]=range1[0] + range2[0];
		retour[1]=range1[1] + range2[1];
		return retour;
	}
	@Override
	public SimpleNodeA clone() {
		return new Plus();
	}

	@Override
	public LinkedList<NodeA> NESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();

		Operator copy = (Operator)Clone(this);

		// Commutativite
		SimpleNodeA tmp =  NodeA.Clone(copy.Fd());
		copy.setFD(NodeA.Clone(copy.Fg()));
		copy.setFG(tmp);
		l.add((NodeA) NodeA.Clone(copy));

		// Factorise la multiplication
		copy = (Operator)Clone(this);
		if (copy.Fg() instanceof Multiplication && copy.Fd() instanceof Multiplication){
			Multiplication root = new Multiplication();
			Plus MGauche = new Plus();
			root.setFD(null);
			
			if(((NodeA) copy.Fg()).Fg()==((NodeA) copy.Fd()).Fg()){
				MGauche.setFG(NodeA.Clone(((NodeA) copy.Fg()).Fd()));
				MGauche.setFD(NodeA.Clone(((NodeA) copy.Fd()).Fd()));
				root.setFD(NodeA.Clone(((NodeA) copy.Fg()).Fg()));

			}else if(((NodeA) copy.Fg()).Fg()==((NodeA) copy.Fd()).Fd()){
				MGauche.setFG(NodeA.Clone(((NodeA) copy.Fg()).Fd()));
				MGauche.setFD(NodeA.Clone(((NodeA) copy.Fd()).Fg()));
				root.setFD(NodeA.Clone(((NodeA) copy.Fg()).Fg()));

			}else if(((NodeA) copy.Fg()).Fd()==((NodeA) copy.Fd()).Fg()){
				MGauche.setFG(NodeA.Clone(((NodeA) copy.Fg()).Fg()));
				MGauche.setFD(NodeA.Clone(((NodeA) copy.Fd()).Fd()));
				root.setFD(NodeA.Clone(((NodeA) copy.Fg()).Fd()));

			}else if(((NodeA) copy.Fg()).Fd()==((NodeA) copy.Fd()).Fd()){
				MGauche.setFG(NodeA.Clone(((NodeA) copy.Fg()).Fg()));
				MGauche.setFD(NodeA.Clone(((NodeA) copy.Fd()).Fg()));
				root.setFD(NodeA.Clone(((NodeA) copy.Fg()).Fd()));
			}
			if(root.Fd()!=null){
				root.setFG(MGauche);
				l.add((NodeA) NodeA.Clone(root));
				root.Displayln();
			}
		}
		return l;
	}

}
