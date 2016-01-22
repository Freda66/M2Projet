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
	public SimpleNodeA clone() {
		return new Division();
	}
	
	// Evaluation pour 2 terminaux
	public void Eval(SimpleNodeA term1, SimpleNodeA term2) {
		float[] retour= {1.0f,1.0f};
		float[] range1= term1.getRange();
		float[] range2= term2.getRange();
		float val1=range1[0]/range2[0];
		float val2=val1;
		float tmp=0;
		
		//Calcul de 1/range2
		if(range1[0]==1 && range1[1]==1){
			EvalDiv(range2);
		}else{
			range2=EvalDiv(range2);
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
		this.range=retour;
		//return retour;
	}
	// Si division de 1 par element
	public float[] EvalDiv(float[] range2) {
		float[] retour= {1.0f,1.0f};
		float[] range1= {1.0f,1.0f};
		float val1=range1[0]/range2[0];
		float val2=val1;
		float tmp=0;
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
		return retour;
	}
	
	// Decouverte des arbres equivalents
	@Override
	public LinkedList<NodeA> NESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();
		Operator copy = (Operator) this.Clone();
		
		// Distribue la Division par rapport a la multiplication
		if (copy.Fg() instanceof Multiplication){
			Multiplication root = new Multiplication();
			
			Division MGauche = new Division();
			Division MDroit = new Division();
			MGauche.setFD(copy.Fd().Clone());
			MDroit.setFD(copy.Fd().Clone());

			MGauche.setFG(((NodeA)copy.Fg()).Fg().Clone());
			MDroit.setFG(((NodeA)copy.Fg()).Fd().Clone());
			
			root.setFD(MDroit);
			root.setFG(MGauche);
			l.add(root);

		}
		return l;
	}
	
	@Override
	protected String getSignature() {
		return Signature.div.toString() + super.getSignature();
	}
	
}
