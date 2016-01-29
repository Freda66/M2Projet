package gui;

import java.util.ArrayList;
import java.util.Arrays;
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
		String cond = "fk_run=" + Logs.logger.getCurrentIdRun();

		// Get all entries from database table
		ArrayList<Result> lstRes = res.getEntriesWhere(db, cond);

		// Prepare table
		int loopingVal = 0;
		double tabXP1[] = new double[lstRes.size()];
		double tabYInit[] = new double[lstRes.size()];
		double tabYOpt[] = new double[lstRes.size()];
		double tabYMpfr[] = new double[lstRes.size()];

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

			System.out.println(
					tabXP1[loopingVal] + "|" 
					+ tabYInit[loopingVal] + "|" 
					+ tabYOpt[loopingVal] + "|"
					+ tabYMpfr[loopingVal]);

			// Increment
			loopingVal += 1;

		}

		// --------------------------------------------------------------

		// TODO : trier les xData
		

		// --------------------------------------------------------------

		// Create Chart
		Chart_XY chart = new ChartBuilder_XY().width(800).height(600).title("Plot").xAxisTitle("XAxis")
				.yAxisTitle("YAxis").build();

		// Customize Chart
		chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
		chart.getStyler().setDefaultSeriesRenderStyle(ChartXYSeriesRenderStyle.Line);
		chart.getStyler().setYAxisDecimalPattern("#,###.##########");
		chart.getStyler().setPlotMargin(0);
		chart.getStyler().setPlotContentSize(.70);

		// Series
		Series_XY seriesInit = chart.addSeries("Init", tabXP1, tabYInit);
		seriesInit.setMarker(SeriesMarkers.CIRCLE);

		Series_XY seriesOpt = chart.addSeries("Opt", tabXP1, tabYOpt);
		seriesOpt.setMarker(SeriesMarkers.CIRCLE);

		Series_XY seriesMpfr = chart.addSeries("Mpfr", tabXP1, tabYMpfr);
		seriesMpfr.setMarker(SeriesMarkers.CIRCLE);

		new SwingWrapper(chart).displayChart();

		// Create Chart
		// Chart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)",
		// xData, yData);

		// Show it
		// new SwingWrapper(chart).displayChart();

	}

}
