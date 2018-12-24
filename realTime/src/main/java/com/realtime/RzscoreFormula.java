package com.realtime;

public class RzscoreFormula implements interfaceZscore{

    @Override
    public double dividez(double x, double y) {
        double divide = x / y;
        return divide;
    }

    @Override
    public double minusz(double x, double y) {
        double minus = x - y;
        return minus;
    }
}
