package com.realtime;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler;

import java.awt.*;

public class Rgraph implements interfaceGraph {

    XYChart chart = null;
    SwingWrapper <XYChart> swing = null;
    double counter = 0;
    public double [] x;
    public double [] y;


    @Override
    public double [][] xyValue(double second, double value){
        synchronized(this) {
            Rthread rthread = new Rthread();
            StoreSD storeSD = new StoreSD();
            App app = new App();

            x = new double[10];
            y = new double[10];


            for(int a = 0; a < 2; a++) {
                counter = a + (1 * Math.PI / x.length * a);
                x[a] = a+1;
                y[(int) second] = value;
            }


            return new double[][]{x, y};
        }
    }

    @Override
    public XYChart createChart(double [][] xyvalue) {
        chart = QuickChart.getChart(
                        "Standard Deviation of Character per Word",
                        "Number of File",
                        "Standard Deviation",
                        "Value",
                        xyvalue[0],
                        xyvalue[1]
                );
        chart.getStyler().setLegendVisible(true);
        //chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
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
    public void updateChart(double [][] xyvalue) {
        chart.updateXYSeries("Value", xyvalue[0], xyvalue[1], null);
        swing.repaintChart();
    }
}