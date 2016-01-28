package gui;

import org.knowm.xchart.Chart;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;

public class Plot {
	
	public static void main(int idRun) {
		double[] xData = new double[] { 0.0, 1.0, 2.0 };
	    double[] yData = new double[] { 2.0, 1.0, 0.0 };

	    // Create Chart
	    Chart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

	    // Show it
	    new SwingWrapper(chart).displayChart();

	}

}
