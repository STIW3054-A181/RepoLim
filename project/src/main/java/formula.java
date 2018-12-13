
public class formula implements formulaInterface{
    private formulaInterface fl;


public double divide (double x,double y)
{
    double divide = x / y;
    return divide;
}

 public double minus(double x, double y)
 {
        double minus = x - y;
        return minus;
 }

    public double power(double x, int y) {
        double power = Math.pow(x,y);
        return power;
    }


    public double SquareRoot(double x) {
        double squareRoot = Math.sqrt(x);
        return squareRoot;
    }


}
