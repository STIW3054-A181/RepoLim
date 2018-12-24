
package com.realtime;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public interface interfaceGraph {
    double [][] xyValue(double size, double [] value);
    XYChart createChart(double [][] xyvalue);
    SwingWrapper swing();
    void updateChart(double [] yvalue);
}

