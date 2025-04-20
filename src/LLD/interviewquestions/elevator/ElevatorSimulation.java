package LLD.interviewquestions.elevator;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

enum Direction {
    UP, DOWN, IDLE
}

 class Logger {
    private static final Logger instance = new Logger();

    private Logger() {} // Private constructor to prevent multiple instances

    public static Logger getInstance() {
        return instance;
    }

    public synchronized void log(String message) {
        System.out.println(message);
    }
}

class Elevator implements Runnable {

    private final Logger logger = Logger.getInstance();
    private final int id;
    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;
    private boolean isMoving = false;

    // Separate thread-safe queues for up and down requests
    private final BlockingQueue<Integer> upRequests = new PriorityBlockingQueue<>();
    private final BlockingQueue<Integer> downRequests = new PriorityBlockingQueue<>(10, Collections.reverseOrder());
    private final ExecutorService elevatorExecutor = Executors.newSingleThreadExecutor();

    public Elevator(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

    public void addRequest(int floor) {
        if (floor > currentFloor) {
            upRequests.offer(floor);
        } else {
            downRequests.offer(floor);
        }
        startMoving();
    }

    private void startMoving() {
        if (!isMoving) {
            isMoving = true;
            //Imagine pressing an elevator button and the whole system freezes until the elevator reaches its destination. Not ideal!
            elevatorExecutor.submit(this);
        }
    }

    @Override
    public void run() {
        while (!upRequests.isEmpty() || !downRequests.isEmpty()) {
            if (!upRequests.isEmpty()) {
                direction = Direction.UP;
                processRequests(upRequests);
            } else {
                direction = Direction.DOWN;
                processRequests(downRequests);
            }
        }
        isMoving = false;
        direction = Direction.IDLE;
    }

    private void processRequests(BlockingQueue<Integer> queue) {
        while (!queue.isEmpty()) {
            int nextFloor = queue.poll();
            moveToFloor(nextFloor);
        }
    }

    private void moveToFloor(int floor) {
        if (currentFloor == floor) return;  // Avoid duplicate logging if already there
        logger.log("🚀 Elevator " + id + " moving to floor " + floor);
        simulateTravelTime();
        currentFloor = floor;
        logger.log("✅ Elevator " + id + " stopped at floor " + currentFloor);
    }

    private void simulateTravelTime() {
        try {
            Thread.sleep(1000); // Simulate elevator movement time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ElevatorController {

    private final List<Elevator> elevators;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Logger logger = Logger.getInstance();

    public ElevatorController(int numElevators) {
        elevators = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= numElevators; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public void requestPickup(int floor, Direction direction) {
        logger.log("📌 Pickup request at floor " + floor);
        Elevator bestElevator = findBestElevator(floor, direction);
        if (bestElevator != null) {
            bestElevator.addRequest(floor);
        }
    }

    public void requestDrop(Elevator elevator, int floor) {
        logger.log("⬇️ Drop request inside Elevator " + elevator.getId() + " to floor " + floor);
        elevator.addRequest(floor);
    }


    // this also can lead to concurrency issue
    //An elevator might be IDLE when the method checks, but before assigning it,
    // another request might have made it busy, leading to inconsistencies.(That's why assigning lock )
    private Elevator findBestElevator(int floor, Direction direction) {
        lock.readLock().lock();  // Use read lock to allow concurrent reads
        try {
            return elevators.stream()
                    .filter(e -> e.getDirection() == Direction.IDLE ||
                            (direction == Direction.UP && e.getCurrentFloor() <= floor && e.getDirection() == Direction.UP) ||
                            (direction == Direction.DOWN && e.getCurrentFloor() >= floor && e.getDirection() == Direction.DOWN))
                    .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - floor)))
                    .orElse(null);
        } finally {
            lock.readLock().unlock(); // Release lock before modifying state
        }

    }

    public Elevator getElevator(int id) {
        return elevators.get(id - 1);
    }
}

public class ElevatorSimulation {

    private static final ExecutorService requestExecutor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        ElevatorController controller = new ElevatorController(2);

        // Simulate pickup requests in separate threads
        requestExecutor.submit(() -> controller.requestPickup(3, Direction.UP));
        requestExecutor.submit(() -> controller.requestPickup(7, Direction.DOWN));
        requestExecutor.submit(() -> controller.requestPickup(8, Direction.DOWN));

        // Get elevator instance
        Elevator elevator1 = controller.getElevator(1);

        // Simulate drop requests in separate threads
        requestExecutor.submit(() -> controller.requestDrop(elevator1, 10));
        requestExecutor.submit(() -> controller.requestDrop(elevator1, 5));
    }
}

