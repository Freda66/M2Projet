package structure.operator;


import java.util.LinkedList;
import java.util.ListIterator;

import structure.NodeA;


public abstract class Operator extends NodeA {


	public abstract float[] Eval(float[] range1,float[] range2);
	@Override
	public String type() {
		return "Operator";
	}
	
	//Build equivalent set of expression
	public abstract LinkedList<NodeA> NESOE ();	
	
	//parcours en profondeur
	//ESOE Equivalent set of expression
	//BESOE build equivalent set of expression 
	public void BESOE(NodeA Root,LinkedList<NodeA> ESOE){
		
		LinkedList<NodeA> work;
		if(this == Root){			
			work = this.NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				ESOE.add(li.next());
			}
			
		}
		if(this.Fd() instanceof Operator){
			Operator initialFD = (Operator)this.Fd();
			work = ((Operator)this.Fd()).NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				this.setFD(li.next());
				//ESOE.add((NodeA) NodeA.Clone(Root));
				ESOE.add((NodeA) Root.Clone());
			}
			this.setFD(initialFD);
			initialFD.BESOE(Root,ESOE);
			
		}
		if(this.Fg() instanceof Operator){
			Operator initialFG = (Operator) this.Fg();
			work = ((Operator)this.Fg()).NESOE();
			ListIterator<NodeA> li = work.listIterator();
			while(li.hasNext()){
				this.setFG( li.next());
				//ESOE.add((NodeA) NodeA.Clone(Root));
				ESOE.add((NodeA) Root.Clone());
			}
			this.setFG(initialFG);
			initialFG.BESOE(Root,ESOE);
		}
		
	}
	/*
	 * Applique un eud-k avec k passes
	 * ESOE_lvl2 permet de stocker les nouveaux graphes evite de passer plusierus
	 * fois sur le meme graphe et de générer les memes equivalences
	 * TODO supprimer les graphes en double
	 */
	public LinkedList<NodeA> EUD_K(LinkedList<NodeA> ESOE,int lvl){
		LinkedList<NodeA> finalGraphPool = new LinkedList<NodeA>();
		finalGraphPool.addAll(ESOE);
		for(int i = 0;i< lvl;i++){
			ListIterator<NodeA> li = ESOE.listIterator();
			LinkedList<NodeA> ESOE_lvl2 = new LinkedList<NodeA>();
			while(li.hasNext()){
				NodeA A = li.next();
				if(A instanceof Operator)
				{
					//A.Displayln();
					((Operator)A).BESOE(A, ESOE_lvl2);
				}
			}
			ESOE.clear();
			ESOE.addAll(ESOE_lvl2);
			finalGraphPool.addAll(ESOE_lvl2);
		}
		return finalGraphPool;
		
	}
	

}

