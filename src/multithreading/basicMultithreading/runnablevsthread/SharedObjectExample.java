package multithreading.basicMultithreading.runnablevsthread;

class SharedResource {
    int counter = 0;

    public synchronized void increment() { // Synchronization to avoid race conditions
        counter++;
        System.out.println(Thread.currentThread().getName() + " Counter: " + counter);
    }
}

//By passing a shared object to multiple Thread instances, they can operate on the same resource.
class MyThreadd extends Thread {
    private SharedResource resource; // Shared object

    public MyThreadd(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.increment(); // All threads share this method
        }
    }
}

public class SharedObjectExample {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource(); // Shared object

        MyThreadd t1 = new MyThreadd(resource); // Pass shared object
        MyThreadd t2 = new MyThreadd(resource);

        t1.start();
        t2.start();
    }
}
