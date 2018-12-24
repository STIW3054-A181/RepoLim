
package com.realtime;

import org.jfree.chart.ui.UIUtils;

import java.util.Arrays;
import java.util.concurrent.*;

public class App {

    public static String pdfFile1 = "C:\\Users\\SCS\\Desktop\\Ep3 Writing.pdf"; //
    public static String pdfFile2 = "C:\\Users\\SCS\\Desktop\\managementQuality.pdf"; //
    public static String pdfFile3 = "C:\\Users\\SCS\\Desktop\\studentList.pdf"; // -1
    public static String pdfFile4 = "C:\\Users\\SCS\\Desktop\\a3.pdf"; //
    public static String pdfFile5 = "C:\\Users\\SCS\\Desktop\\39Mobile.pdf"; //
    public static String pdfFile6 = "C:\\Users\\SCS\\Desktop\\investmentAnalysis.pdf"; //

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

            //Run the Service
            service.execute(threadClass.thread1(pdfFile1));
            service.execute(threadClass.thread1(pdfFile2));
            service.execute(threadClass.thread1(pdfFile3));
            service.execute(threadClass.thread1(pdfFile4));
            service.execute(threadClass.thread1(pdfFile5));
            service.execute(threadClass.thread1(pdfFile6));
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

            Thread.sleep(1000);
            Arrays.sort(sdValueForGraph);
            System.out.println("For all the Standard Deviation Value {After Sorted}:\n1 -->"
                    + sdValueForGraph[0] +"\n2 -->"
                    + sdValueForGraph[1] +"\n3 -->"
                    + sdValueForGraph[2] +"\n4 -->"
                    + sdValueForGraph[3] +"\n5 -->"
                    + sdValueForGraph[4] +"\n6 -->"
                    + sdValueForGraph[5]);


            //Create BoxPlot
            Rboxplot rboxplot = new Rboxplot("Box Plot");
            rboxplot.pack();
            rboxplot.setVisible(true);
            UIUtils.centerFrameOnScreen(rboxplot);

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
    }//End of Main Method
}//End Class

