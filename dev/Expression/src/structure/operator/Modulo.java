package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class Modulo extends Operator {
/* In TESTING */
	@Override
	public String type() {
		return "Modulo";
	}
	@Override
	public String toString() {
		return " % ";
	}
	@Override
	public SimpleNodeA clone() {
		return new Modulo();
	}
	
	// Evaluation pour 2 terminaux
	@Override
	public void Eval(SimpleNodeA term1, SimpleNodeA term2) {
		float[] retour= new float[2];
		retour[0]=0;
		retour[1]=0;
		if((term2.getRange()[0]>= term1.getRange()[0]) && (term2.getRange()[0]<= term1.getRange()[1])){
			retour[0]=0;
			retour[1]=term2.getRange()[0];
		}else if((term2.getRange()[0]< term1.getRange()[0]) && (term2.getRange()[0]> 0)){
			retour[0]=0;
			retour[1]=term2.getRange()[0];
		}else if(term2.getRange()[0]> term1.getRange()[1]){
			retour[0]=term1.getRange()[0];
			retour[1]=term1.getRange()[1];
		}
		
	}
	
	// Evaluation des erreurs pour 2 terminaux
	// NOT USE
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
		return l;
	}

}
