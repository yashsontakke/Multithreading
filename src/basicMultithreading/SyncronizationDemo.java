package basicMultithreading;

public class SyncronizationDemo {

    public static int  counter =0;
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(()->{
//            for(int i=0;i<10000;i++){
//                counter++;
//            }
//        });
//
//        Thread t2 = new Thread(()->{
//            for(int i=0;i<10000;i++){
//                counter++;
//            }
//        });     17725    // load increment set

        Thread t1 = new Thread(()->{
            for(int i=0;i<10000;i++){
               increment();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<10000;i++){
                increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter);
    }

    public synchronized static int increment(){
       return  counter++;
    }


    public synchronized static int a(){
        return  10;
    }
    // problem with syncronized block
    // synchronized acquire class level lock and if there is another method
    // i.e a when thread 1 is accessing increment method it acquires lock(only one class level lock )
    // so any other method cannot access (a) method unless thread 1 release lock acquired on increment method

    // another problem with synchronized is it aquires lock on whole method instead acquiring lock on critical section


    private  static final Object  lock1 = new Object();
    private  static final Object  lock2 = new Object();

    public  static void  x(){
        synchronized(lock1){   // to run this code you need to have lock1  // block level lock

        }
        // this section can be access by another thread
    }

    public  static void  y(){
        synchronized(lock2){   // to run this code you need to have lock2
            counter++;
        }

    }


}
