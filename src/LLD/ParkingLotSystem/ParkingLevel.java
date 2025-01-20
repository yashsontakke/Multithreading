package LLD.ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    int floorNumber ;
    List<ParkingSpot> list ;

    public ParkingLevel(int floorNumber){
        this.floorNumber = floorNumber;
        this.list= new ArrayList<>();
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle){
        for(ParkingSpot spot: list){
            if(spot.isAvailable() && spot.canFitVehicle(vehicle)){
                return spot ;
            }
        }
        return null;
    }
}
