package com.realtime;

public class StoreSD {

    double value;

    public StoreSD(){
        //Empty
    }
    public StoreSD(double value){
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}