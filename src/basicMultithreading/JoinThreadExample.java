package basicMultithreading;

public class JoinThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i =0;i<5;i++){
                System.out.println("Thread 1 "+ i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0 ;i<30;i++){
                System.out.println("Thread 2 "+ i);
            }
        });



        t1.start();
        t2.start();
        t1.join();  // main thread will untill t1 thread finishes
        System.out.println("i am main thread so i will have higher priority unless and untill i use join and wait fo" +
                "r other thread to finish i will have to wait ");

    }


}
