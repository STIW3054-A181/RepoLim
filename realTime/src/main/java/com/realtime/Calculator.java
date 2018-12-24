package com.realtime;

import java.util.concurrent.RecursiveTask;

public class Calculator extends RecursiveTask <Double> {

    public int totalWord, totalChar;
    public double mean;
    public double minus;
    public double minuz;
    public double square;
    public double standardDeviation;
    public double variance;
    public double zScore;

    public Calculator(){
        //empty
    }

    //public Calculator(){

    //}

    @Override
    protected Double compute() {
        Rthread rthread = new Rthread();
        Manager countSD = new Manager();
        countSD.countStandardDeviation(new RstandardDeviationFormula());
        Manager countZ = new Manager();
        countZ.countZScore(new RzscoreFormula());

        //For
        for(int b = 0; b < rthread.totalWord; b++){
            //Thread.sleep(50);
            rthread.mean = countSD.divide(rthread.totalWord, rthread.totalChar);
            //For each X value minus Mean
            //rthread.minus = countSD.minus(array1[b], rthread.mean);

            //Then Power 2 of the [ X minus Mean ]
            rthread.square = countSD.power(minus,2);

            //Variance = Answer from the Above divide Total Number of Words
            rthread.variance = countSD.divide(square, totalWord);//square (total-mean)/n

            //Standard Deviation = Square Root of the Variance [answer from the Previous]
            rthread.standardDeviation = countSD.SquareRoot(variance);

            //array_SD[b] = standardDeviation; //---> Store in array for calculate total SD
            //array_Zscore[b] = zScore;        //---> Store in array for calculate total Zscore
            System.out.println("Word Index " + (b+1) + " : SD --> " + standardDeviation);
            //System.out.println("Word Index " + (b+1) + " : Z-score --> " + zScore);
        }
        //for(int a = 0; a < totalWord; a++){
        //    minuz = countZscore.minusz(array1[a],mean);
        //    zScore = countZscore.dividez(minuz,standardDeviation);
        //}
        return null;
    }
}
