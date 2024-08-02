package multithreading.CallableAndFuture;

import java.util.concurrent.*;

public class CallableAndFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> result =  service.submit(new Task());

        System.out.println(result.get(6,TimeUnit.MILLISECONDS));
        //main thread will be in blocked state untill future has get value for normal result.get();
        // so wait till 6 sec if i dont get value then let main thread continue
    }

}

class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return 12;
    }
}
