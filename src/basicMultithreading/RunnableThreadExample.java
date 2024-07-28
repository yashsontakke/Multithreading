package basicMultithreading;

public class RunnableThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("Thread 3 " + i);
                }
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println("Thread 2 " + i);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

class Thread1 implements  Runnable{

    @Override
    public void run() {

            for(int i=0;i<15;i++){
                System.out.println("Thread 1 " + i);
            }

    }
}
