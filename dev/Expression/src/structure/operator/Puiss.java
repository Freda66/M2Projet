package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;

public class Puiss extends Operator {

	@Override
	public String type() {
		return "Puissance";
	}
	@Override
	public String toString() {
		return " ** ";
	}
	@Override
	public SimpleNodeA clone() {
		return new Moins();
	}
	
	// Evaluation pour 2 terminaux
	@Override
	public void Eval(SimpleNodeA term1, SimpleNodeA term2) {
		float[] retour= new float[2];
		float val1=(float) Math.pow(term1.getRange()[0], term2.getRange()[0]);
		float val2=(float) Math.pow(term1.getRange()[1], term2.getRange()[0]);
		if(val1>val2){
			retour[0]=val2;
			retour[1]=val1;
		}else{
			retour[0]=val1;
			retour[1]=val2;
		}
		// Si puissance pair
		if(term2.getRange()[0]%2 ==0){
			if (term1.getRange()[0] <= 0){
				retour[0]=0;
			}
			// Si puisance entiere
		}else if (term2.getRange()[0]%1==0){
			// Bloque pour le prochain else if
			
			// Si racine
		}else if (term2.getRange()[0]%(1.0/2.0) ==0){
			if (term1.getRange()[0] <= 0){
				retour[0]=0;
			}
		}else{
			if (term1.getRange()[0] <= 0){
				retour[0]=0;
			}
		}

		this.range=retour;
	}

	@Override
	public LinkedList<NodeA> NESOE() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// NOT USE
	@Override
	public void Error(SimpleNodeA range1, SimpleNodeA range2) {
		// TODO Auto-generated method stub
		
	}

}
