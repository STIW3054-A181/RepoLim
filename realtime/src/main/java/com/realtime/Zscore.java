package com.realtime;

import java.io.IOException;
import java.util.ArrayList;

public class Zscore extends Thread implements interfaceThread {

    public int totalWord, totalChar;
    public double mean;
    public double minus;
    public double standardDeviation;
    public double zscore;


    @Override
    public Runnable thread1(String fileName){
        synchronized (this){
            Manager reading = new Manager();
            reading.setOperateReading(new RreadPdf());

            Manager printing = new Manager();
            printing.setPrinting(new Rprinting());
            
            Manager countSD = new Manager();
            countSD.countStandardDeviation(new RstandardDeviationFormula());
            
            Manager countZ = new Manager();
            countZ.countZscore(new RZscoreFormula());

            try {

                totalWord = reading.wordCounting(reading.readPDF(fileName)); //Total Words
                totalChar = reading.charCounting(reading.readPDF(fileName)); //Total Character
                standardDeviation = countSD.countStandardDeviation(standardDeviation);

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
                    mean = countZ.dividez(totalWord, totalChar);

                    //For each X value minus Mean
                    minus = countZ.minusz(totalWord, mean);

                 
               


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

