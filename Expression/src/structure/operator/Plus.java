package structure.operator;

import java.util.LinkedList;

import structure.NodeA;
import structure.SimpleNodeA;
import structure.terminal.Terminal;

public class Plus extends Operator {

	@Override
	public String type() {
		return "Addition";
	}
	@Override
	public String toString() {
		return " + ";
	}
	@Override
	public SimpleNodeA clone() {
		return new Plus();
	}
	
	// Evaluation pour 2 terminaux
	@Override
	public float[] Eval(Terminal term1, Terminal term2) {
		float[] retour= new float[2];
		retour[0]=term1.getRange()[0] + term2.getRange()[0];
		retour[1]=term1.getRange()[1] + term2.getRange()[1];
		this.eval=retour;
		return retour;
	}

	// Decouverte des arbres equivalents
	@Override
	public LinkedList<NodeA> NESOE (){
		LinkedList<NodeA> l = new LinkedList<NodeA>();
		Operator copy = (Operator) this.Clone();

		// Commutativite
		SimpleNodeA tmp =  copy.Fd().Clone();
		copy.setFD(copy.Fg().Clone());
		copy.setFG(tmp);
		l.add((NodeA) copy.Clone());

		// Factorise la multiplication
		copy = (Operator)this.Clone();
		if (copy.Fg() instanceof Multiplication && copy.Fd() instanceof Multiplication){
			Multiplication root = new Multiplication();
			Plus MGauche = new Plus();
			root.setFD(null);
			System.out.println(((NodeA) copy.Fg()).Fg());
			System.out.println(((NodeA) copy.Fd()).Fg());
			System.out.println("Toto");
			if(((NodeA) copy.Fg()).Fg().equal(((NodeA) copy.Fd()).Fg())){
				MGauche.setFG(((NodeA) copy.Fg()).Fg().Clone());
				MGauche.setFD(((NodeA) copy.Fd()).Fg().Clone());
				root.setFD(((NodeA) copy.Fg()).Fd().Clone());
				System.out.println("Cas 1");

			}else if(((NodeA) copy.Fg()).Fg().equal(((NodeA) copy.Fd()).Fd())){
				MGauche.setFG(((NodeA) copy.Fg()).Fg().Clone());
				MGauche.setFD(((NodeA) copy.Fd()).Fd().Clone());
				root.setFD(((NodeA) copy.Fg()).Fd().Clone());
				System.out.println("Cas 2");

			}else if(((NodeA) copy.Fg()).Fd().equal(((NodeA) copy.Fd()).Fg())){
				MGauche.setFG(((NodeA) copy.Fg()).Fd().Clone());
				MGauche.setFD(((NodeA) copy.Fd()).Fg().Clone());
				root.setFD(((NodeA) copy.Fg()).Fg().Clone());
				System.out.println("Cas 3");

			}else if(((NodeA) copy.Fg()).Fd().equal(((NodeA) copy.Fd()).Fd())){
				MGauche.setFG(((NodeA) copy.Fg()).Fd().Clone());
				MGauche.setFD(((NodeA) copy.Fd()).Fd().Clone());
				root.setFD(((NodeA) copy.Fg()).Fg().Clone());
				System.out.println("Cas 4");
			}
			if(root.Fd()!=null){
				//MGauche.Displayln();
				root.setFG(MGauche);
				l.add((NodeA) root.Clone());
				root.Displayln();
			}
		}
		return l;
	}
	
	@Override
	protected String getSignature() {
		return Signature.Plus.toString()  + super.getSignature();
	}

}
