package multithreading.semaphors;

import java.util.concurrent.*;

class ParkingLot {
    private Semaphore semaphore;

    public ParkingLot(int slots) {
        this.semaphore = new Semaphore(slots);
    }

    public void parkCar(String car) {
        try {
            System.out.println(car + " trying to park...");
            semaphore.acquire(); // Occupy a slot
            System.out.println(car + " parked.");
            Thread.sleep(2000); // Simulate parking duration
            System.out.println(car + " leaving...");
            semaphore.release(); // Free a slot
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Car extends Thread {
    private ParkingLot parkingLot;
    private String name;

    public Car(ParkingLot parkingLot, String name) {
        this.parkingLot = parkingLot;
        this.name = name;
    }

    @Override
    public void run() {
        parkingLot.parkCar(name);
    }
}


public class SemaphoreExample {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3); // Max 3 cars can park

        for (int i = 1; i <= 6; i++) {
            new Car(parkingLot, "Car " + i).start();
        }
    }
}
