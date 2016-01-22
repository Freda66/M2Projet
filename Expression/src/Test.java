

import java.util.LinkedList;
import java.util.ListIterator;

import evaluation.Evaluation;

import structure.NodeA;
import structure.operator.*;
import structure.terminal.Constante;

public class Test {

	public static void main(String args[]){
		System.out.println();
		
		Operator root = new Multiplication();
		float[] Range=new float[2];
		Range[0] = 2;
		Range[1] = 2;
		
		Constante c = new Constante(Range);
		root.setFD(c);
		
		Operator addition = new Plus();
		root.setFG(addition);
		
		Range[0] = 4;
		Range[1] = 4;
		addition.setFD(new Constante(Range));
		Range[0] = 1;
		Range[1] = 1;
		
		
		Operator mult2 = new Multiplication();
		Range[0] = 6;
		Range[1] = 6;
		mult2.setFD(new Constante(Range));
		Range[0] = 5;
		Range[1] = 5;
		mult2.setFG(new Constante(Range));
		
		addition.setFG(mult2);
		
		root.Displayln();
		System.out.println(root.sign());
		
		LinkedList<NodeA> ESOE = new LinkedList<NodeA>();
		ESOE.add(root);
		ESOE = root.EUD_K(ESOE, 2);
		
		ListIterator<NodeA> li = ESOE.listIterator();
		Evaluation E = new Evaluation();
		while(li.hasNext()){
			NodeA tmp = li.next();
			
			tmp.Displayln();
			E.Eval(tmp);
			System.out.println("range " +tmp.type()+" : "+ tmp.range[0] + " " + tmp.range[0]);
			
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
