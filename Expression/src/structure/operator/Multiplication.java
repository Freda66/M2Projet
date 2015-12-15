package structure.operator;


import java.awt.List;
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
	public LinkedList<NodeA> BESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();
		
		//TODO sauvegarder le node et le reset a la fin
		
		//comutativité
		
		Operator copy = (Operator)Clone(this);
		
		SimpleNodeA tmp = copy.Fd();
		SetFilsDroit(copy.Fg());
		SetFilsGauche(tmp);
		l.add(copy);
		
		copy = (Operator)Clone(this);
		//distribue la multiplication par rapport a l'addition
		if (copy.Fg() instanceof Plus){
			Plus root = new Plus();
			
			Multiplication MGauche = new Multiplication();
			Multiplication MDroit = new Multiplication();
			MGauche.SetFilsGauche(NodeA.Clone(copy.Fd()));
			MDroit.SetFilsGauche(NodeA.Clone(copy.Fd()));
			
			//Dolipran
			MGauche.SetFilsDroit(NodeA.Clone(((NodeA)copy.Fg()).Fg()));
			MDroit.SetFilsDroit(NodeA.Clone(((NodeA)copy.Fg()).Fd()));
			
			root.SetFilsDroit(MDroit);
			root.SetFilsGauche(MGauche);
		}
		return l;
	}
	
	
}
