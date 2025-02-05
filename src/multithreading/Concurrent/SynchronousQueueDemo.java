package multithreading.Concurrent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.IntStream;
public class SynchronousQueueDemo {



    static BlockingQueue<Integer> synQueue  = new SynchronousQueue<>();
    public static void main(String[] args) {
        Thread producer = new Thread(()->{
            IntStream.range(1,10).forEach((i)->{
                try {
                    // SynchronousQueue will not put element until some consumer takes from queue
                    synQueue.put(i);
                    System.out.println("processing task "+ i );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }) ;


        Thread consumerOne = new Thread(()->{
            while(true){
                try {
                   int task = synQueue.take();
//                   processTask(task,"consumerOne");
                    System.out.println("consuming task"+ task);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        });

        Thread consumerTwo = new Thread(()->{
            while(true){
                try {
                    int task = synQueue.take();
//                    processTask(task,"consumerTwo");
                    System.out.println(task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumerOne.start();
//       consumerTwo.start();

    }
//    private static void processTask(int task , String consumerName) throws InterruptedException {
//        System.out.println("Task being processed by " + consumerName  +":"+ task );
//        Thread.sleep(100);
//        System.out.println("Task being consumed by " + consumerName +":"+ task);
//    }
}
