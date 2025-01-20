package LLD.ParkingLotSystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {

    private ParkingLot parkingLot = new ParkingLot();
    private Map<Vehicle, Ticket> activeTickets = new HashMap<>();

    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot spot = parkingLot.findSpotForVehicle(vehicle);
        if (spot == null) {
            System.out.println("Parking Full");
            return null;
        }
        spot.parkVehicle(vehicle);
        Ticket ticket = new Ticket(vehicle,spot);
        activeTickets.put(vehicle,ticket);
        return ticket;
    }

    public double exitVehicle(Vehicle vehicle) {
        Ticket ticket = activeTickets.get(vehicle);
        Date exitTime = new Date(); // Current time as exit time
        double charge = ticket.calculateCharge(exitTime);
        parkingLot.freeSpot(ticket.getSpot());
        activeTickets.remove(vehicle);
        return charge;
    }
}
