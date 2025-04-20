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
        //The Decorator Pattern is used to dynamically add behavior to an object at runtime, without modifying its structure
        Beverage beverage = new Milk(new Sugar(new Espresso()));
        System.out.println(beverage.cost());
    }
}
