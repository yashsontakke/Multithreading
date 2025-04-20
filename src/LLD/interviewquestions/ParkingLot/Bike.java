package LLD.interviewquestions.ParkingLot;

public class Bike implements  Vehicle {
    String vehicleNumber ;

    public Bike(String vehicleNumber ) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return VehicleType.BIKE; // or BIKE, depending on the object
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}
