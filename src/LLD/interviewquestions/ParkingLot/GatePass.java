package LLD.interviewquestions.ParkingLot;

import java.time.LocalDateTime;

public class GatePass {
    int gatePassId ;
    LocalDateTime time ;
    VehicleType vehicleType;
    Slot slot ;
    Vehicle vehicle;

    public GatePass (int gatePassId , LocalDateTime time , VehicleType vehicleType , Slot slot , Vehicle vehicle){
        this.gatePassId = gatePassId;
        this.time = time;
        this.vehicle=vehicle;
        this.vehicleType = vehicleType;
        this.slot = slot;

    }

    @Override
    public String toString() {
        return "GatePass{" +
                "gatePassId=" + gatePassId +
                ", time=" + time +
                ", vehicleType=" + vehicleType +
                ", slotId=" + slot.slotId +
                ", vehicle=" + vehicle.getVehicleNumber() +
                '}';
    }
}
