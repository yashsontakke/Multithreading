package multithreading.basicMultithreading;
import java.util.LinkedList;
public class ProducerConsumerProblem {

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();

        Thread t1 = new Thread(()->{
            try {
                queue.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                queue.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
class BlockingQueue{
    LinkedList<Integer> list = new LinkedList<>();
    int counter =0;
    public void produce() throws InterruptedException {
            synchronized (list){
                while(list.size()==5){
                    list.wait();
                    // thread release lock when waiting so other producer thread can also enter synchronized block
                    // multiple threads can wait in waiting queue here by releasing lock
                    // all waiting for notify (to be eligible to acquire lock again )that's why while instead of if
                }
                list.add(counter);
                System.out.println("Added" + counter++);
                list.notifyAll();    // notifies but does not release lock immediately
            }
            // here lock will be released and thread scheduler will give lock to one of the waiting thread (pro or consumer)
            Thread.sleep(500);
    }
    public void consume() throws InterruptedException{
        while (true){
            synchronized (list){
                while (list.isEmpty()){
                    list.wait();
                }
                int elem = list.remove(0);
                System.out.println("removed "+ elem);
                list.notifyAll();
            }
            Thread.sleep(500);
        }
    }

}
