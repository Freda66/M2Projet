import java.util.*;
import structure.*;

public class TestMain{
	public static void main ( String args [ ] ) {
      	
        CParser parser;
        PVirg tree = null;
        if(args.length == 1){
          try {
            parser = new CParser(new java.io.FileInputStream(args[0]));
            tree = parser.parseIt();
          }catch(java.io.FileNotFoundException e){
            System.out.println("C Parser Version 0.1:  File " + args[0] + " not found.");
            return ;
          }
        }else{
          System.out.println("Need Args");
        }
        return ;



        /*
      	// File handler
      	if(args.length == 1){
        	System.out.println("C Parser Version 0.1Alpha:  Reading from file " + args[0] + " . . ." );
      		String filePath = args[0];
        	//PVirg tree = parseIt(filePath);
      	}else{
       		System.out.println("C Parser Version 0.1Alpha:  Usage is :");
        	System.out.println("         java CParser inputfile");
        	return ;
      	}
        
        parser.parseIt("toto");
      */




        // Hack to include type "special types"
      /*types.add("__signed__");
      types.add("__const");
      types.add("__inline__");
      types.add("__signed");*/

      /*try {
          parser = new CParser(new java.io.FileInputStream(filePath));
        }catch(java.io.FileNotFoundException e){
          System.out.println("C Parser Version 0.1:  File " + filePath + " not found.");
          return null;
        }
      */
      // End of file handler
      /*try {
        ASTStart parseTree = parser.Start();
        System.out.println("C Parser Version 0.1Alpha:  Java program parsed successfully.");
        parseTree.dump("");
        System.out.println("End");
        for(int index = 0; index < allFunctions.size(); index++){
          System.out.println("FUNCTION FOUND: " + allFunctions.get(index).getReturnedValue().getTypeDef() + " " +allFunctions.get(index).getName());
          if(allFunctions.get(index).getParams()!=null)
            for(int index2=0;index2 < allFunctions.get(index).getParams().size(); index2++){
              System.out.println("Param "+index2+": "+allFunctions.get(index).getParams().get(index2).getTypeDef()+ " " + allFunctions.get(index).getParams().get(index2).getName());
            }
        }
      }catch(ParseException e){
        System.out.println("C Parser Version 0.1Alpha:  Encountered errors during parse.");
        e.printStackTrace();
      }*/
    }
}