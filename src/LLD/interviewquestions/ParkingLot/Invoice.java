package LLD.interviewquestions.ParkingLot;

import java.time.LocalDateTime;

public class Invoice {
    int invoiceId ;
    int fare ;
    LocalDateTime startTime ;
    LocalDateTime exitTime ;
    Vehicle vehicle;

    public Invoice(int invoiceId, int fare, LocalDateTime startTime, LocalDateTime exitTime, Vehicle vehicle) {
        this.invoiceId = invoiceId;
        this.fare = fare;
        this.startTime = startTime;
        this.exitTime = exitTime;
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", fare=" + fare +
                ", startTime=" + startTime +
                ", exitTime=" + exitTime +
                ", vehicle=" + vehicle.getVehicleNumber() +
                '}';
    }
}
