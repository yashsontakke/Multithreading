package multithreading.synchronizedcollections;

import java.util.ArrayList;
import java.util.List;

public class NonSynchronizedCollDemo {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        Thread t1 = new Thread(()->{
            for(int i=0;i<100;i++){
                list.add(i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<100;i++){
                list.add(i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list.size());  // 194 to

    }

}


