package LLD.designpatterns.decoratordesignpattern;

import java.io.BufferedInputStream;

abstract class Bev{


    public enum Size { TALL, GRANDE, VENTI };

    // default
    private Size size = Size.TALL;

    public abstract int cost();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}

class Coke extends  Bev{

    Coke(Size size){
        setSize(size);
    }

    @Override
    public int cost() {
        switch (getSize()) {
            case TALL: return 10;
            case GRANDE: return  7;
            case VENTI: return 5;
            default: return 1;
        }
    }
}

abstract class Decorator extends  Bev{

    Bev bev ;

    public abstract int cost();
}

class Straw extends  Decorator{

    Straw(Bev bev){
        this.bev = bev;
    }

    @Override
    public int cost() {
        int cost = bev.cost();
        switch (getSize()) {
            case TALL: return cost+3;
            case GRANDE: return cost+2;
            case VENTI: return cost+1;
            default: return 0;
        }
    }
}

public class SizeBasedDecorator {
    public static void main(String[] args) {
        Bev b = new Coke(Bev.Size.TALL);
        Bev bevOuterMost = new Straw(b);
        System.out.println(bevOuterMost.cost());
    }
}
