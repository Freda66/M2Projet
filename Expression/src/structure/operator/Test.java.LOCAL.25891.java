package structure.operator;

import java.util.LinkedList;
import java.util.ListIterator;

import structure.NodeA;
import structure.terminal.Constante;

public class Test {

	public static void main(String args[]){
		System.out.println();
		float[] Range;
		/*Operator root = new Multiplication();
		float[] Range=new float[2];
		Range[0] = 2;
		Range[1] = 2;*/
		
		Operator root = new Plus();
		Operator mult1 = new Multiplication();
		Range=new float[2];
		Range[0] = 2;
		Range[1] = 2;
		mult1.setFD(new Constante(Range));
		Range=new float[2];
		Range[0] = 3;
		Range[1] = 3;
		mult1.setFG(new Constante(Range));
		
		Operator mult2 = new Multiplication();
		Range=new float[2];
		Range[0] = 2;
		Range[1] = 2;
		mult2.setFD(new Constante(Range));
		Range=new float[2];
		Range[0] = 4;
		Range[1] = 4;
		mult2.setFG(new Constante(Range));
		
		
		root.setFD(mult2);
		root.setFG(mult1);
		root.Displayln();
		
		LinkedList<NodeA> ESOE = new LinkedList<NodeA>();
		root.BESOE(root, ESOE, 0);
		
		ListIterator<NodeA> li = ESOE.listIterator();
		while(li.hasNext()){
			(li.next()).Displayln();
		}
		
	}
	
}
