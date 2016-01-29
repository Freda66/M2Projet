package eudk;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

import eudk.Rules.Rules;
import structure.NodeA;
import structure.operator.Operator;

public class eudK {
	
	
	 /*
	 * Applique un eud-k avec k passes
	 * ESOE_lvl2 permet de stocker les nouveaux graphes evite de passer plusierus
	 * fois sur le meme graphe et de générer les memes equivalences
	 * DONE supprimer les graphes en double
	 */
	static public LinkedList<NodeA> EUD_K(LinkedList<NodeA> ESOE,int lvl){
		//mappage pour savoir si un element existe deja
		TreeMap<String, LinkedList<NodeA>> tm = new TreeMap<String, LinkedList<NodeA>>();
		
		LinkedList<NodeA> finalGraphPool = new LinkedList<NodeA>();
		finalGraphPool.addAll(ESOE);
		for(int i = 0;i< lvl;i++){
			ListIterator<NodeA> li = ESOE.listIterator();
			LinkedList<NodeA> ESOE_lvl2 = new LinkedList<NodeA>();
			while(li.hasNext()){
				NodeA A = li.next();
				if(A instanceof Operator)
					if(!((Operator) A).inTreeMap(tm))
						((Operator)A).BESOE(A, ESOE_lvl2);
			}
			ESOE.clear();
			ESOE.addAll(ESOE_lvl2);
			finalGraphPool.addAll(ESOE_lvl2);
		}
		return finalGraphPool;
		
	}
	
	//parcours en profondeur
		//ESOE Equivalent set of expression
		//BESOE build equivalent set of expression 
		public void BESOE(Operator node, NodeA Root,LinkedList<NodeA> ESOE){
			
			LinkedList<NodeA> work = new LinkedList<NodeA>();
			if(node == Root){
				Rules.NESOE(node, work);
				ListIterator<NodeA> li = work.listIterator();
				while(li.hasNext()){
					ESOE.add(li.next());
				}
				
			}
			if(node.Fd() instanceof Operator){
				Operator initialFD = (Operator)node.Fd();
				work = ((Operator)node.Fd()).NESOE();
				ListIterator<NodeA> li = work.listIterator();
				while(li.hasNext()){
					node.setFD(li.next());
					//ESOE.add((NodeA) NodeA.Clone(Root));
					ESOE.add((NodeA) Root.Clone());
				}
				node.setFD(initialFD);
				
				BESOE(initialFD,Root,ESOE);
				
			}
			if(node.Fg() instanceof Operator){
				Operator initialFG = (Operator) node.Fg();
				work = ((Operator)node.Fg()).NESOE();
				ListIterator<NodeA> li = work.listIterator();
				while(li.hasNext()){
					node.setFG( li.next());
					//ESOE.add((NodeA) NodeA.Clone(Root));
					ESOE.add((NodeA) Root.Clone());
				}
				node.setFG(initialFG);
				BESOE(initialFG,Root,ESOE);
			}
			
		}
	

}
