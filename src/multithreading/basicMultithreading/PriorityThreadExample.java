package multithreading.basicMultithreading;

public class PriorityThreadExample {
    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());  main
//        System.out.println(Thread.currentThread().getPriority());     5(default )
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);     10
//        System.out.println(Thread.currentThread().getPriority());  10


        System.out.println("main is running ");
        Thread t1 = new Thread(()->{
            System.out.println("t1 thread ");
        });

        Thread t2 = new Thread(()->{
            System.out.println("t2 thread ");
        });

        t2.setPriority(10);
        t1.start();
        t2.start();
        System.out.println("main is running after t1 starts  ");

        // order of printing can vary as it is not guaranteed thread sheduler will work according to priority
    }
}
