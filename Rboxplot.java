package com.realtime;

import org.jfree.chart.ui.ApplicationFrame;

import java.awt.*;
import java.util.Arrays;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

public class Rboxplot extends ApplicationFrame implements interfaceBoxplot{
    //String tittle;

    public Rboxplot(String tittle){
        super(tittle);
        BoxAndWhiskerCategoryDataset boxandwhiskercategorydataset = createDataset();
        JFreeChart jfreechart = createChart(boxandwhiskercategorydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart, false);
        chartpanel.setPreferredSize(new Dimension(500, 400));
        setContentPane(chartpanel);
    }

    /*

            Value of SD for All PDF Files {Total 6 PDF Files}
            From Smaller to Largest
            [39.6351 , 43.6189 , 61.9679 , 69.2776 , 123.4548, 158.5630]
            Q1 = 6/4 = 1.5th --> (39.6351 + 43.6189)/2 = 41.627
            Q2 = 6/2 = 3th --> 69.1768
            Q3 = 6*3/4 = 4.5th --> (123.4548 + 69.2776)/2 = 96.3662

     */

    @Override
    public BoxAndWhiskerCategoryDataset createDataset() {
        DefaultBoxAndWhiskerCategoryDataset defaultboxandwhiskercategorydataset = new DefaultBoxAndWhiskerCategoryDataset();
        defaultboxandwhiskercategorydataset.add(
                Arrays.asList(39.6351 , 43.6189 , 61.9679 , 69.2776 , 123.4548, 158.5630),
                "Standard Deviation" , "PDF File ");
        return defaultboxandwhiskercategorydataset;
    }


    @Override
    public JFreeChart createChart(BoxAndWhiskerCategoryDataset boxandwhiskercategorydataset) {
        CategoryAxis categoryaxis = new CategoryAxis(null);
        NumberAxis numberaxis = new NumberAxis("Value of Standard Deviation");
        BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        renderer.setMeanVisible(false);
        renderer.setSeriesOutlinePaint(0, Color.BLACK);
        CategoryPlot categoryplot = new CategoryPlot(boxandwhiskercategorydataset, categoryaxis, numberaxis, renderer);
        JFreeChart jfreechart = new JFreeChart("Box Plot of Standard Deviation for 6 PDF Files", categoryplot);
        jfreechart.setBackgroundPaint(Color.white);
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.white);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jfreechart;
    }
}
