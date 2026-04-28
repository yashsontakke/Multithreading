package multithreading.cyclicbarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3,()-> System.out.println("all released "));

        Runnable task = ()->{
            System.out.println(Thread.currentThread().getName()+"doing some work ");
            try {
                System.out.println(Thread.currentThread().getName()+"reached barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName()+"crossed the barrier");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        for(int i=0;i<3;i++){
            new Thread(task,"Thread "+i ).start();
        }
    }
}
