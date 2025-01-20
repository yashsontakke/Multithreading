package LLD.observerdesignpattern;

public interface ISubject {

    public void add(Observer o);
    public void remove(Observer o);
    public  void notifyObservers();

}
