package com.realtime;

import java.util.concurrent.*;

public class App {

    public static String pdfFile1 = "C:\\Users\\SCS\\Desktop\\a3.pdf"; //
    public static String pdfFile2 = "C:\\Users\\SCS\\Desktop\\Ep3 Writing.pdf";
    public static String pdfFile3 = "C:\\Users\\SCS\\Desktop\\managementQuality.pdf";
    public static String pdfFile4 = "C:\\Users\\SCS\\Desktop\\investmentAnalysis.pdf";
    public static String pdfFile5 = "C:\\Users\\SCS\\Desktop\\studentList.pdf"; //

    public static void main( String[] args ) {
        try {
            //Time Start
            long start = System.currentTimeMillis();

            //Create Graph
            Manager graph = new Manager();
            graph.displayGraph(new Rgraph());

            //Execute
            Rthread threadClass = new Rthread();
            ExecutorService service = Executors.newSingleThreadExecutor();

            service.execute(threadClass.thread1(pdfFile1));
            service.execute(threadClass.thread1(pdfFile2));
            service.execute(threadClass.thread1(pdfFile3));
            service.execute(threadClass.thread1(pdfFile4));
            service.execute(threadClass.thread1(pdfFile5));
            threadClass.join();

            double sdValueForGraph [] = new double[6];
            double xAxis = 1.0;

            for(int a = 0; a < threadClass.list.size(); a++){
                sdValueForGraph[a] = threadClass.list.get(a).getValue();
                //  Save to the array to pass data to the graph
            }

            graph.createChart(graph.xyValue(xAxis, sdValueForGraph)); //----> Create xChart
            graph.swing();                                            //----> Display xChart

            for(int b = 0; b <= threadClass.list.size(); b++){
                graph.updateChart(sdValueForGraph);
            }


            //Before end , calculate the Total Running Time
            long end = System.currentTimeMillis();
            long time = end - start;

            Future <String> future = service.submit(new myCallable(time));

            System.out.println("\n\n\n"+future.get());


            //End
            service.shutdown();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
