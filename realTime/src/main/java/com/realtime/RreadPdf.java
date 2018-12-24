package com.realtime;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.RecursiveTask;

public class RreadPdf extends RecursiveTask <Integer> implements interfaceReading {

    String text = null;
    int charCount = 0;
    boolean testing = false;
    int numC, numW;

    @Override
    public String readPDF(String fileName) throws IOException {

        try(PDDocument pdDocument = PDDocument.load(new File(fileName))){
            pdDocument.getClass();
            if(!pdDocument.isEncrypted()){
                PDFTextStripperByArea pStripper = new PDFTextStripperByArea();
                pStripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                text = tStripper.getText(pdDocument);

                //Clear... Successfully read the file.
                //System.out.println(text);

                pdDocument.close();
            }//Close Document
        }//End Try
        return text;
    }

    public RreadPdf(){
        //Empty Constructor
    }

    public RreadPdf (String text){
        this.text = text;
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


    public int[] getWord(String text){
        String lines[] = text.split("\\r\n");
        int c = 0;
        int arrayWord [] = new int[3000];
        for (String line : lines) {
            //start
            String[] words = line.split(" ");
            for (String word : words) {
                arrayWord[c] = word.length();
                charCount += word.length();
                c++;
            }//end
        }
        return arrayWord;
    }

    @Override
    protected Integer compute() {
        try {
            if(text != null){
                //Word Counting
                String text1 = text;
                String[] words = text.split("\\s+");
                numW = words.length;

                String lines[] = text1.split("\\r\n");
                for (String line : lines) {
                    //start
                    String[] word1 = line.split(" ");
                    for (String word11 : word1) {
                        charCount += word11.length();
                    }//end
                }//End For
                numC = charCount;

            }else {
                RreadPdf wordCount = new RreadPdf(text);
                wordCount.fork();
                wordCount.join();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  numW + numC;
    }
}
