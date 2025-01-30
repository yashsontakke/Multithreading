package LLD.statedesignpattern;

interface  TrafficLightState{
    void changeLight(TrafficLight trafficLight);
    String getColor();
}

class RedLightState implements TrafficLightState{

    @Override
    public void changeLight(TrafficLight trafficLight) {
        System.out.println("Red to Green");
        trafficLight.setState(new GreenLightState());
    }

    @Override
    public String getColor() {
        return "RED";
    }
}

class GreenLightState implements TrafficLightState{

    @Override
    public void changeLight(TrafficLight trafficLight) {
        System.out.println("Green to Yellow");
        trafficLight.setState(new YellowLightState());
    }

    @Override
    public String getColor() {
        return "GREEN";
    }
}

class YellowLightState implements TrafficLightState{

    @Override
    public void changeLight(TrafficLight trafficLight) {
        System.out.println("Yellow to Red");
        trafficLight.setState(new RedLightState());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}

class TrafficLight{
    TrafficLightState trafficLightState;

    public TrafficLight(){
        this.trafficLightState = new RedLightState();
    }

    void setState(TrafficLightState state){
        this.trafficLightState = state ;
    }

    void changeLight(){
        trafficLightState.changeLight(this);
    }

    public String getCurrentColor() {
        return trafficLightState.getColor();
    }

}


public class StateDesignPatternExample {

    public static void main(String[] args) {
        TrafficLight trafficLight= new TrafficLight();

        for(int i=0;i<10;i++){
            System.out.println(trafficLight.getCurrentColor());
            trafficLight.changeLight();
        }

    }
}
