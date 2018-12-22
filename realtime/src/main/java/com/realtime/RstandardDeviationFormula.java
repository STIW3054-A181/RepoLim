package com.realtime;

public class RstandardDeviationFormula implements interfaceStandardDeviation {

    Manager manager = new Manager();

    @Override
    public double divide (double x,double y) {
        double divide = x / y;
        return divide;
    }

    @Override
    public double minus(double x, double y) {
        double minus = x - y;
        return minus;
    }

    @Override
    public double power(double x, int y) {
        double power = Math.pow(x,y);
        return power;
    }

    @Override
    public double SquareRoot(double x) {
        double squareRoot = Math.sqrt(x);
        return squareRoot;
    }

    public double[] list(){
        Rthread rthread = new Rthread();
        //manager.getWord(manager.readPDF())
        double [] sd = new double[rthread.size];
        rthread.array = sd;
        return sd;
    }
}