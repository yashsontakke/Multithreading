package LLD.ParkingLotSystem;

enum VehicleType {
    CAR,     // Represents cars
    BIKE,    // Represent motorcycles or scooters
    TRUCK    // Represents large vehicles like trucks
}

public abstract class Vehicle {
    protected String licensePlate;
    protected VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
}

// This class does not have the "public" keyword, so it can coexist with Vehicle in the same file
class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}

class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}

class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}