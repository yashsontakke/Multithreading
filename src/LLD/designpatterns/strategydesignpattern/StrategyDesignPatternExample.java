package LLD.designpatterns.strategydesignpattern;

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

//The Strategy Pattern is designed for situations where you have a family of interchangeable behaviors
// that can be chosen dynamically based on a particular context
public class StrategyDesignPatternExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setMathOperation(new Addition());
        System.out.println(calculator.performOperation(123,123));
        //Client selects the strategy at runtime
        calculator.setMathOperation(new Multiplication());
        System.out.println(calculator.performOperation(123,123));
    }
}

//Both patterns define a common interface for different behaviors.
//But in State, the object controls which behavior to use based on its internal condition —
//        it's good for workflow and life cycle management.
//In Strategy, the client decides the algorithm and injects it —
//        it’s ideal for interchangeable logic like different payment or sorting options."

