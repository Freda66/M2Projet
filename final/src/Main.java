
/**
 * This class contains the main runner.
 * After getting parameters from UI_Params, execute the application
 * to optimize precisions and generate UI_Stats interface.
 * @author pev
 * @version 1.0.0
 */

import java.awt.EventQueue;
import ui.Params;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
	        
            @Override
            public void run() {
            	
            	// Load UI parameters
            	Params par = new Params();

            	// Show Interfaces
                par.setVisible(true);
                
            }
        });
		
		
	}

}
