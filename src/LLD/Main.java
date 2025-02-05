package LLD;
import java.util.ArrayList;
import java.util.List;

interface  Observer{
    void notifyObserver(String message);
}

class WeatherStation{
    List<Observer> observers ;

    public  WeatherStation(){
        observers = new ArrayList<>();
    }

    public void notifyObservers(String message){
        for(Observer observer:observers){
            observer.notifyObserver(message);
        }
    }

    public void updateWeather(int weather ){
        if(weather>90){
            notifyObservers("weather is too hot "+ weather);
        }
        if(weather<10){
            notifyObservers("weather is too cold "+ weather);
        }
    }

    public  void addObserver(Observer observer){
        observers.add(observer);
    }
}

class EmailNotification implements Observer {
    String name ;

    public EmailNotification(String name){
        this.name = name;
    }

    @Override
    public void notifyObserver(String message) {
        System.out.println("To"+ name + message);
    }
}

class SmsNotification implements  Observer{
    String name ;

    public SmsNotification(String name){
        this.name= name ;
    }

    @Override
    public void notifyObserver(String message) {
        System.out.println("To"+ name + message);
    }
}
class Main{
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        for(int i=0;i<5;i++){
            weatherStation.addObserver(new EmailNotification("E"+i));
        }
        for(int i=0;i<7;i++){
            weatherStation.addObserver(new SmsNotification("E"+i));
        }
        for(int i=0;i<100;i++){
            int weather = (int)Math.floor(Math.random()*100);
            weatherStation.updateWeather(weather);
        }
    }
}

