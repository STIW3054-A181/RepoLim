
import java.io.IOException;
import java.util.concurrent.RecursiveTask;

public class Rthread extends Thread implements interfaceThread {


    public static double mean;
    public static double minus;
    public static double total;
    public static double square;
    public static double standardDeviation;
    public static double n;
    public static double variance;

    @Override
    public Runnable thread1(final String fileName){
        synchronized (this){
            final Manager opraterReading = new Manager();
            opraterReading.setOperateReading(new RreadPdf());

            final Manager manager = new Manager();
            manager.setFormula(new formula());

            final Rprinting printingClass = new Rprinting();

    @Override
    public Runnable thread1(String fileName){
        synchronized (this){
            Manager opraterReading = new Manager();
            opraterReading.setOperateReading(new RreadPdf());
            Rprinting printingClass = new Rprinting();

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (opraterReading.testRead(opraterReading.readPDF(fileName)) == true) {
                            Thread.sleep(1000);
                            printingClass.printFileName(fileName);
                            printingClass.printWord(opraterReading.wordCounting(opraterReading.readPDF(fileName)));
                            printingClass.printChar(opraterReading.charCounting(opraterReading.readPDF(fileName)));



                            total=opraterReading.wordCounting(opraterReading.readPDF(fileName));//total word
                            n=opraterReading.charCounting(opraterReading.readPDF(fileName));//total num of char

                            mean=manager.divide(total,n); //total num/total char
                            minus=manager.minus(total,mean);//total-mean
                            square=manager.power(minus,2);//square (total-mean)
                            variance=manager.divide(square,n);//square (total-mean)/n
                            standardDeviation=manager.SquareRoot(variance);//squareRoot(Variance)

                            System.out.println("Standard Deviation = "+standardDeviation);
                            //join();
                        } else
                            System.out.println("Failed to READ PDF File.");

                            //join();
                        } else
                            System.out.println("Failed to READ PDF File. Stupid dickHead");

                    }catch (IOException e){
                        e.printStackTrace();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            return t1;

        }//end Syncrhonized
    }

}
