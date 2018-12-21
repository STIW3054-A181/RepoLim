package com.realtime;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.io.IOException;

public class Manager implements interfaceReading, interfaceThread, interfaceGraph,
        interfacePrintingResult, interfaceStandardDeviation {
    //public Runnable readPdf;
    private interfaceReading or;
    private interfaceThread interfaceThread;
    private interfaceGraph graphInterface;
    private interfacePrintingResult printing;
    private interfaceStandardDeviation standardDeviation;

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
    public int getWord(String text){
        return this.or.getWord(text);
    }

    @Override
    public int wordCounting(String text) throws InterruptedException {
        return this.or.wordCounting(text);
    }

    @Override
    public int charCounting(String text) throws InterruptedException {
        return this.or.charCounting(text);
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
    public double [][] xyValue(double second, double value){
        return this.graphInterface.xyValue(second, value);
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
    public void updateChart(double [][] xyvalue) {
        this.graphInterface.updateChart(xyvalue);
    }

    /*
                Print the result method

     */

    public void setPrinting(Rprinting printing){
        this.printing = printing;
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

    //@Override
    //public double[] list(double sdValue){
    //    return this.standardDeviation.list(sdValue);
    //}
}
