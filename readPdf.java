
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;

public class readPdf implements operateReading {
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
    public boolean testRead(String text) {
        if(text == null) {
            System.out.println("The PDF File is Empty! ");
        }else {

            System.out.println("Successfully read the PDF File!");
            testing = true;
        }
        return testing;



            System.out.println("Successfully read the PDF File! Kopi Is so Strong !!");
            testing = true;
        }
        return testing;

    }

    @Override
    public int wordCounting(String text) {
        synchronized (this) {
            if (text == null || text.isEmpty()) {
                return 0;
            }

            String[] words = text.split("\\s+");
            System.out.println("Number of Word in PDF file : " + words.length);
            return words.length;
        }
    }

    @Override
    public int charCounting(String text) {
        String lines[] = text.split("\\r\n");
        for (String line : lines) {
            //start
            String[] words = line.split(" ");
            for (String word : words) {
                charCount += word.length();
            }//end
        }//End For
        System.out.println("Number of Character in PDF File : " + charCount);
        return charCount;
    }
}
