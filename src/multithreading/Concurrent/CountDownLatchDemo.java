package multithreading.Concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);
        new Thread(new Task(1,latch)).start();
        new Thread(new Task(2,latch)).start();
        new Thread(new Task(3,latch)).start();

        latch.await();   // will wait for all threads to finish
        System.out.println("Threads Finished ");


    }
}

class Task implements  Runnable{

    private final int num ;
    private final CountDownLatch latch ;

    public Task(int i  , CountDownLatch latch ){
        this.num = i ;
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println("Thread " + num + "running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + num + "completed ");
        latch.countDown();
    }
}
