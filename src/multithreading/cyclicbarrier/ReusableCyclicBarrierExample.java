package multithreading.cyclicbarrier;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CyclicBarrier;

public class ReusableCyclicBarrierExample {

    public static void main(String[] args) {
        int numThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numThreads, () ->
                System.out.println("Barrier tripped! All threads proceed."));


        Runnable task = () -> {
            for (int i = 1; i <= 2; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " - round " + i + " working...");
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                    System.out.println(name + " - round " + i + " waiting at barrier");
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < numThreads; i++) {
            new Thread(task, "Thread-" + (i + 1)).start();
        }
    }
}
