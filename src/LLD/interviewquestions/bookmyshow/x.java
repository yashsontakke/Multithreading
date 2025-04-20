package LLD.interviewquestions.bookmyshow;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class x {
}



class Seatt {
    private int seatId;
    private boolean isBooked;
    private boolean isReserved;
    private String reservedBy; // Stores the user who reserved
    private final Lock lock = new ReentrantLock();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    Seatt(int seatId) {
        this.seatId = seatId;
        this.isBooked = false;
        this.isReserved = false;
        this.reservedBy = null;
    }

    public boolean reserveSeat(String userId) {
        if (lock.tryLock()) {
            try {
                if (!isBooked && !isReserved) {
                    isReserved = true;
                    reservedBy = userId; // Store the reserving user
                    System.out.println("Seat " + seatId + " reserved by " + userId + " for 10 minutes.");

                    // Schedule release after 10 minutes if not booked
                    scheduler.schedule(() -> releaseReservation(userId), 10, TimeUnit.MINUTES);

                    return true;
                }
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean bookSeat(String userId, String paymentDetails) {
        if (lock.tryLock()) {
            try {
                if (!isBooked && isReserved && reservedBy.equals(userId)) { // Only the reserving user can book
                    boolean paymentSuccess = processPayment(paymentDetails);
                    if (!paymentSuccess) {
                        releaseReservation(userId); // Payment failed, release seat
                        return false;
                    }

                    isBooked = true;
                    isReserved = false;
                    reservedBy = null;
                    System.out.println("Seat " + seatId + " successfully booked by " + userId);
                    return true;
                }
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    private boolean processPayment(String paymentDetails) {
        System.out.println("Processing payment for seat " + seatId);
        return Math.random() > 0.2; // Simulating 80% success rate
    }

    private void releaseReservation(String userId) {
        if (!isBooked && isReserved && reservedBy.equals(userId)) {
            isReserved = false;
            reservedBy = null;
            System.out.println("Seat " + seatId + " reservation expired for user " + userId);
        }
    }
}
