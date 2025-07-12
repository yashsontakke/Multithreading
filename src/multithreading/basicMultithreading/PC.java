package multithreading.basicMultithreading;


import java.util.ArrayDeque;
import java.util.Queue;

public class PC {
    Queue<Integer> queue = new ArrayDeque<>();

    public void  add(int val) throws InterruptedException {
        synchronized (queue){
            while(this.size()==10){
                queue.wait();
            }
            queue.add(val);
            queue.notifyAll();   //  All waiting threads (producers and consumers) are woken up.
        }
    }

    public void remove() throws InterruptedException {
        synchronized (queue){
            while(this.size()==0){
                queue.wait();
            }
            queue.remove();
            queue.notifyAll();
        }
    }

    public int size(){
        return queue.size();
    }

    public static void main(String[] args) throws InterruptedException {
        PC pc = new PC();

        Thread producer = new Thread(()->{
            for(int i=0;i<500;i++){
                try {
                    pc.add((int)(Math.random()*10+10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        Thread consumer = new Thread(()->{
            for(int i=0;i<500;i++){
                try {
                    pc.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(pc.size());


    }
}
