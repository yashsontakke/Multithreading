package multithreading.ExecutorServicee;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedExecutorDemo {
    public static void main(String[] args) {

        ExecutorService service =  Executors.newFixedThreadPool(10);

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
