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
    }
}