package LLD.designpatterns.practice;

interface MathOperation{
    int operation(int a , int b );
}

class Addition implements  MathOperation{

    @Override
    public int operation(int a, int b) {
        return a+b;
    }
}

class Substraction implements  MathOperation{

    @Override
    public int operation(int a, int b) {
        return a-b;
    }
}

class Calculator{
    MathOperation mathOperation;

    public void setState(MathOperation mathOperation){
        this.mathOperation = mathOperation;
    }

    public  int oper(int a , int b ){
        return mathOperation.operation(a,b);
    }

}

public class Main{

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setState(new Addition());
        System.out.println(calculator.oper(234,32));
    }
}