package LLD.designpatterns.statedesignpattern;

interface TrafficLightState {
    void changeLight(TrafficLight trafficLight);
    String getColor();
}

class RedLightState implements TrafficLightState {
    private static final RedLightState INSTANCE = new RedLightState(); // Singleton instance

    private RedLightState() {} // Private constructor to prevent instantiation

    public static RedLightState getInstance() {
        return INSTANCE;
    }

    @Override
    public void changeLight(TrafficLight trafficLight) {
        System.out.println("Red to Green");
        trafficLight.setState(GreenLightState.getInstance()); // Reusing existing object
    }

    @Override
    public String getColor() {
        return "RED";
    }
}

class GreenLightState implements TrafficLightState {
    private static final GreenLightState INSTANCE = new GreenLightState();

    private GreenLightState() {}

    public static GreenLightState getInstance() {
        return INSTANCE;
    }

    @Override
    public void changeLight(TrafficLight trafficLight) {
        System.out.println("Green to Yellow");
        trafficLight.setState(YellowLightState.getInstance());
    }

    @Override
    public String getColor() {
        return "GREEN";
    }
}

class YellowLightState implements TrafficLightState {
    private static final YellowLightState INSTANCE = new YellowLightState();

    private YellowLightState() {}

    public static YellowLightState getInstance() {
        return INSTANCE;
    }

    @Override
    public void changeLight(TrafficLight trafficLight) {
        System.out.println("Yellow to Red");
        trafficLight.setState(RedLightState.getInstance());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}

class TrafficLight {
    private TrafficLightState trafficLightState;

    public TrafficLight() {
        this.trafficLightState = RedLightState.getInstance(); // Initial state
    }

    void setState(TrafficLightState state) {
        this.trafficLightState = state;
    }

    void changeLight() {
        trafficLightState.changeLight(this);
    }

    public String getCurrentColor() {
        return trafficLightState.getColor();
    }
}

public class StateDesignPatternExample {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        for (int i = 0; i < 10; i++) {
            System.out.println(trafficLight.getCurrentColor());
            trafficLight.changeLight();
        }
    }
}
