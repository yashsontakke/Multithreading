package LLD.ParkingLotSystem;

import java.util.Date;

public class Ticket {

    private Vehicle vehicle ;
    private Date entryTime ;
    private ParkingSpot spot ;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = new Date(); // Current time as entry time
    }

    public ParkingSpot getSpot(){
        return spot ;
    }

    public double calculateCharge(Date exitTime){
        long duration = exitTime.getTime() - entryTime.getTime();
        return (duration / 1000 / 60) * 0.5;
    }



}
