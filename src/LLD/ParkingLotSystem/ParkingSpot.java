package LLD.ParkingLotSystem;

public abstract class ParkingSpot {

    private int number ;
    private boolean isFree ;
    private Vehicle vehicle ;

    public ParkingSpot(int num ){
        this.number = num ;
        this.isFree = true ;
    }

    public void parkVehicle (Vehicle vehicle){
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void freeSpot(){
        this.isFree = true;
        this.vehicle = null ;
    }

    public boolean isAvailable (){
        return isFree;
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);

}

class CompactSpot extends  ParkingSpot{

    public CompactSpot(int number ){
        super(number);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Car || vehicle instanceof  Bike;
    }
}

class LargeSpot extends  ParkingSpot{

    public LargeSpot(int number ){
        super(number);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return true ;
    }
}

