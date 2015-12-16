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
/*
	HashMap <String, String> varnames = new HashMap<String, String>();

	
	void toSSA(SimpleNodeA n, Mode m ){
		
		String s = "null";
		if(n != null){
			s = n.getClass().toString();
		}
		System.out.println("in SSA, mode " + m + ", " + s + " '" + n + "'"  );
		
		if( n instanceof Variable ){

			// si dans en mode lecture
			if(m == Mode.READ_VAR){
				

				String newname = varnames.get(((Variable) n).getName());
				((Variable) n).setName(newname);
				System.out.println("name set to " + newname );
				
			}
			
			// si en mode ecriture
			else if(m == Mode.SET_VAR){
				
				String currentName = varnames.get( ((Variable) n).getName() );
				
				int num ;
				
				if(currentName != null){
					
					String[] strings = currentName.split("___");
					
					num = Integer.parseInt(strings[1]);
					
				}
				else{
					
					num = 0;
					
				}
				
				num++;
				
				String newName = ((Variable) n).getName() + "___" + num	;
				varnames.put( ((Variable) n).getName() , newName);
				
				((Variable) n).setName(	newName );
				System.out.println("name set to " + newName);
			}
			
		}
		else if( n instanceof Affectation){
			
			// fg reçoit fd, donc fg est en mode SET
			if( ((NodeA) n).fg instanceof Variable){
				
				toSSA( ((NodeA) n).fg, Mode.SET_VAR );
				
			}
			else{
				
				toSSA( ((NodeA) n).fg );

			}
			
			// fg reçoit fd, donc fd est en mode READ
			if( ((NodeA) n).fd instanceof Variable){
				
				toSSA( ((NodeA) n).fd, Mode.READ_VAR );
				
			}
			else{
				
				toSSA( ((NodeA) n).fd );

			}
	
		}
		
		else if( n instanceof Operator){
			

			if( ((NodeA) n).fg instanceof Variable){
				
				toSSA( ((NodeA) n).fg, Mode.READ_VAR );
				
			}
			else{
				
				toSSA( ((NodeA) n).fg );

			}
	
			
			if( ((NodeA) n).fd instanceof Variable){
				
				toSSA( ((NodeA) n).fd, Mode.READ_VAR );
				
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
	
	
	
	void toSSA(SimpleNodeA n)
	{
		
		toSSA(n, Mode.NONE);
		
	}
*/
	
	HashMap <String, Variable> varnames = new HashMap<String, Variable>();

	
	void toSSA(SimpleNodeA n, Mode m ){
		
		String s = "null";
		if(n != null){
			s = n.getClass().toString();
		}
		System.out.println("in SSA, mode " + m + ", " + s + " '" + n + "'"  );
		
		if( n instanceof Variable ){

			// si dans en mode lecture
			if(m == Mode.READ_VAR){
				

				String newname = varnames.get(((Variable) n).getName());
				((Variable) n).setName(newname);
				System.out.println("name set to " + newname );
				
			}
			
			// si en mode ecriture
			else if(m == Mode.SET_VAR){
				
				String currentName = varnames.get( ((Variable) n).getName() );
				
				int num ;
				
				if(currentName != null){
					
					String[] strings = currentName.split("___");
					
					num = Integer.parseInt(strings[1]);
					
				}
				else{
					
					num = 0;
					
				}
				
				num++;
				
				String newName = ((Variable) n).getName() + "___" + num	;
				varnames.put( ((Variable) n).getName() , newName);
				
				((Variable) n).setName(	newName );
				System.out.println("name set to " + newName);
			}
			
		}
		else if( n instanceof Affectation){
			
			// fg reçoit fd, donc fg est en mode SET
			if( ((NodeA) n).fg instanceof Variable){
				
				toSSA( ((NodeA) n).fg, Mode.SET_VAR );
				
				Variable fg = (Variable)( (NodeA) n).fg ;
				
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
				
				String newName = ((Variable) n).getName() + "___" + num	;
				varnames.put( ((Variable) n).getName() , newName);
				
				((Variable) n).setName(	newName );
				System.out.println("name set to " + newName);
				(NodeA) n).fg  =  ;
				
				
			}
			else{
				
				toSSA( ((NodeA) n).fg );

			}
			
			// fg reçoit fd, donc fd est en mode READ
			if( ((NodeA) n).fd instanceof Variable){
				
				toSSA( ((NodeA) n).fd, Mode.READ_VAR );
				
				
				
			}
			else{
				
				toSSA( ((NodeA) n).fd );

			}
	
		}
		
		else if( n instanceof Operator){
			

			if( ((NodeA) n).fg instanceof Variable){
				
				toSSA( ((NodeA) n).fg, Mode.READ_VAR );
				
			}
			else{
				
				toSSA( ((NodeA) n).fg );

			}
	
			
			if( ((NodeA) n).fd instanceof Variable){
				
				toSSA( ((NodeA) n).fd, Mode.READ_VAR );
				
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
	
	
	
	void toSSA(SimpleNodeA n)
	{
		
		toSSA(n, Mode.NONE);
		
	}
	
}
