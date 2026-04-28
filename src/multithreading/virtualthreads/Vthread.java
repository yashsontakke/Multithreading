package multithreading.virtualthreads;

class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("running");
    }
}

public class Vthread {

    public static void task(){
        System.out.println("yayay");
    }

    public static void main(String[] args) throws InterruptedException {

        Thread vt = Thread.ofVirtual().unstarted(new Runnable() {
            @Override
            public void run() {
                new Vthread().task();
            }
        });

        vt.start();

        vt.join();
    }
}
