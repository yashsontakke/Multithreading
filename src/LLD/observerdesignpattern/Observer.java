package LLD.observerdesignpattern;

public class Observer implements  IObserver{

    String name ;

    public Observer(String name ){
        this.name = name;
    }

    public void notify(int val) {
        System.out.println("hey "+ name +", updated value is "+ val);
    }
}
