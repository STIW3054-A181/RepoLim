package com.realtime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class Rthread extends Thread implements interfaceThread{

    public int totalWord, totalChar;
    public double mean;
    public double minus;
    public double minuz;
    public double square;
    public double standardDeviation;
    public double variance;
    public double zScore;

    int array1 [];

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

            Manager countZscore = new Manager();
            countZscore.countZScore(new RzscoreFormula());

            printing.printStart();

            try {
                ForkJoinPool forkJoinPool = new ForkJoinPool();
                RreadPdf rreadPdf = new RreadPdf(reading.readPDF(fileName));
                forkJoinPool.invoke(rreadPdf);

                totalWord = rreadPdf.numW;
                totalChar = rreadPdf.numC;

                if (reading.testRead(reading.readPDF(fileName)) == true) {
                    printing.printFileName(fileName);
                    printing.printWord(totalWord);
                    printing.printChar(totalChar);

                    String text = rreadPdf.readPDF(fileName); // ---> Get the Text Again
                    array1 = new int[3000];
                    array1 = rreadPdf.getWord(text);

                    System.out.println("\nStandard Deviation for Each Word");
                    double array_SD [] = new double[totalWord];

                    /*

                            Calculate the Standard Deviation According to
                            the Number of Words from the PDF File.
                            Formula:
                            SD = Sqr of { [ (X - mean)^2 ] / totalWord }

                    */

                    Thread.sleep(2000);
                    mean = countSD.divide(totalWord, totalChar);// --> Get the Mean value 1st
                    for(int b = 0; b < totalWord; b++){
                        //Thread.sleep(50);

                        //For each X value minus Mean
                        minus = countSD.minus(array1[b], mean);

                        //Then Power 2 of the [ X minus Mean ]
                        square = countSD.power(minus,2);

                        //Variance = Answer from the Above divide Total Number of Words
                        variance = countSD.divide(square, totalWord);//square (total-mean)/n

                        //Standard Deviation = Square Root of the Variance [answer from the Previous]
                        standardDeviation = countSD.SquareRoot(variance);

                        array_SD[b] = standardDeviation; //---> Store in array for calculate total SD
                        System.out.println("Word Index " + (b+1) + " : SD --> " + standardDeviation);
                    }

                    double total_SD = 0; // --> To add Total Standard Deviation from this Current PDF
                    //double total_Zscore = 0; // --> To add Total Zscore from this current PDF
                    for(int b = 0; b < array_SD.length; b++){
                        double value1 = array_SD[b];
                        //double value2 = array_Zscore[b];
                        total_SD = total_SD + value1;
                        //total_Zscore = total_Zscore + value2;
                    }

                    minuz = countZscore.minusz(totalWord, mean);
                    zScore = countZscore.dividez(minuz, total_SD);

                    //Store the Total SD Value to plot graph
                    StoreSD storeSD = new StoreSD(total_SD);
                    list.add(storeSD);

                    //Print out Total Standard Deviation Value
                    printing.printSD(total_SD);
                    printing.printZscore(zScore);

                    //End
                    printing.printEnd();
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
}
