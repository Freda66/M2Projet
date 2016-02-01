package test;

import gui.Logs;
import gui.Plot;

/**
 * This class execute plotting example to test Plot interface
 * 
 * @author pev
 * @version 1.0.0
 *
 */
public class TestGuiPlot {

	public static void main(String[] args) {
		
		Logs.logger.setCurrentIdRun(1);
		Plot.main(null);

	}

}
