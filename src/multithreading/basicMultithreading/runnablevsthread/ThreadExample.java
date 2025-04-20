package multithreading.basicMultithreading.runnablevsthread;


//Can we share a variable between threads if we extend Thread?
//Answer: No, because each thread has a separate instance.
// However, we can still share resources by passing a shared object to multiple Thread instances.
// check shared object example
class MyThread extends Thread {
    private int counter = 0; // Each thread gets its own counter

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " Counter: " + counter);
        }
    }
}

public  class ThreadExample {
    public static void main(String[] args) {
        // without runnable
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }

}
