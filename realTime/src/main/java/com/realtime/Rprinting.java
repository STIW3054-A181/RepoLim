package com.realtime;

import java.io.File;
import java.text.DecimalFormat;

public class Rprinting implements interfacePrintingResult {

    @Override
    public void printStart(){
        System.out.println("\n\n ====================    START ANALYSING    ==================== \n\n");
    }

    @Override
    public void printFileName(String fileName) {
        synchronized (this) {
            try {
                Thread.sleep(1000);
                File f = new File(fileName);
                System.out.println("The Analysis of PDF File --> " + f.getName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void printWord(int word) {
        synchronized (this) {
            try {
                Thread.sleep(1000);
                System.out.println("The Number of Word : " + word);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void printChar(int word) {
        synchronized (this) {
            try{
                Thread.sleep(1000);
                System.out.println("The Number of Character : " + word);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void printSD(double sd){
        synchronized (this){
            try {
                Thread.sleep(1000);
                System.out.println("Total Standard Deviation : " + sd);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void printZscore(double zscore){
        synchronized (this){
            try {
                Thread.sleep(1000);
                System.out.println("The Value of Z-score : " + zscore);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    @Override
    public void printEnd(){
        System.out.println("\n\n ====================     ANALYSING END    ==================== \n\n");
    }

}
