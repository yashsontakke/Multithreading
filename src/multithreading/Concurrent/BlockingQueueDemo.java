package multithreading.Concurrent;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class BlockingQueueDemo {

    private static final int  QUEUE_CAPACITY = 10;
    static BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {

        // producer thread
        Thread producer = new Thread(()->{
            IntStream.range(1,10).forEach((i)->{
                try {
                    taskQueue.put(i);
                    System.out.println("task produced" + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        // consumer thread
        Thread consumerOne = new Thread(()->{
            while(true){
                try {
                    int task = taskQueue.take();
                    processTask(task,"consumerOne");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerTwo = new Thread(()->{
            while(true){
                try {
                    int task = taskQueue.take();
                    processTask(task,"consumerTwo");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumerOne.start();;
        consumerTwo.start();

    }

    private static void processTask(int task , String consumerName) throws InterruptedException {
        System.out.println("Task being processed by " + consumerName  +":"+ task );
        Thread.sleep(100);
        System.out.println("Task being consumed by " + consumerName +":"+ task);
    }
}
