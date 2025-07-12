package LLD.designpatterns.observerdesignpattern.stock;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockName, double stockPrice);
}

interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}


class Stock implements Subject {
    private String name;
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(); // Notify all when price changes
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(name, price);
        }
    }
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(name + " notified: " + stockName + " is now $" + stockPrice);
    }
}

public class StockExample {

    public static void main(String[] args) {
        Stock apple = new Stock("Apple", 150.00);

        Observer investor1 = new Investor("Alice");
        Observer investor2 = new Investor("Bob");

        apple.attach(investor1);
        apple.attach(investor2);

        apple.setPrice(155.00); // All investors get notified
        apple.setPrice(160.50);
    }

}
