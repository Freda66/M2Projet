package ssa;

import java.util.HashMap;

import structure.SimpleNodeA;
import structure.Expression;
import structure.NodeA;
import structure.affectation.Affectation;
import structure.operator.Operator;
import structure.terminal.Variable;


public class CmdFormatter {

	enum Mode {

		SET_VAR,
		READ_VAR,
		NONE,

	};


	HashMap <String, Variable> varnames = new HashMap<String, Variable>();


	NodeA transformNodeToSSA(NodeA n){

		SimpleNodeA n2 = toSSA( (SimpleNodeA)n );

		return (NodeA)n2;

	}

	SimpleNodeA toSSA(SimpleNodeA n){

		String s = "null";
		if(n != null){
			s = n.getClass().toString();
		}
		System.out.println("in SSA, " + s + " '" + n + "'"  );

		if( n instanceof Variable ){


		}
		else if( n instanceof Affectation){

			// fg reçoit fd, donc fg est en mode SET
			if( ((NodeA) n).Fg() instanceof Variable){

				Variable fg = (Variable)( ( (NodeA) n ).Fg()) ;

				Variable currentVar = varnames.get( fg.getName() );

				int num ;

				if(currentVar != null){

					String currentName = currentVar.getName();

					String[] strings = currentName.split("___");

					num = Integer.parseInt(strings[1]);

				}
				else{

					num = 0;

				}

				num++;

				String newName = (fg).getName() + "___" + num	;
				varnames.put( (fg).getName() , (fg) );

				System.out.println("name changed from " + fg.getName() + " to " + newName);

				(fg).setName(	newName );


			}
			else{

				toSSA( ((NodeA) n).Fg() );

			}

			// fg reçoit fd, donc fd est en mode READ
			if( ((NodeA) n).Fd() instanceof Variable){

				Variable fd = (Variable)(((NodeA) n).Fd());

				Variable newvar = varnames.get( fd.getName() );
				//((Variable) n).setName(newname);

				System.out.println("name changed from " + ((Variable)(((NodeA) n).Fd())).getName() + " to " + newvar.getName() );
				((NodeA) n).setFD(newvar);

			}
			else{

				toSSA( ((NodeA) n).Fd() );

			}

		}

		else if( n instanceof Operator){


			if( ((NodeA) n).Fg() instanceof Variable){

				Variable fg = (Variable)(((NodeA) n).Fg());

				Variable newvar = varnames.get( fg.getName() );
				//((Variable) n).setName(newname);
				System.out.println("name changed from " + ((Variable)(((NodeA) n).Fg())).getName() + " to " + newvar.getName() );
				((NodeA) n).setFG(newvar);

			}
			else{

				toSSA( ((NodeA) n).Fg() );

			}


			if( ((NodeA) n).Fd() instanceof Variable){

				Variable fd = (Variable)(((NodeA) n).Fd());

				Variable newvar = varnames.get( fd.getName() );
				//((Variable) n).setName(newname);

				System.out.println("name changed from " + ((Variable)(((NodeA) n).Fd())).getName() + " to " + newvar.getName() );

				((NodeA) n).setFD(newvar);

			}
			else{

				toSSA( ((NodeA) n).Fd() );

			}
		}

		else if( n instanceof NodeA){

			toSSA( ((NodeA) n).Fg());

			toSSA( ((NodeA) n).Fd());

		}

		return n;


	}

	void transformExpressions(SimpleNodeA n){

		String s = "null";
		if(n != null){
			s = n.getClass().toString();
		}
		System.out.println("in SSA, " + s + " '" + n + "'"  );


		if(n instanceof Expression){

			// optimize

		}
		else if(n instanceof NodeA){

			// do children

			transformExpressions( ( (NodeA)n ).Fd() );

			transformExpressions( ( (NodeA)n ).Fg() );


		}
		else {

			// don't do shit

		}

	}


}
