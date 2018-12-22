package com.realtime;

import java.io.File;

public class Rprinting implements interfacePrintingResult {

    @Override
    public void printFileName(String fileName) {
        synchronized (this) {
            File f = new File(fileName);
            System.out.println("\nThe Analysis of PDF File --> " + f.getName());
        }
    }

    @Override
    public void printWord(int word) {
        synchronized (this) {
            System.out.println("The Number of Word : " + word);
        }
    }

    @Override
    public void printChar(int word) {
        synchronized (this) {
            System.out.println("The Number of Character : " + word);
        }
    }

}