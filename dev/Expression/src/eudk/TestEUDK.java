package eudk;

import java.util.LinkedList;
import java.util.ListIterator;

import eudk.Rules.Rules;
import structure.NodeA;
import structure.operator.Multiplication;
import structure.operator.Operator;
import structure.operator.Plus;
import structure.terminal.Constante;

public class TestEUDK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Operator root = new Plus();
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
		((NodeA) root.Clone()).Displayln();
		
		System.out.println("equals : "+ root.equals(root) );
		
		System.out.println(root.sign());
		
		LinkedList<NodeA> ESOE = new LinkedList<NodeA>();
		
		Rules.buildRules();
		ESOE.add(root);
		
		ESOE = eudK.EUD_K(ESOE, 50);
		
		System.out.println("Eud-k result");
		ListIterator<NodeA> li = ESOE.listIterator();
		while(li.hasNext()){
			NodeA tmp = li.next();
			tmp.Displayln();
		}
		System.out.println("Eud-k end result");
		
		
		Operator root1 = new Plus();
		Operator root2 = new Plus();
		root1.setFG(new Constante(Range));
		root1.setFD(new Constante(Range));
		root2.setFG(new Constante(Range));
		root2.setFD(new Constante(Range));
		
		System.out.println("equals : "+ root1.equal(root2));
		
	}

}
