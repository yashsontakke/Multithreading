package LLD.interviewquestions.ParkingLot;

public class Car implements  Vehicle{
    String vehicleNumber ;

    public Car(String vehicleNumber ){
        this.vehicleNumber = vehicleNumber ;
    }


    public VehicleType getVehicleType() {
        return VehicleType.CAR; // or BIKE, depending on the object
    }

    @Override
    public String toString() {
        return "Car{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
