package LLD.interviewquestions.ParkingLot;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class ParkingLot {

    private List<Level> levels;

    public ParkingLot(int level , int slots){
        levels = new ArrayList<>();
       for(int i=0;i<level;i++){
           Level newLevel = new Level(i , new ArrayList<>());
           levels.add(newLevel);
           for(int j=0;j<slots;j++){
               Slot slot = new Slot(j,i,j>=6?VehicleType.BIKE:VehicleType.CAR);
               newLevel.slots.add(slot);
           }
       }
    }

    public GatePass createGatePass(Vehicle vehicle){

        for(int i=0;i<levels.size();i++){
            ArrayList<Slot> slots = levels.get(i).slots;
            for(Slot slot :slots){
                if(!slot.isParked && vehicle.getVehicleType().equals(slot.VehicleType)){
                    slot.isParked = true;
                    GatePass gatePass =  new GatePass((int)(100*Math.random()), LocalDateTime.now(),vehicle.getVehicleType(), slot ,vehicle);
                    return  gatePass;

                }
            }
        }

        return null ;
    }

    public Invoice createInvoice(GatePass gatePass){
        int fare = (LocalDateTime.now().getSecond() - gatePass.time.getSecond()) *(gatePass.vehicleType == VehicleType.CAR ? 2 : 1);
        return new Invoice((int)Math.random()*100,fare,gatePass.time,LocalDateTime.now(),gatePass.vehicle);
    }

    public static void main(String[] args) throws InterruptedException {

        ParkingLot parkingLot = new ParkingLot(2,10);

        Vehicle car1 = new Car(",MH263267");
        Vehicle bike1 = new Bike("MH273423");

//        // Step 4: Park Vehicles
//        System.out.println("Parking Car...");
        GatePass carPass = parkingLot.createGatePass(car1);
        if (carPass != null) {
            System.out.println("Car GatePass: " + carPass);
        } else {
            System.out.println("No slot available for Car");
        }
//
//        System.out.println("\nParking Bike...");
        GatePass bikePass = parkingLot.createGatePass(bike1);
        if (bikePass != null) {
            System.out.println("Bike GatePass: " + bikePass);
        } else {
            System.out.println("No slot available for Bike");
        }

        // Step 5: Unpark Vehicles
        if (carPass != null) {
            System.out.println("\nUnpacking Car...");

        Thread.sleep(4000);
            Invoice carInvoice = parkingLot.createInvoice(carPass);
            System.out.println("Car Invoice: " + carInvoice);
        }

        if (bikePass != null) {
            System.out.println("\nUnpacking Bike...");
            Invoice bikeInvoice = parkingLot.createInvoice(bikePass);
            System.out.println("Bike Invoice: " + bikeInvoice);
        }
    }
}
