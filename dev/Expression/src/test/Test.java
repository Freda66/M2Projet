package test;

import java.util.LinkedList;
import java.util.ListIterator;

import evaluation.Evaluation;

import structure.NodeA;
import structure.operator.Multiplication;
import structure.operator.Operator;
import structure.operator.Plus;
import structure.terminal.Constante;

public class Test {

	public static void main(String args[]){
		System.out.println();
		float[] Range=new float[2];
		
		Operator mult1 = new Multiplication();
		Range=new float[2];
		Range[0] = 4;
		Range[1] = 4;
		mult1.setFD(new Constante(Range));
		Range=new float[2];
		Range[0] = 4;
		Range[1] = 4;
		mult1.setFG(new Constante(Range));
		
		Operator root = new Plus();
		root.setFG(mult1);
		
		Operator mult2 = new Multiplication();
		Range[0] = 4;
		Range[1] = 4;
		mult2.setFD(new Constante(Range));
		Range[0] = 5;
		Range[1] = 5;
		mult2.setFG(new Constante(Range));
		
		root.setFD(mult2);
		
		root.Displayln();
		System.out.println(root.sign());
		
		LinkedList<NodeA> ESOE = new LinkedList<NodeA>();
		ESOE.add(root);
		ESOE = root.EUD_K(ESOE, 1);
		
		ListIterator<NodeA> li = ESOE.listIterator();
		Evaluation E = new Evaluation();
		while(li.hasNext()){
			NodeA tmp = li.next();
			
			tmp.Displayln();
			E.eval(tmp);
			System.out.println("range " + tmp.getRange()[0] + " " + tmp.getRange()[1]);
			
		}
		
		System.out.println("NB ELEM "+ESOE.size());
		
		
		//test egalitée
		
		Multiplication M = new Multiplication();
		M.setFD(new Constante(Range));
		M.setFG(new Constante(Range));
		
		Plus M2 = new Plus();
		M2.setFD(new Constante(Range));
		M2.setFG(new Constante(Range));
		
		System.out.println(M2.equals(M));
	}
	
}
