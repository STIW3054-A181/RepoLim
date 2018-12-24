
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.io.IOException;

public class Manager implements interfaceReading, interfaceThread, interfaceGraph, interfacePrintingResult {
    public Runnable readPdf;
    private interfaceReading or;

    private formula standardDeviation;

    private interfaceThread interfaceThread;
    private interfaceGraph graphInterface;
    private interfacePrintingResult printing;


    public void setFormula(formula standardDeviation) {
        this.standardDeviation = standardDeviation;
    }


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



    public double divide(double x,double y)
    {
        return this.standardDeviation.divide(x, y);
    }

    public double minus(double x, double y)
    {
        return this.standardDeviation.minus(x,y);
    }

    public double power(double x, int y)
    {
        return this.standardDeviation.power(x, y);
    }

    public double SquareRoot(double x) {
        return this.standardDeviation.SquareRoot(x);
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


    @Override
    public void printStandardDeviation(double num) {
        this.printing.printStandardDeviation(num);
    }

}
