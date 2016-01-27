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
	public SimpleNodeA clone() {
		return new Multiplication();
	}
	// Calc pour 2 intervall
	public float[] Calc(float[] range1, float [] range2){
		float[] retour= {1.0f,1.0f};
		float val1=(float) Math.floor(range1[0]*range2[0]);
		float val2=(float) Math.floor(range1[0]*range2[0]);
		float tmpMin=0;
		float tmpMax=0;

		// Boucle pour test toutes les combinaisons possible
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
		return retour;

	}
	// Evaluation pour 2 terminaux
	@Override
	public void Eval(SimpleNodeA term1, SimpleNodeA term2) {
		float[] retour= {1.0f,1.0f};
		float[] range1= term1.getRange();
		float[] range2= term2.getRange();
		retour=Calc(range1, range2);
		this.range=retour;
	}
	
	// Evaluation des erreurs pour 2 terminaux
	// NO USE
	@Override
	public void Error(SimpleNodeA term1, SimpleNodeA term2) {
		float[] retour= new float[2];
		float[] tmp1 = new float[2];
		float[] tmp2 = new float[2];
		float[] tmp3 = new float[2];
		
		tmp1 = Calc(term1.getError(),term2.getRange());
		tmp2 = Calc(term2.getError(),term1.getRange());
		tmp3 = Calc(term1.getError(),term2.getError());
		retour[0]= tmp1[0] + tmp2[0] + tmp3[0] + Math.ulp(term1.getRange()[0] * term2.getRange()[0]);
		retour[1]= tmp1[1] + tmp2[1] + tmp3[1] + Math.ulp(term1.getRange()[1] * term2.getRange()[1]);
		this.error=retour;
	}
	
	// Decouverte des arbres equivalents
	@Override
	public LinkedList<NodeA> NESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();
		Operator copy = (Operator)this.Clone();
		
		// Commutativite
		SimpleNodeA tmp = copy.Fd().Clone();
		copy.setFD(copy.Fg());
		copy.setFG(tmp);
		l.add((NodeA)copy.Clone());
		
		copy = (Operator)this.Clone();
		
		// Distribue la multiplication par rapport a l'addition
		// Cas ou element multipliant a droit
		if (copy.Fg() instanceof Plus){
			Plus root = new Plus();
			
			Multiplication MGauche = new Multiplication();
			Multiplication MDroit = new Multiplication();
			
			MGauche.setFG(copy.Fd().Clone());
			MDroit.setFG(copy.Fd().Clone());

			MGauche.setFD(((NodeA)copy.Fg()).Fg().Clone());
			MDroit.setFD(((NodeA)copy.Fg()).Fd().Clone());
			
			root.setFD(MDroit);
			root.setFG(MGauche);
			l.add((NodeA)root.Clone());

		}

		copy = (Operator)this.Clone();
		// Cas ou element multipliant a gauche
		if (copy.Fd() instanceof Plus){
			Plus root = new Plus();
			
			Multiplication MGauche = new Multiplication();
			Multiplication MDroit = new Multiplication();
			MGauche.setFG(copy.Fg().Clone());
			MDroit.setFG(copy.Fg().Clone());

			MGauche.setFD(((NodeA)copy.Fd()).Fg().Clone());
			MDroit.setFD(((NodeA)copy.Fd()).Fd().Clone());
			
			root.setFD(MDroit);
			root.setFG(MGauche);
			l.add((NodeA)root.Clone());
		}
		return l;
	}
	
	
	@Override
	protected String getSignature() {
		return Signature.mult.toString() + super.getSignature();
	}
	
	
}
