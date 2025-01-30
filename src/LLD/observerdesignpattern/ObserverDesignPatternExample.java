package LLD.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(int holder);
}

// if there are multiple subject we should have subject interface also
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
