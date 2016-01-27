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
		float val1=(float) Math.floor(range1[0]*range2[0]);
		float val2=(float) Math.floor(range1[0]*range2[0]);
		float tmpMin=0;
		float tmpMax=0;
		
		//Calcul de 1/range2
		if(range1[0]==1 && range1[1]==1){
			retour=EvalDiv(range2);
		}else{
			// Calc de range1 * (1/range2)
			range2=EvalDiv(range2);
			for (int i = 0; i < range1.length; i++) {
				for (int j = 0; j < range2.length; j++) {
					tmpMax=(float) Math.floor(range1[i]*range2[j]);
					tmpMin=(float) Math.ceil(range1[i]*range2[j]);
					// Test pour valeur minimal
					if(tmpMin<val1){
						val1=tmpMin;
					}
					// Test pour valeur maximal
					if(tmpMax>val2){
						val2=tmpMax;
					}
				}
			}
			retour[0]=val1;
			retour[1]=val2;
		}
		this.range=retour;
	}
	
	// Si division de 1 par element
	public float[] EvalDiv(float[] range2) {
		float[] retour= {1.0f,1.0f};
		float[] range1= {1.0f,1.0f};
		float val1=(float) Math.floor(range1[0]/range2[0]);
		float val2=(float) Math.floor(range1[0]/range2[0]);
		float tmpMin=0;
		float tmpMax=0;
		
		for (int j = 0; j < range1.length; j++) {
			tmpMax=(float) Math.floor(1/range2[j]);
			tmpMin=(float) Math.ceil(1/range2[j]);
			// Test pour valeur minimal
			if(tmpMin<val1){
				val1=tmpMin;
			}
			// Test pour valeur maximal
			if(tmpMax>val2){
				val2=tmpMax;
			}
		}
		retour[0]=val1;
		retour[1]=val2;
		return retour;
	}
	
	// Evaluation des erreurs pour 2 terminaux
	@Override
	public void Error(SimpleNodeA term1, SimpleNodeA term2) {
		float[] retour= new float[2];
		retour[0]=term1.getRange()[0] + term2.getRange()[0];
		retour[1]=term1.getRange()[1] + term2.getRange()[1];
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
