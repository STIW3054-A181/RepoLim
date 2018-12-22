package com.realtime;

import java.io.IOException;
import java.util.ArrayList;

public class Rthread extends Thread implements interfaceThread {

    public int totalWord, totalChar;
    public double mean;
    public double minus;
    public double square;
    public double standardDeviation;
    public double variance;

    int size = 0;
    //StoreSD storeSD;

    double array[];
    // Store each Standard Deviation in the Array
    ArrayList <StoreSD> list = new ArrayList <StoreSD>();


    @Override
    public Runnable thread1(String fileName){
        synchronized (this){
            Manager reading = new Manager();
            reading.setOperateReading(new RreadPdf());

            Manager printing = new Manager();
            printing.setPrinting(new Rprinting());

            Manager countSD = new Manager();
            countSD.countStandardDeviation(new RstandardDeviationFormula());

            try {

                totalWord = reading.wordCounting(reading.readPDF(fileName)); //Total Words
                totalChar = reading.charCounting(reading.readPDF(fileName)); //Total Character

                if (reading.testRead(reading.readPDF(fileName)) == true) {
                    //Thread.sleep(1000);
                    printing.printFileName(fileName);
                    printing.printWord(totalWord);
                    printing.printChar(totalChar);

                            /*
                                    Calculate the Standard Deviation According to
                                    the Number of Words from the PDF File.
                                    Formula:
                                    SD = Sqr of { [ (X - mean)^2 ] / totalWord }
                             */

                    //Get Mean Value for the PDF File
                    // Total Number divide Total Character = Mean
                    mean = countSD.divide(totalWord, totalChar);

                    //For each X value minus Mean
                    minus = countSD.minus(totalWord, mean);

                    //Then Power 2 of the [ X minus Mean ]
                    square = countSD.power(minus,2);

                    //Variance = Answer from the Above divide Total Number of Words
                    variance = countSD.divide(square, totalWord);//square (total-mean)/n

                    //Standard Deviation = Square Root of the Variance [answer from the Previous]
                    standardDeviation = countSD.SquareRoot(variance);
                    StoreSD storeSD = new StoreSD(standardDeviation);
                    list.add(storeSD);

                    for(int a = 0; a < list.size(); a++){
                        System.out.println(list.size());
                    }


                } else
                    System.out.println("Failed to READ PDF File.");
            }catch (IOException e){
                e.printStackTrace();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return this;

        }//end Syncrhonized



    public void generateGraph(){
        Manager graph = new Manager();
        graph.displayGraph(new Rgraph());
        double counter = 0.0;
        System.out.println("Mother f"+list.size());
    }

}
