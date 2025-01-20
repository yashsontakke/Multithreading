package LLD.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class Subject implements  ISubject {

    List<Observer> observerList = new ArrayList<>();

    int val = 10;

    @Override
    public void add(Observer o) {
        observerList.add(o);
    }
    @Override
    public  void remove(Observer o){
        observerList.remove(o);
    }

    public void setValue(int val){
        this.val = val;
        notifyObservers();
    }

    @Override
    public  void notifyObservers() {
        for(Observer o: observerList){
            o.notify(val);
        }
    }

}
