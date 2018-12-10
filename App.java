package com.realtime;

import java.util.concurrent.*;

public class App {

    public static String pdfFile1 = "C:\\Users\\SCS\\Desktop\\studentList.pdf";
    public static String pdfFile2 = "C:\\Users\\SCS\\Desktop\\article.pdf";

    public static void main( String[] args ) throws InterruptedException {
        Rthread threadClass = new Rthread();
        Rgraph rgraph = new Rgraph();
        ExecutorService service = Executors.newFixedThreadPool(1);

        service.execute(threadClass.thread1(pdfFile1));
        service.execute(threadClass.thread1(pdfFile2));
        threadClass.join();
        service.shutdown();
        double [] x ={1,5,6,8};
        double [] y ={100,200,300,400};
        double[][] xy = {x,y};
        //rgraph.createChart(xy);
        //rgraph.swing();

    }
}
