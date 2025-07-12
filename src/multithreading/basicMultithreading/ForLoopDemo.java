package multithreading.basicMultithreading;

public class ForLoopDemo {
    public static void main(String[] args) throws InterruptedException {

        ForLoopDemo forLoopDemo = new ForLoopDemo();
        for(int i=0;i<10;i++){
            System.out.println(i);
            int j = i;
            new Thread(()->{
                try {
                    forLoopDemo.doWork("from thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new ForLoopDemo().doWork("from loop");
        }
    }

    public void doWork(String loc) throws InterruptedException {
        System.out.println(loc);
        Thread.sleep(300);
    }
}
