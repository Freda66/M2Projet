package eudk.Rules;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

import structure.NodeA;
import structure.NoeudDeCoupure;
import structure.operator.*;
import structure.terminal.Constante;

public abstract class Rule {

	
	//modele qui va donner plusieurs expressions
	Operator model;
	//equivalent set of expression
	LinkedList<NodeA> esoe;
	
	
	public Rule() {
		// TODO Auto-generated constructor stub
		//this.esoe = new LinkedList<NodeA>();
		System.out.println("BUILD");
		build();
	}
	
	public Operator getModel() {
		return model;
	}
	public void setModel(Operator model) {
		this.model = model;
	}
	public LinkedList<NodeA> getInstances() {
		return esoe;
	}
	public void setInstances(LinkedList<NodeA> instances) {
		this.esoe = instances;
	}
	
	public void addToInstances(NodeA toAdd){
		if(this.esoe == null){
			System.out.println("LOL");
			this.esoe = new LinkedList<NodeA>();
			
		}
		else  System.out.println("NOT LOL");
		
		this.esoe.add(toAdd);
	}
	
	
	protected abstract void build();
	
	
	boolean applyModel(Operator root){
		return applyPattern(root, this.model);
	}
	
	void addSOE_To_NSOE(LinkedList<NodeA> NESOE, TreeMap<String,LinkedList<NodeA>> tm){
		ListIterator<NodeA> li = esoe.listIterator();
		while(li.hasNext()){
			Operator totest = (Operator) li.next().Clone();
			//if(!totest.inTreeMap(tm))
				NESOE.add( totest);
		}
	}
	//if you want postrocessing 
	public void postProcess(){
		// Add code here for post processing on ESO
	}
	
	
	
	//rule equivalent set of expression add into pool equivalent set of expression
	void RESOE(Operator root, LinkedList<NodeA> NESOE, TreeMap<String,LinkedList<NodeA>> tm){
		
		System.out.println("RESOE");
		//si le modele est juste
		if(this.applyModel(root)){
			/*System.out.println("pattern Ok");
			this.model.Displayln();
			root.Displayln();*/
			postProcess();
			addSOE_To_NSOE(NESOE,tm);
		}
		
		
	}
	
	// applique un pattern P qui transforme l'arbre en T
		//retourne si tout c'est bien passe
		// attention va modifier le modèle
	public boolean applyPattern ( NodeA s, NodeA P){
		
		if(s.type() != P.type())
			return false;
		//TODO probleme de typage et recurence
		
		boolean fg_ok = false;
		boolean fd_ok = false;
		
		// si on a une constante en fils gauche
		if(P.Fg() instanceof NoeudDeCoupure){
			//variable
			if(((NoeudDeCoupure)P.Fg()).isAcceptingConstanteOnly()){
				if (s.Fg() instanceof Constante){
					((NoeudDeCoupure)P.Fg()).setSon(s.Fg());
					fg_ok = true;
				}
				else
					fg_ok = false;
			}//la on ce fous de notre fils gauche c'est ok
			else if (((NoeudDeCoupure)P.Fg()).isAcceptingAll()){
				((NoeudDeCoupure)P.Fg()).setSon(s.Fg());
				fg_ok = true;
			}
			
		}//
		else if(P.Fg() instanceof Operator && s.Fg() instanceof Operator){
			if(((Operator) s.Fg()).type() == ((Operator) P.Fg()).type())
				fg_ok = applyPattern((Operator)s.Fg(), (Operator)P.Fg());
			else fg_ok = false;
		}
		
		
		
		// si on a une constante en fils droit
			if(P.Fd() instanceof NoeudDeCoupure){
				//variable
				if(((NoeudDeCoupure)P.Fd()).isAcceptingConstanteOnly()){
					if (s.Fd() instanceof Constante){
						((NoeudDeCoupure)P.Fd()).setSon(s.Fd());
						fd_ok = true;
					}
					else
						fd_ok = false;
				}//la on ce fous de notre fils gauche c'est ok
				else if (((NoeudDeCoupure)P.Fd()).isAcceptingAll()){
					((NoeudDeCoupure)P.Fd()).setSon(s.Fd());
					fd_ok = true;
				}
				
			}//
			else if(P.Fd() instanceof Operator && s.Fd() instanceof Operator){
				if(((Operator) s.Fd()).type() == ((Operator) P.Fd()).type())
					fd_ok = applyPattern((Operator)s.Fd(), (Operator)P.Fd());
				else fd_ok = false;
			}
			
			return fd_ok && fg_ok;
			
		}
	
	
	
	
}
