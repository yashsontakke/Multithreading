package multithreading.ExecutorServicee;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class CacheThreadExecutorDemo {
    public static void main(String[] args) {

        // created around 16 threads
        ExecutorService service =Executors.newCachedThreadPool();

        for(int i=0;i<50;i++){
            service.execute(new Task(i));
        }
    }
}

//Runnable itself does not create a thread. It is just a task. You need to pass it to a Thread object,
// which actually starts the thread.
class Test2  implements  Runnable{
    private int  index ;

    Test2(int i ){
        this.index=i;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + "Running Task" + this.index);
    }
}
