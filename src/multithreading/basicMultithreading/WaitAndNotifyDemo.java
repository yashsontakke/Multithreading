package multithreading.basicMultithreading;

public class WaitAndNotifyDemo {


    private  static  final Object lock1  = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                one();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            two();
        });

        t1.start();
        t2.start();
    }

    public static  void one() throws InterruptedException {
        synchronized (lock1){
            System.out.println("before wait in one ");
            lock1.wait();
            System.out.println("after wait in one ");
        }
    }
    public static  void two(){
        synchronized (lock1){
            System.out.println("before notify in two ");
            lock1.notify();  // immediately it will not release lock
            System.out.println("after notify in two ");
        }
        // lock will be released after complete execution of synchronized block
    }
    //    before wait in one
    //    before notify in two
    //    after notify in two
    //    after wait in one


    // if dont notify then the waiting thread will be in block state
}
