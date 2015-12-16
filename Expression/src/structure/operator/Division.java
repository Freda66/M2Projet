package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class Division extends Operator {

	@Override
	public String type() {
		return "Division";
	}
	@Override
	public String toString() {
		return " / ";
	}
	@Override
	public float[] Eval(float[] range1, float[] range2) {
		float val1=range1[0]/range2[0];
		float val2=val1;
		float tmp=0;
		float[] retour= new float[2];
		retour[0]=1;
		retour[1]=1;
		
		//Calcul de 1/range2
		if(range1[0]==1 && range1[1]==1){
			for (int j = 0; j < range1.length; j++) {
				tmp=1/range2[j];
				// Test pour valeur minimal
				if(tmp<val1){
					val1=tmp;
				}
				if(tmp>val2){
					val2=tmp;
				}
			}
		}else{
			range2=Eval(retour,range2);
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
		}
		retour[0]=val1;
		retour[1]=val2;
		return retour;
	}
	@Override
	public SimpleNodeA clone() {
		return new Division();
	}
	
	
	@Override
	public LinkedList<NodeA> NESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();

		Operator copy = (Operator)Clone(this);
		
		// Distribue la Division par rapport a la multiplication
		if (copy.Fg() instanceof Multiplication){
			Multiplication root = new Multiplication();
			
			Division MGauche = new Division();
			Division MDroit = new Division();
			MGauche.setFD(NodeA.Clone(copy.Fd()));
			MDroit.setFD(NodeA.Clone(copy.Fd()));

			MGauche.setFG(NodeA.Clone(((NodeA)copy.Fg()).Fg()));
			MDroit.setFG(NodeA.Clone(((NodeA)copy.Fg()).Fd()));
			
			root.setFD(MDroit);
			root.setFG(MGauche);
			l.add(root);

		}
		return l;
	}
}
