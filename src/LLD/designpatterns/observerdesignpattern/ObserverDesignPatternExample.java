package LLD.designpatterns.observerdesignpattern;
import java.util.ArrayList;
import java.util.List;

// if there are multiple subject we should have subject interface also
//The subject doesn’t need to know the specific classes of its observers, allowing for flexibility.
//The object that has some interesting state is often called subject but since
// it’s also going to notify other objects about the changes to its state, we’ll call it [publisher]
class Subject{
    private int holder ;
    List<Observer> observers = new ArrayList<>();

    //subscription infrastructure
    public void  addObserver(Observer o){
        observers.add(o);
    }

    private void notifyObservers(){
        //publisher communicates with them only via that interface
        for(Observer observer:observers){
            observer.update(holder);
        }
    }

    public void addHolders(int i){
        this.holder+=i;
        System.out.println(holder);
        if(holder>100) notifyObservers();
    }
}

//Subscriber
interface Observer{
    void update(int holder);
}

//Observers can be easily added or removed without affecting the subject
//All other objects that want to track changes to the publisher’s state are called subscribers.
//Concrete Subscriber
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
//all its dependents (called Observers) are automatically notified and updated without being tightly coupled to them.

// client
public class ObserverDesignPatternExample {
    public static void main(String[] args) {

//        The Client creates publisher and subscriber objects separately and
//        then registers subscribers for publisher updates.

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
