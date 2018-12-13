import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;

public class RreadPdf implements interfaceReading {
    String text = null;
    int charCount = 0;
    boolean testing = false;

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
        }else {
            Thread.sleep(1000);
            //System.out.println("Successfully read the PDF File!");
            testing = true;
        }
        return testing;
    }

    @Override
    public int wordCounting(String text) throws InterruptedException {
        synchronized (this) {
            if (text == null || text.isEmpty()) {
                return 0;
            }
            Thread.sleep(1000);
            String[] words = text.split("\\s+");
            //System.out.println("Number of Word in PDF file : " + words.length);
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
        //System.out.println("Number of Character in PDF File : " + charCount);
        return charCount;
    }
}
