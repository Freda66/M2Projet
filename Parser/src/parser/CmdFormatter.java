package parser;

import java.util.HashMap;

import structure.SimpleNodeA;
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

	
	void toSSA(SimpleNodeA n){
		
		String s = "null";
		if(n != null){
			s = n.getClass().toString();
		}
		System.out.println("in SSA, " + s + " '" + n + "'"  );
		
		if( n instanceof Variable ){

			
		}
		else if( n instanceof Affectation){
			
			// fg reçoit fd, donc fg est en mode SET
			if( ((NodeA) n).fg instanceof Variable){
								
				Variable fg = (Variable)( ( (NodeA) n ).fg) ;
				
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
				
				toSSA( ((NodeA) n).fg );

			}
			
			// fg reçoit fd, donc fd est en mode READ
			if( ((NodeA) n).fd instanceof Variable){
								
				Variable fd = (Variable)(((NodeA) n).fd);
				
				Variable newvar = varnames.get( fd.getName() );
				//((Variable) n).setName(newname);
				
				System.out.println("name changed from " + ((Variable)(((NodeA) n).fd)).getName() + " to " + newvar.getName() );
				((NodeA) n).fd = newvar;
				
			}
			else{
				
				toSSA( ((NodeA) n).fd );

			}
	
		}
		
		else if( n instanceof Operator){
			

			if( ((NodeA) n).fg instanceof Variable){
								
				Variable fg = (Variable)(((NodeA) n).fg);
				
				Variable newvar = varnames.get( fg.getName() );
				//((Variable) n).setName(newname);
				System.out.println("name changed from " + ((Variable)(((NodeA) n).fg)).getName() + " to " + newvar.getName() );
				((NodeA) n).fg = newvar;
				
			}
			else{
				
				toSSA( ((NodeA) n).fg );

			}
	
			
			if( ((NodeA) n).fd instanceof Variable){
								
				Variable fd = (Variable)(((NodeA) n).fd);
				
				Variable newvar = varnames.get( fd.getName() );
				//((Variable) n).setName(newname);
				
				System.out.println("name changed from " + ((Variable)(((NodeA) n).fd)).getName() + " to " + newvar.getName() );

				((NodeA) n).fd = newvar;
				
			}
			else{
				
				toSSA( ((NodeA) n).fd );

			}
		}
		
		else if( n instanceof NodeA){
			
			toSSA( ((NodeA) n).fg);
			
			toSSA( ((NodeA) n).fd);
	
		}
		
		
	}
	
	

	
}
