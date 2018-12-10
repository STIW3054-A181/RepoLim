package com.realtime;

import java.io.IOException;
import java.util.concurrent.RecursiveTask;

public class Rthread extends Thread implements interfaceThread {

    @Override
    public Runnable thread1(String fileName){
        synchronized (this){
            Manager opraterReading = new Manager();
            opraterReading.setOperateReading(new RreadPdf());
            Rprinting printingClass = new Rprinting();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (opraterReading.testRead(opraterReading.readPDF(fileName)) == true) {
                            Thread.sleep(1000);
                            printingClass.printFileName(fileName);
                            printingClass.printWord(opraterReading.wordCounting(opraterReading.readPDF(fileName)));
                            printingClass.printChar(opraterReading.charCounting(opraterReading.readPDF(fileName)));
                            //join();
                        } else
                            System.out.println("Failed to READ PDF File. Stupid dickHead");
                    }catch (IOException e){
                        e.printStackTrace();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            return t1;

        }//end Syncrhonized
    }

}
