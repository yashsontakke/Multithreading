package multithreading.countdownlatch;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
public class RaceWinner {

    public static void main(String[] args) {

        CountDownLatch startLatch = new CountDownLatch(1);
        AtomicBoolean winner = new AtomicBoolean();

        Runnable runner = ()->{
            try {
                startLatch.await();
                Thread.sleep(1000);
                if(winner.compareAndSet(false,true)){
                    System.out.println(Thread.currentThread().getName()+" won");
                }else{
                    System.out.println(Thread.currentThread().getName() + " finished.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for(int i=1;i<=5;i++){
            new Thread(runner,"Runner - "+ i).start();
        }

        startLatch.countDown();
    }



}
