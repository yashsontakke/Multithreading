package multithreading.ExecutorServicee;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class SingleThreadExecutorDemo {

    public static void main(String[] args) {

        ExecutorService service =  Executors.newSingleThreadExecutor();

        for(int i=0;i<5;i++){
            service.execute(new Task(i));
        }

    }

}

class Task implements  Runnable{

    private final int index ;

    public Task(int i){
        this.index = i ;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + "Running Task" + this.index);
    }
}
