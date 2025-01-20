package LLD.ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private List<ParkingLevel> levels;

    public ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            ParkingSpot spot = level.findAvailableSpot(vehicle);
            if (spot != null) return spot;
        }
        return null; // No spot available
    }

    public void freeSpot(ParkingSpot spot) {
        spot.freeSpot();
    }
}
