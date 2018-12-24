package com.realtime;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;

public class Rgraph implements interfaceGraph {

    XYChart chart = null;
    SwingWrapper <XYChart> swing = null;
    public double [] x;
    public double [] y;


    @Override
    public double [][] xyValue(double size, double []value){
        synchronized(this) {
            x = new double[2];
            y = new double[2];

            for(int a = 1; a <= size; a++) {
                x[a] = size;
                y[a] = value[a-1];
            }
            return new double[][]{x, y};
        }
    }

    @Override
    public XYChart createChart(double [][] xyvalue) {
        chart = QuickChart.getChart(
                        "Standard Deviation per PDF File",
                        "Number of File",
                        "Standard Deviation",
                        "Value",
                        xyvalue[0],
                        xyvalue[1]
                );
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setXAxisTicksVisible(true);
        chart.getStyler().setToolTipsEnabled(true);
        chart.getStyler().setSeriesColors(
                new Color[]{Color.pink});
        return chart;
    }

    @Override
    public SwingWrapper swing() {
        try {
            Thread.sleep(1000);
            swing = new SwingWrapper<XYChart>(chart);
            swing.displayChart();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return swing;
    }

    @Override
    public void updateChart(double [] yvalue) {
        XYSeries series = chart.updateXYSeries("Value", null, yvalue, null);
        series.setMarker(SeriesMarkers.CROSS);
        series.setMarkerColor(Color.BLUE);
        swing.repaintChart();
    }
}
