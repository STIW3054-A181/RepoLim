package com.realtime;

import java.io.IOException;

public class App {

    static String pdfFile = "C:\\Users\\SCS\\Desktop\\studentList.pdf";

    public static void main( String[] args ) throws IOException {
        opraterReading opraterReading = new opraterReading();
        opraterReading.setOperateReading(new readPdf());

        //opraterReading.readPDF(pdfFile);
        if(opraterReading.testRead(opraterReading.readPDF(pdfFile)) == true) {
            opraterReading.wordCounting(opraterReading.readPDF(pdfFile));
            opraterReading.charCounting(opraterReading.readPDF(pdfFile));
        }
        else
            System.out.println("Failed to READ PDF File. Stupid dickHead");
    }
}
