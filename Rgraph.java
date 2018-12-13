import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler;

import java.awt.*;

public class Rgraph implements interfaceGraph {
    XYChart chart = null;
    SwingWrapper <XYChart> swing = null;
    @Override
    public XYChart createChart(double [][] xyvalue) {
        chart = QuickChart.getChart(
                        "Random Number Chart",
                        "Second",
                        "Number",
                        "Value",
                        xyvalue[0],
                        xyvalue[1]
                );
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setXAxisTicksVisible(true);
        chart.getStyler().setToolTipsEnabled(true);
        chart.getStyler().setSeriesColors(
                new Color[]{Color.pink});
        return chart;
    }

    @Override
    public SwingWrapper swing() {
        swing = new SwingWrapper<XYChart>(chart);
        swing.displayChart();
        return swing;
    }

    @Override
    public void updateChart(double[][] xyvalue) {
        chart.updateXYSeries("NumberOfWord", xyvalue[0], xyvalue[1], null);
        swing.repaintChart();
    }
}
