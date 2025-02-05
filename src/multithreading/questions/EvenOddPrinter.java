package multithreading.questions;

public class EvenOddPrinter {

    static int limit = 100;       // The maximum number to print
    static int counter = 1;       // Counter to keep track of numbers
    static Object lock = new Object();  // Lock object for synchronization

    // Method to print even numbers
    static void printEven() throws InterruptedException {
        synchronized (lock) {  // Synchronize on the lock object
            // Wait if the current number is odd
            while (counter % 2 != 0) {
                lock.wait();  // Wait until the counter is even
            }
            // Print the current number and increment the counter
            System.out.println(counter++);
            lock.notify();  // Notify the odd thread to proceed
        }
    }

    // Method to print odd numbers
    static void printOdd() throws InterruptedException {
        synchronized (lock) {  // Synchronize on the lock object
            // Wait if the current number is even
            while (counter % 2 == 0) {
                lock.wait();  // Wait until the counter is odd
            }
            // Print the current number and increment the counter
            System.out.println(counter++);
            lock.notify();  // Notify the even thread to proceed
        }
    }

    public static void main(String[] args) {

        // Create and start the even-number printing thread
        Thread evenThread = new Thread(() -> {
            while (counter <= limit) {
                try {
                    printEven();  // Print even numbers
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create and start the odd-number printing thread
        Thread oddThread = new Thread(() -> {
            while (counter <= limit) {
                try {
                    printOdd();  // Print odd numbers
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start the threads
        evenThread.start();
        oddThread.start();

        // Ensure the main thread waits for both even and odd threads to finish before exiting
        try {
            evenThread.join();  // Wait for the evenThread to finish
            oddThread.join();   // Wait for the oddThread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
