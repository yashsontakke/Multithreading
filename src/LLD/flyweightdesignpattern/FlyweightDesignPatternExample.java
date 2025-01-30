package LLD.flyweightdesignpattern;
import java.util.HashMap;
import java.util.Map;

interface Flyweight{

}

class CarFlyweight implements Flyweight  {
    private final String model;

    public CarFlyweight(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

class BikeFlyweight implements Flyweight  {
    private final String model;

    public BikeFlyweight(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

class VehicleFlyweightFactory {
    private static final Map<String,Flyweight> vehicleMap = new HashMap<>();

    public static Flyweight getVehicle(String model) {
        if(vehicleMap.containsKey(model)) return vehicleMap.get(model);
        if(model.equals("car")){
            vehicleMap.put(model,new CarFlyweight("car"));
        }else if (model.equals("bike")){
            vehicleMap.put("bike",new BikeFlyweight("bike"));
        }
        return vehicleMap.get(model);
    }
}

public class FlyweightDesignPatternExample {
    public static void main(String[] args) {
        Flyweight vehicle1 = VehicleFlyweightFactory.getVehicle("car");
        Flyweight vehicle2 = VehicleFlyweightFactory.getVehicle("bike");
        Flyweight vehicle3 = VehicleFlyweightFactory.getVehicle("car");// Reuses the same object

        System.out.println(vehicle1 == vehicle3); // true (same object)
    }
}
