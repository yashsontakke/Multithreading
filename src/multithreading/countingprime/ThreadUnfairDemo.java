package multithreading.countingprime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadUnfairDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int n = 100000;
        int numberOfThreads = 10;

        List<Future<Integer>> futures = new ArrayList<>();

        int rangeSize = n / numberOfThreads;

        // Create and submit tasks for each subrange
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * rangeSize + 1;
            int end = (i == numberOfThreads - 1) ? n : (i + 1) * rangeSize;
            Future result = executorService.submit(new Task(start, end));
            futures.add(result);
        }

        // Collect results from all tasks
        int totalPrimes = 0;
        for (Future<Integer> future : futures) {
            totalPrimes += future.get();
        }

        System.out.println("Total primes: " + totalPrimes);

        executorService.shutdown();
    }

}
//each thread is talking different time so threads will be idle

//        Thread processing range 20001 to 30000 took 29 ms
//        Thread processing range 60001 to 70000 took 9 ms
//        Thread processing range 30001 to 40000 took 19 ms
//        Thread processing range 50001 to 60000 took 25 ms
//        Thread processing range 10001 to 20000 took 15 ms
//        Thread processing range 80001 to 90000 took 15 ms
//        Thread processing range 70001 to 80000 took 9 ms
//        Thread processing range 1 to 10000 took 13 ms
//        Thread processing range 40001 to 50000 took 23 ms
//        Thread processing range 90001 to 100000 took 16 ms

class Task implements Callable {
    int start =0;
    int end =0;

    public Task ( int start , int end ){
        this.start =start;
        this.end= end;
    }

    @Override
    public Object call() throws Exception {
        long startTime = System.currentTimeMillis(); // Capture start time
        int count =0;
        int n = start ;
        while(n<=end){
            boolean isPrime = true ;
            for(int i=2;i*i<=n ;i++){
                if(n%i==0) {
                    isPrime= false;
                }
            }
            if(isPrime)count++;
            n++;
        }
        long endTime = System.currentTimeMillis(); // Capture end time
        long elapsedTime = endTime - startTime; // Calculate elapsed time

        System.out.println("Thread processing range " + start + " to " + end + " took " + elapsedTime + " ms");

        return count ;
    }
}
