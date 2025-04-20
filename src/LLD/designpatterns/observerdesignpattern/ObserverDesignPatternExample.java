package LLD.designpatterns.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;

// if there are multiple subject we should have subject interface also
//The subject doesn’t need to know the specific classes of its observers, allowing for flexibility.
class Subject{
    private int holder ;
    List<Observer> observers = new ArrayList<>();

    public void  addObserver(Observer o){
        observers.add(o);
    }

    private void notifyObservers(){
        for(Observer observer:observers){
            observer.update(holder);
        }
    }

    public  void addHolders(int i){
        this.holder+=i;
        System.out.println(holder);
        if(holder>100) notifyObservers();
    }
}

interface Observer{
    void update(int holder);
}

//Observers can be easily added or removed without affecting the subject
class NotificationObserver implements  Observer{

    @Override
    public void update(int holder) {
        System.out.println("notification sent  :"+  holder);
    }
}

class EmailObserver implements  Observer{

    @Override
    public void update(int holder) {
        System.out.println("Email sent  :"+  holder);
    }
}

// The Observer Design Pattern is a behavioral design pattern that defines a one-to-many dependency between objects.
//When the state of one object (called the Subject) changes,
//all its dependents (called Observers) are automatically notified and updated.


public class ObserverDesignPatternExample {
    public static void main(String[] args) {
        Observer o1 = new EmailObserver();
        Observer o2 =  new NotificationObserver();
        Subject subject = new Subject();
        subject.addObserver(o1);
        subject.addObserver(o2);

        subject.addHolders(10);

        subject.addHolders(90);
        subject.addHolders(900);


    }
}
