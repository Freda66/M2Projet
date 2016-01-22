package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.terminal.Terminal;
import structure.terminal.Variable;

public class Rule {

	//node equivalent set of expression
	public LinkedList<NodeA> NESOE(Operator o){
		
		return new LinkedList<NodeA>();
	}	
	
	public static void main(String args[]){
		
		float[] Range=new float[2];
		
		NodeA Ai = new Plus();
		NodeA Ae = new Plus();
		Variable A = new Variable("A",Range);
		Variable B = new Variable("B",Range);
		
		// une regle de commutation
		Ai.setFD(A);
		Ai.setFG(B);
		
		Ae.setFD(B);
		Ae.setFG(A);		
		
		Ai.Display();
		System.out.print(" = ");
		Ae.Display();
		System.out.println(Ai.isPattern(Ae));
		
	}
	
	
}
