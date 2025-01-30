package LLD.strategydesignpattern;

interface MathOperation {
    double execute(double a , double b );
}

class Addition implements MathOperation{

    @Override
    public double execute(double a , double b ) {
        return a+b;
    }
}

class Multiplication implements MathOperation{
    @Override
    public double execute(double a , double b ) {
        return a*b;
    }
}

class  Calculator{
    MathOperation mathOperation;

    public void setMathOperation(MathOperation mathOperation){
        this.mathOperation = mathOperation;
    }

    public double performOperation(double a , double b ){
        return mathOperation.execute(a,b);
    }

}
public class StrategyDesignPatternExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setMathOperation(new Addition());
        System.out.println(calculator.performOperation(123,123));
        calculator.setMathOperation(new Multiplication());
        System.out.println(calculator.performOperation(123,123));
    }
}
