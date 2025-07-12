package multithreading.basicMultithreading.runnablevsthread;
import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter implements Runnable {
    private AtomicInteger counter = new AtomicInteger(0); // Shared variable

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.incrementAndGet();
            System.out.println(this);
            System.out.println(Thread.currentThread().getName() + " Counter: " + counter);
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        SharedCounter task = new SharedCounter(); // Shared object
        System.out.println(task+" "+"here");

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");


        t1.start();
        t2.start();
    }
}
