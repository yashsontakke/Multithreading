package multithreading.countingprime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFair {

    public boolean isPrime(int n ){
        boolean isPrime = true ;
        for(int i=2;i*i<=n ;i++){
            if(n%i==0) {
                isPrime= false;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        int n = 100;

        AtomicInteger totalPrimes = new AtomicInteger();
        ThreadFair tf = new ThreadFair();
        CountDownLatch latch = new CountDownLatch(n-1);


        long startTime = System.currentTimeMillis();
        // Create and submit tasks for each subrange
        for (int i = 2; i <= n; i++) {

            int finalI = i;
            executorService.submit(()->{
                long taskStartTime = System.currentTimeMillis(); // Task-specific start time
                boolean isPrime =tf.isPrime(finalI);
                if (isPrime) {
                    totalPrimes.incrementAndGet();
                }
                long taskEndTime = System.currentTimeMillis(); // Task-specific end time
                long elapsedTime = taskEndTime - taskStartTime;
                System.out.println("Thread processing number " + finalI + " took " + elapsedTime + " ms");
                latch.countDown();
            });

        }

        latch.await();
        System.out.println("Total primes: " + totalPrimes);
        executorService.shutdown();
        long endTime = System.currentTimeMillis(); // Capture end time
        long elapsedTime = endTime - startTime; // Calculate elapsed time

        System.out.println("Thread processing took " + elapsedTime + " ms");
    }

}
