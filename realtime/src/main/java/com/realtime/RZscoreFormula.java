package com.realtime;

public class RZscoreFormula implements interfaceZscore{
	
	Manager manager = new Manager();

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
