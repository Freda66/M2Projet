package eudk;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
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
		//initialisation
		NodeA tmp = ESOE.getFirst();
		LinkedList<NodeA> l = new LinkedList<NodeA>();
		l.add(tmp);
		tm.put(tmp.sign(), l);
				
		
		
		LinkedList<NodeA> finalGraphPool = new LinkedList<NodeA>();
		finalGraphPool.addAll(ESOE);
		for(int i = 0;i< lvl;i++){
			ListIterator<NodeA> li = ESOE.listIterator();
			LinkedList<NodeA> ESOE_lvl2 = new LinkedList<NodeA>();
			while(li.hasNext()){
				NodeA A = li.next();
				if(A instanceof Operator)
					//if(!((Operator) A).inTreeMap(tm))
						BESOE((Operator)A,A,ESOE_lvl2,tm);
			}
			ESOE.clear();
			ESOE.addAll(ESOE_lvl2);
			finalGraphPool.addAll(ESOE_lvl2);
		}
		//display treemap
		for(Entry<String, LinkedList<NodeA>> entry : tm.entrySet()) {
			  String key = entry.getKey();
			  System.out.print(key + " => ");
			  ListIterator<NodeA> li = entry.getValue().listIterator();
			  while(li.hasNext()){
				  NodeA blop = li.next();
				  if(! key.equals(blop.sign()))
					  System.out.print(" ERREUR ");
				  System.out.println(blop.sign());
				  blop.Displayln();
			  }
			  System.out.println("//"+key);

			  
		}
		
		
		
		
		return finalGraphPool;
		
	}
	
	//parcours en profondeur
		//ESOE Equivalent set of expression
		//BESOE build equivalent set of expression 
		static public void BESOE(Operator node, NodeA Root,LinkedList<NodeA> ESOE, TreeMap<String, LinkedList<NodeA>> tm){
			
			LinkedList<NodeA> work = new LinkedList<NodeA>();
			if(node == Root){
				Rules.NESOE(node, work,tm);
				ListIterator<NodeA> li = work.listIterator();
				while(li.hasNext()){
					NodeA tmp = li.next();
					System.out.println("BESOE");
					tmp.Displayln();
					if(!((Operator) tmp).inTreeMap(tm))
						ESOE.add(tmp);
				}
				
			}
			work.clear();
			if(node.Fd() instanceof Operator){
				Operator initialFD = (Operator)node.Fd();
				Rules.NESOE((Operator)node.Fd(),work,tm);
				ListIterator<NodeA> li = work.listIterator();
				while(li.hasNext()){
					node.setFD(li.next());
					if(!((Operator) Root).inTreeMap(tm))
						ESOE.add((NodeA) Root.Clone());
				}
				node.setFD(initialFD);
				BESOE(initialFD,Root,ESOE,tm);
				
			}
			work.clear();
			if(node.Fg() instanceof Operator){
				Operator initialFG = (Operator) node.Fg();
				Rules.NESOE((Operator)node.Fg(),work,tm);
				ListIterator<NodeA> li = work.listIterator();
				while(li.hasNext()){
					node.setFG( li.next());
					if(!((Operator) Root).inTreeMap(tm))
						ESOE.add((NodeA) Root.Clone());
				}
				node.setFG(initialFG);
				BESOE(initialFG,Root,ESOE,tm);
			}
			
			
			
			
			
		}
	

}
