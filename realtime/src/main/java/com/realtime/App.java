package com.realtime;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.*;

public class App {
	
	public static String pdfFile1 = "C:\\Users\\user\\Documents\\studentList.pdf";
    //public static String pdfFile1 = "C:\\Users\\SCS\\Desktop\\studentList.pdf";
    //public static String pdfFile2 = "C:\\Users\\SCS\\Desktop\\article.pdf";
    static double sdValueForGraph [];
    static double[][] xy;

    public static void main( String[] args ) throws InterruptedException {
        //double [][] xy = new double[5][5];
        Manager graph = new Manager();
        graph.displayGraph(new Rgraph());

        Rthread threadClass = new Rthread();
        ExecutorService service = Executors.newFixedThreadPool(1);

        service.execute(threadClass.thread1(pdfFile1));
        //service.execute(threadClass.thread1(pdfFile2));
        threadClass.join();
        service.shutdown();

        /*
        threadClass.generateGraph();
        for(int a = 0; a < threadClass.list.size(); a++){
            double [] x = {a+1};
            double [] y = {threadClass.list.get(a).getValue()};
            xy = new double[][]{x,y};
        }
        System.out.println("sad  " + Array.get(xy,0) + "SDAD" + Array.get(xy, 1));
        for(int a = 0; a < threadClass.list.size(); a++) {
            //sdValueForGraph[a] = threadClass.list.get(0).getValue();
        }
        System.out.println("sadad" + threadClass.list.get(0).getValue() + "  asd  " + threadClass.list.get(1).getValue());
        graph.createChart(graph.xyValue(0, threadClass.list.get(0).getValue()));
        graph.swing();
        for(int a = 0; a < threadClass.list.size(); a++){
            //sdValueForGraph [a] = threadClass.list.get(0).getValue();
            graph.updateChart(graph.xyValue(a, threadClass.list.get(a).getValue()));
        }
        //graph.updateChart(graph.xyValue(1, threadClass.list.get(0).getValue()));
        //graph.updateChart(graph.xyValue(2, threadClass.list.get(1).getValue()));
        System.out.println();
        */

    }
}