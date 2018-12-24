package com.realtime;

import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.io.IOException;

public class Manager implements interfaceReading, interfaceThread, interfaceGraph,
        interfacePrintingResult, interfaceStandardDeviation, interfaceZscore, interfaceBoxplot{

    private interfaceReading or;
    private interfaceThread interfaceThread;
    private interfaceGraph graphInterface;
    private interfacePrintingResult printing;
    private interfaceStandardDeviation standardDeviation;
    private interfaceZscore interfaceZscore;
    private interfaceBoxplot boxplotInterface;

    public void setOperateReading(RreadPdf or){
        this.or = or;
    }

    /*
                Read the file, count word...

     */

    @Override
    public String readPDF(String fileName) throws IOException {
        return this.or.readPDF(fileName);
    }

    @Override
    public boolean testRead(String text) throws InterruptedException {
        return this.or.testRead(text);
    }


    @Override
    public int[] getWord(String text){
        return this.or.getWord(text);
    }


    /*
                Thread Method --> Inside running all function

     */

    public void setThreadRunning(Rthread interfaceThread){
        this.interfaceThread = interfaceThread;
    }

    @Override
    public Runnable thread1(String fileName) {
        return this.interfaceThread.thread1(fileName);
    }

    /*
                  Display the Chart Method

     */

    public void displayGraph(interfaceGraph graph){
        this.graphInterface = graph;
    }

    @Override
    public double [][] xyValue(double size, double [] value){
        return this.graphInterface.xyValue(size, value);
    }

    @Override
    public XYChart createChart(double[][] xyvalue) {
        return this.graphInterface.createChart(xyvalue);
    }

    @Override
    public SwingWrapper swing() {
        return this.graphInterface.swing();
    }

    @Override
    public void updateChart(double [] yvalue) {
        this.graphInterface.updateChart(yvalue);
    }

    /*
                Print the result method

     */

    public void setPrinting(Rprinting printing){
        this.printing = printing;
    }

    @Override
    public void printStart(){
        this.printing.printStart();
    }

    @Override
    public void printFileName(String fileName) {
        this.printing.printFileName(fileName);
    }

    @Override
    public void printWord(int word) {
        this.printing.printWord(word);
    }

    @Override
    public void printChar(int word) {
        this.printing.printChar(word);
    }

    @Override
    public void printSD(double sd){
        this.printing.printSD(sd);
    }

    @Override
    public void printZscore(double zscore){
        this.printing.printZscore(zscore);
    }

    @Override
    public void printEnd(){
        this.printing.printEnd();
    }


    /*

                Calculation for Standard Deviation

     */

    public void countStandardDeviation(interfaceStandardDeviation standardDeviation){
        this.standardDeviation = standardDeviation;
    }

    @Override
    public double divide(double x, double y) {
        return this.standardDeviation.divide(x,y);
    }

    @Override
    public double minus(double x, double y) {
        return this.standardDeviation.minus(x,y);
    }

    @Override
    public double power(double x, int y) {
        return this.standardDeviation.power(x,y);
    }

    @Override
    public double SquareRoot(double x) {
        return this.standardDeviation.SquareRoot(x);
    }

    /*

                Count Z-Score

     */

    public void countZScore(interfaceZscore interfaceZscoreValue){
        this.interfaceZscore = interfaceZscoreValue;
    }

    @Override
    public double dividez(double x, double y) {
        return this.interfaceZscore.dividez(x,y);
    }

    @Override
    public double minusz(double x, double y) {
        return this.interfaceZscore.minusz(x,y);
    }

    /*

            Create BoxPlot

     */

    public void setBoxplotInterface(interfaceBoxplot boxplotInterface){
        this.boxplotInterface = boxplotInterface;
    }

    @Override
    public BoxAndWhiskerCategoryDataset createDataset() {
        return this.boxplotInterface.createDataset();
    }


    @Override
    public JFreeChart createChart(BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset) {
        return this.boxplotInterface.createChart(boxAndWhiskerCategoryDataset);
    }

}
