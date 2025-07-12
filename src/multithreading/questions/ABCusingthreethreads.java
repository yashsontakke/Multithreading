package multithreading.questions;

public class ABCusingthreethreads {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            System.out.println("A");
        });

        Thread t2 = new Thread(()->{
            System.out.println("B");
        });

        Thread t3 = new Thread(()->{
            System.out.println("C");
        });

    }

}
