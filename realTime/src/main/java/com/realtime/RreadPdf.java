package com.realtime;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RreadPdf implements interfaceReading {

    String text = null;
    int charCount = 0;
    boolean testing = false;
    Scanner scanner;
    String word;
    ArrayList<String> words= new ArrayList<>();

    @Override
    public String readPDF(String fileName) throws IOException {

        try(PDDocument pdDocument = PDDocument.load(new File(fileName))){
            pdDocument.getClass();
            if(!pdDocument.isEncrypted()){
                PDFTextStripperByArea pStripper = new PDFTextStripperByArea();
                pStripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                text = tStripper.getText(pdDocument);

                //Clear... Successfully read the fcking file.
                //System.out.println(text);

                pdDocument.close();
            }//Close Document
        }//End Try
        return text;
    }

    @Override
    public boolean testRead(String text) throws InterruptedException {
        if(text == null) {
            System.out.println("The PDF File is Empty! ");
            System.exit(0);
            //End the Program
        }else {
            Thread.sleep(1000);
            testing = true;
        }
        return testing;
    }

    @Override
    public int getWord(String text){
        try {
            scanner = new Scanner(text);
            if (!scanner.hasNext()) {
                System.out.println("Text is Null.. Try Again");
                //System.exit(0);
            } else {
                //Thread.sleep(1000);
                while (scanner.hasNext()) {
                    word = scanner.next();
                    words.add(word);
                }//End while Loops
                //System.out.println(words.size());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(words.size());
        return words.size();
    }

    @Override
    public int wordCounting(String text) throws InterruptedException {
        synchronized (this) {
            if (text == null || text.isEmpty()) {
                return 0;
            }
            Thread.sleep(1000);
            String[] words = text.split("\\s+");
            return words.length;
        }
    }

    @Override
    public int charCounting(String text) throws InterruptedException {
        String lines[] = text.split("\\r\n");
        for (String line : lines) {
            //start
            String[] words = line.split(" ");
            for (String word : words) {
                charCount += word.length();
            }//end
        }//End For
        Thread.sleep(1000);
        return charCount;
    }
}
