package multithreading;


// one task
//class Print implements  Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("running"+" "+Thread.currentThread().getName());
//    }
//}


import java.util.concurrent.*;

class Shubya implements Callable{
    int x ;

    Shubya(int x){
        this.x= x;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(4000);
        return x;
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

    }
}
