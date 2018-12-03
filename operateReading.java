package com.realtime;

import java.io.IOException;

public interface operateReading {
    String readPDF(String fileName) throws IOException;
    boolean testRead(String text);
    int wordCounting(String text);
    int charCounting(String text);
}
