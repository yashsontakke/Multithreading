package multithreading.basicMultithreading.runnablevsthread;

class SharedCounter implements Runnable {
    private int counter = 0; // Shared variable

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " Counter: " + counter);
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        SharedCounter task = new SharedCounter(); // Shared object

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
    }
}
