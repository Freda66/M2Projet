package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;
public class Multiplication extends Operator {

	@Override
	public String type() {
		return "Multiplication";
	}
	@Override
	public String toString() {
		return " * ";
	}
	@Override
	public float[] Eval(float[] range1, float[] range2) {
		float val1=range1[0]*range2[0];
		float val2=val1;
		float tmp=0;
		float[] retour= new float[2];

		for (int i = 0; i < range1.length; i++) {
			for (int j = 0; j < range2.length; j++) {
				tmp=range1[i]*range2[j];
				// Test pour valeur minimal
				if(tmp<val1){
					val1=tmp;
				}
				if(tmp>val2){
					val2=tmp;
				}
			}
		}
		retour[0]=val1;
		retour[1]=val2;
		return retour;
	}
	@Override
	public SimpleNodeA clone() {
		return new Multiplication();
	}
	
	@Override
	public LinkedList<NodeA> NESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();
		
		// Commutativite
		//Operator copy = (Operator)Clone(this);
		Operator copy = (Operator)this.Clone();
		
		//SimpleNodeA tmp = NodeA.Clone(copy.Fd());
		SimpleNodeA tmp = copy.Fd().Clone();
		copy.setFD(copy.Fg());
		copy.setFG(tmp);
		//l.add((NodeA)NodeA.Clone(copy));
		l.add((NodeA)copy.Clone());
		
		//copy = (Operator)Clone(this);
		copy = (Operator)this.Clone();
		
		// Distribue la multiplication par rapport a l'addition
		// Cas ou element multipliant a droit
		if (copy.Fg() instanceof Plus){
			Plus root = new Plus();
			
			Multiplication MGauche = new Multiplication();
			Multiplication MDroit = new Multiplication();
			/*MGauche.setFG(NodeA.Clone(copy.Fd()));
			MDroit.setFG(NodeA.Clone(copy.Fd()));

			MGauche.setFD(NodeA.Clone(((NodeA)copy.Fg()).Fg()));
			MDroit.setFD(NodeA.Clone(((NodeA)copy.Fg()).Fd()));*/
			
			MGauche.setFG(copy.Fd().Clone());
			MDroit.setFG(copy.Fd().Clone());

			MGauche.setFD(((NodeA)copy.Fg()).Fg().Clone());
			MDroit.setFD(((NodeA)copy.Fg()).Fd().Clone());
			
			root.setFD(MDroit);
			root.setFG(MGauche);
			//l.add((NodeA)NodeA.Clone(root));
			l.add((NodeA)root.Clone());

		}
		
		//copy = (Operator)Clone(this);
		copy = (Operator)this.Clone();
		// Cas ou element multipliant a gauche
		if (copy.Fd() instanceof Plus){
			Plus root = new Plus();
			
			Multiplication MGauche = new Multiplication();
			Multiplication MDroit = new Multiplication();
			/*
			MGauche.setFG(NodeA.Clone(copy.Fg()));
			MDroit.setFG(NodeA.Clone(copy.Fg()));
			
			MGauche.setFD(NodeA.Clone(((NodeA)copy.Fd()).Fg()));
			MDroit.setFD(NodeA.Clone(((NodeA)copy.Fd()).Fd()));*/
			MGauche.setFG(copy.Fg().Clone());
			MDroit.setFG(copy.Fg().Clone());

			MGauche.setFD(((NodeA)copy.Fd()).Fg().Clone());
			MDroit.setFD(((NodeA)copy.Fd()).Fd().Clone());
			
			root.setFD(MDroit);
			root.setFG(MGauche);
			//l.add((NodeA)NodeA.Clone(root));
			l.add((NodeA)root.Clone());
		}
		return l;
	}
	
	
	@Override
	protected String getSignature() {
		return Signature.mult.toString() + super.getSignature();
	}
	
	
}
