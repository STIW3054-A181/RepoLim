package com.realtime;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public interface interfaceGraph {
    XYChart createChart(double [][] xyvalue);
    SwingWrapper swing();
    void updateChart(double [][] xyvalue);
}
