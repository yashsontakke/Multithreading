package multithreading.basicMultithreading;

public class UserDaemonThreadDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int count =0;
            while(count<10){
                try {
                    Thread.sleep(1000);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Daemon thread running " + count );
            }
        });

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("User Thread Finished Executing as no there is no user thread" +
                    " t1 as a daemon thread will stop its execution ");
        });
        t1.setDaemon(true);
        t1.start();
        t2.start();
    }
}
