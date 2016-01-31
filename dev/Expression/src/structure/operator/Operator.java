package structure.operator;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

import structure.NodeA;
import structure.NoeudDeCoupure;
import structure.SimpleNodeA;
import structure.terminal.Constante;
import structure.terminal.Variable;
import structure.Expression;


public abstract class Operator extends NodeA implements Expression{


	public abstract void Eval(SimpleNodeA range1,SimpleNodeA range2);
	@Override
	public String type() {
		return "Operator";
	}
	
	//Build equivalent set of expression
	public abstract LinkedList<NodeA> NESOE ();	
	
	
	
	
	/*
	 * Cette fonction va permettre de verifier que il n'y ai pas de doublons
	 * en regardant si le graph binaire n'est pas dans une treeMap avec un tri sur les signatures
	 */
	public boolean inTreeMap(TreeMap<String, LinkedList<NodeA>> tm){
		String s = this.getSignature();
		System.out.println("inTreeMap " + s);
		this.Displayln();
		System.out.println("parcourt");
		if(tm.containsKey(s)){
			ListIterator<NodeA> li = tm.get(s).listIterator();
			while(li.hasNext()){
				NodeA blop = li.next();
				blop.Display();
				System.out.println(" sign " + blop.sign());
				if(this.equal(blop)){
					System.out.println("equal");
					return true;
				}
					
			}
			tm.get(s).add((NodeA) this.Clone());
			
		}
		else{
			LinkedList<NodeA> l = new LinkedList<NodeA>();
			l.add((NodeA) this.Clone());
			tm.put(s, l);
			
		}
		System.out.println("not inTreeMap " + s);
		return false;
	}
	
	// applique un pattern P qui transforme l'arbre en T
	//retourne si tout c'est bien passe
	// attention va modifier le modèle
	public boolean applyPattern ( NodeA P){
		
		if(this.type() != P.type())
			return false;
		//TODO probleme de typage et recurence
		
		boolean fg_ok = false;
		boolean fd_ok = false;
		
		// si on a une constante en fils gauche
		if(P.Fg() instanceof NoeudDeCoupure){
			//variable
			if(((NoeudDeCoupure)P.Fg()).isAcceptingConstanteOnly()){
				if (this.Fg() instanceof Constante){
					((NoeudDeCoupure)P.Fg()).setSon(this.Fg());
					fg_ok = true;
				}
				else
					fg_ok = false;
			}//la on ce fous de notre fils gauche c'est ok
			else if (((NoeudDeCoupure)P.Fg()).isAcceptingAll()){
				((NoeudDeCoupure)P.Fg()).setSon(this.Fg());
				fg_ok = true;
			}
			
		}//
		else if(P.Fg() instanceof Operator && this.Fg() instanceof Operator){
			if(((Operator) this.Fg()).type() == ((Operator) P.Fg()).type())
				fg_ok = ((Operator) this.Fg()).applyPattern((Operator) P.Fg());
			else fg_ok = false;
		}
		
		
		
		// si on a une constante en fils droit
			if(P.Fd() instanceof NoeudDeCoupure){
				//variable
				if(((NoeudDeCoupure)P.Fd()).isAcceptingConstanteOnly()){
					if (this.Fd() instanceof Constante){
						((NoeudDeCoupure)P.Fd()).setSon(this.Fd());
						fd_ok = true;
					}
					else
						fd_ok = false;
				}//la on ce fous de notre fils gauche c'est ok
				else if (((NoeudDeCoupure)P.Fd()).isAcceptingAll()){
					((NoeudDeCoupure)P.Fd()).setSon(this.Fd());
					fd_ok = true;
				}
				
			}//
			else if(P.Fd() instanceof Operator && this.Fd() instanceof Operator){
				if(((Operator) this.Fd()).type() == ((Operator) P.Fd()).type())
					fd_ok = ((Operator) this.Fd()).applyPattern((Operator) P.Fd());
				else fd_ok = false;
			}
			
			return fd_ok && fg_ok;
		
	}
	

}

