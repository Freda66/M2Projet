package gui;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;
import org.knowm.xchart.ChartBuilder_XY;
import org.knowm.xchart.Chart_XY;
import org.knowm.xchart.Series_XY;
import org.knowm.xchart.Series_XY.ChartXYSeriesRenderStyle;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.internal.style.Styler.LegendPosition;
import org.knowm.xchart.internal.style.markers.SeriesMarkers;

import data.Database;
import data.Result;


public class Plot {
	
	public static void main(String[] args) {
		
		// --------------------------------------------------------------
		
        // Create Database object
        Database db = new Database("db/database.db");

        // Database connection
        db.connect();
        
        // Init class Result object
        Result res = new Result(db);

        // Get the current runID
        Logs.logger.setCurrentIdRun(1);
        String cond = "fk_run="+Logs.logger.getCurrentIdRun();
        
        // Get all entries from database table
		ArrayList<Result> lstRes = res.getEntriesWhere(db, cond);
		
		// Prepare table
		int loopingVal = 0;
		double tabXP1[] = new double [2482];
		double tabYInit[] = new double [2482];
		double tabYOpt[] = new double [2482];
		double tabYMpfr[] = new double [2482];
		
		// --------------------------------------------------------------
		
		// Loop to get all parameters values
		for (Iterator iterator = lstRes.iterator(); iterator.hasNext();) {
			
			// Get element
			Result result = (Result) iterator.next();
			
			// Get current parameters
			String currentParams = result.getParams();

			// Create JSON object from result
			JSONObject obj = new JSONObject(currentParams);

			// Update tabXY
			tabXP1[loopingVal] = (double) obj.get("p_1");
			tabYInit[loopingVal] = result.getResInit();
			tabYOpt[loopingVal] = result.getResOpt();
			tabYMpfr[loopingVal] = result.getResMpfr();

			// Increment
			loopingVal += 1;
			
		}
		
		// --------------------------------------------------------------
		
		// Sort content by X tab

		// --------------------------------------------------------------
		
		double[] xDataP1 = tabXP1;
		double[] yDataY1 = tabYInit;
		double[] yDataY2 = tabYOpt;
		double[] yDataY3 = tabYMpfr;

		// Create Chart
		Chart_XY chart = new ChartBuilder_XY().width(800).height(600).title("Plot").xAxisTitle("XAxis").yAxisTitle("YAxis").build();

		// Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
	    chart.getStyler().setDefaultSeriesRenderStyle(ChartXYSeriesRenderStyle.Line);
	    chart.getStyler().setYAxisDecimalPattern("$ #,###.##");
	    chart.getStyler().setPlotMargin(0);
	    chart.getStyler().setPlotContentSize(.95);
	    
	    // Series
	    Series_XY seriesInit = chart.addSeries("Init", xDataP1, yDataY1);
	    seriesInit.setMarker(SeriesMarkers.NONE);
	 
	    Series_XY seriesOpt = chart.addSeries("Opt", xDataP1, yDataY2);
	    seriesOpt.setMarker(SeriesMarkers.NONE);
	    
	    Series_XY seriesMpfr = chart.addSeries("Mpfr", xDataP1, yDataY3);
	    seriesMpfr.setMarker(SeriesMarkers.NONE);
	    
	    new SwingWrapper(chart).displayChart();

	    // Create Chart
	    //Chart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

	    // Show it
	    //new SwingWrapper(chart).displayChart();

	}

}
