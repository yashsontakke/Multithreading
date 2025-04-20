package LLD.designpatterns.factorydesignpattern;

// Step 1: Define an interface or abstract class for products
 interface Vehicle {
    void deliver();
}

// Step 2: Create concrete implementations of the product
 class Car implements Vehicle {
    @Override
    public void deliver() {
        System.out.println("Delivering by road using a Car.");
    }
}

 class Plane implements Vehicle {
    @Override
    public void deliver() {
        System.out.println("Delivering by air using a Plane.");
    }
}

 class Ship implements Vehicle {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea using a Ship.");
    }
}

// Step 3: Create a factory class to generate objects
 class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "plane":
                return new Plane();
            case "ship":
                return new Ship();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

// Step 4: Demonstrate the Factory Pattern
// Creational Pattern
// Delegates object creation to subclasses or separate methods
// Hides object instantiation details
// create objects without exposing the creation logic to the client and still refer to newly created objects using a common interface
public class FactoryDesignPatternExample {
    public static void main(String[] args) {
        Vehicle roadVehicle = VehicleFactory.createVehicle("car");
        roadVehicle.deliver();

        Vehicle airVehicle = VehicleFactory.createVehicle("plane");
        airVehicle.deliver();

        Vehicle seaVehicle = VehicleFactory.createVehicle("ship");
        seaVehicle.deliver();
    }
}
