package com.realtime;

import java.util.concurrent.Callable;

public class myCallable implements Callable <String> {
    long time;

    public myCallable(){
        //empty
    }

    public myCallable (long time){
        this.time = time;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Total Running Time : " + time + " ms";
    }
}
