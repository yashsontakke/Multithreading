package LLD.designpatterns.decoratordesignpattern;

interface Beverage{
    public int cost();   // interface methods are by default public because they are meant to be implemented by other classes
    //All non-static and non-default methods in an interface are implicitly public.
}

// everyone is Beverage milk sugar Espresso
class Espresso implements  Beverage{       // this does not take any beverage as reference

    @Override
    public int cost() {
        return 10;
    }
}

//the abstract keyword adds clarity to the design, making it clear that BeverageDecorator should be extended, not instantiated directly.
abstract class BeverageDecorator implements  Beverage{
    Beverage beverage ;  // The decorator class holds an instance of the original object and delegates all calls to it, thereby preserving its behavior.

    BeverageDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    public int cost(){
        return beverage.cost();
    }

}

class  Milk extends  BeverageDecorator{

    Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return super.cost()+5;    // calling inner reference
    }
    // Additional functionality is implemented in the decorator class itself.
}

class  Sugar extends BeverageDecorator{

    Sugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return super.cost()+7;
    }
}


public class DecoratorDesignPatternExample {
    public static void main(String[] args) {

        Beverage espresso = new Espresso(); // base object is decided at compile-time

        //You didn’t replace the original Espresso.
        //You just wrapped it with extra behavior.
        //The Decorator Pattern is used to dynamically add behavior to an object at runtime, without modifying its structure

        //wrapping it with Milk or Sugar dynamically composes new behavior during execution
        espresso = new Milk(new Sugar(new Espresso()));   // Milk IS-A Beverage
        System.out.println(espresso.cost());
        //recursive wrapping – each decorator can wrap another Beverage, including other decorators.
    }
}
