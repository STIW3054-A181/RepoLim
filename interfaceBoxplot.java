package com.realtime;

import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;

public interface interfaceBoxplot {
    BoxAndWhiskerCategoryDataset createDataset();
    JFreeChart createChart(BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset);
}
