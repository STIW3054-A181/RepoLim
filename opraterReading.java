package com.realtime;

import java.io.IOException;

public class opraterReading implements operateReading{
    private operateReading or;

    public void setOperateReading(readPdf or){
        this.or = or;
    }

    @Override
    public String readPDF(String fileName) throws IOException {
        return this.or.readPDF(fileName);
    }

    @Override
    public boolean testRead(String text) {
        return this.or.testRead(text);
    }

    @Override
    public int wordCounting(String text) {
        return this.or.wordCounting(text);
    }

    @Override
    public int charCounting(String text) {
        return this.or.charCounting(text);
    }


}
