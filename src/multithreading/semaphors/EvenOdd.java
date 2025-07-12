package multithreading.semaphors;
import java.util.concurrent.Semaphore;

public class EvenOdd {

    public static void main(String[] args) {

        Semaphore even = new Semaphore(1);
        Semaphore odd = new Semaphore(0);

        Thread evenThread = new Thread(()-> {
            for (int i = 0; i <= 10; i+=2) {
                try {
                    even.acquire();
                    System.out.println(i+" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    odd.release();
                }
            }
        });

        Thread oddThread = new Thread(()-> {
            for (int i = 1; i <= 10; i+=2) {
                try {
                    odd.acquire();
                    System.out.println(i+" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    even.release();
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
