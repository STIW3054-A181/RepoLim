package com.realtime;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public interface interfaceGraph {
    double [][] xyValue(double second, double value);
    XYChart createChart(double [][] xyvalue);
    SwingWrapper swing();
    void updateChart(double [][] xyvalue);
}
