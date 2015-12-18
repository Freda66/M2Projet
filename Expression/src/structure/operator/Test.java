package structure.operator;

import java.util.LinkedList;
import java.util.ListIterator;

import structure.NodeA;
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
		addition.setFG(new Constante(Range));
		
		root.Displayln();
		
		LinkedList<NodeA> ESOE = new LinkedList<NodeA>();
		root.BESOE(root, ESOE);
		
		ListIterator<NodeA> li = ESOE.listIterator();
		while(li.hasNext()){
			(li.next()).Displayln();
		}
		
		
		
		
		
	}
	
}
