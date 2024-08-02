package basicMultithreading;
import java.util.Collection;
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
        while(true){
            synchronized (list){
                while(list.size()==5){
                    list.wait();
                }
                list.add(counter);
                System.out.println("Added" + counter++);
                list.notifyAll();
            }
            Thread.sleep(500);
        }
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
