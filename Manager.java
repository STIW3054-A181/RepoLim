package com.realtime;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.io.IOException;

public class Manager implements interfaceReading, interfaceThread, interfaceGraph, interfacePrintingResult {
    public Runnable readPdf;
    private interfaceReading or;
    private interfaceThread interfaceThread;
    private interfaceGraph graphInterface;
    private interfacePrintingResult printing;

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

    @Override
    public Runnable thread1(String fileName) {
        return this.interfaceThread.thread1(fileName);
    }

    /*
                  Display the Chart Method

     */

    @Override
    public XYChart createChart(double[][] xyvalue) {
        return this.graphInterface.createChart(xyvalue);
    }

    @Override
    public SwingWrapper swing() {
        return this.graphInterface.swing();
    }

    @Override
    public void updateChart(double[][] xyvalue) {
        this.graphInterface.updateChart(xyvalue);
    }

    /*
                Print the result method

     */

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
}
