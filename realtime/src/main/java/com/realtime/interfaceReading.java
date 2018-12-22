package com.realtime;

import java.io.IOException;

public interface interfaceReading {
    String readPDF(String fileName) throws IOException;
    boolean testRead(String text) throws InterruptedException;
    int getWord(String text);
    int wordCounting(String text) throws InterruptedException;
    int charCounting(String text) throws InterruptedException;
    //int getWord(int value);
}