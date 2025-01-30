package LLD.decoratordesignpattern;

interface Beverage{
    public int cost();
}
// everyone is Beverage milk sugar Espresso
class Espresso implements  Beverage{       // this does not take any beverage as reference

    @Override
    public int cost() {
        return 10;
    }
}

abstract class EspressoDecorator implements  Beverage{
    Beverage beverage ;     // everyone has reference of its inner decorator to which call will be passed

    EspressoDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    public int cost(){
        return beverage.cost();
    }

}

class  Milk extends  EspressoDecorator{

    Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return super.cost()+5;    // calling inner reference
    }
}

class  Sugar extends EspressoDecorator{

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
        Beverage beverage = new Milk(new Sugar(new Espresso()));
        System.out.println(beverage.cost());
    }
}
