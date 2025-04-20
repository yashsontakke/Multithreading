package LLD.interviewquestions.ParkingLot;

enum VehicleType{
    CAR ,
    BIKE
}

public class Slot {
    int slotId ;
    int levelId ;
    boolean isParked;
    VehicleType VehicleType ;

    public Slot(int id , int levelId  , VehicleType vehicleType){
        this.slotId = id ;
        this.levelId = levelId;
        this.VehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", levelId=" + levelId +
                ", isParked=" + isParked +
                ", VehicleType=" + VehicleType +
                '}';
    }
}
