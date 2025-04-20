package multithreading.ExecutorServicee;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedExecutorDemo {
    public static void main(String[] args) {

        ExecutorService service =  Executors.newFixedThreadPool(10);
        //We created a fixed thread pool of 10  → meaning at most 10 threads can run concurrently.
        //We submitted 500 tasks (Task objects) for execution.
        //All 500 tasks are submitted, but only 10 can start immediately.
        //The rest wait in an internal queue
        for(int i=0;i<500;i++){
            service.execute(new Task1(i));
        }
    }
}

class Task1 implements  Runnable{

    private final int index ;

    public Task1(int i){
        this.index = i ;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + "Running Task" + this.index);
    }
}
