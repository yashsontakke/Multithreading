package multithreading.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        final int[]  turn = new int[]{1};

        System.out.println("starting");

        Runnable taskA = new Runnable() {
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        while(turn[0]!=1){
                            conditionA.await();

                        }
                        System.out.println("A ");
                        turn[0] = 2;
                        conditionB.signal();
                    } catch (InterruptedException e) {
                       e.printStackTrace();
                    }finally {
                       lock.unlock();
                    }
                }
            }
        };


        Runnable taskB = ()->{
            while (true){
                lock.lock();
                try {
                    while(turn[0]!=2){
                        conditionB.await();
                    }
                    System.out.println("B ");
                    turn[0] = 3;
                    conditionC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        };

        Runnable taskC = ()->{
            while (true){
                lock.lock();
                try {
                    while(turn[0]!=3){
                        conditionC.await();
                    }
                    System.out.println("C ");
                    turn[0] = 1;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        };
        new Thread(taskA).start();
        new Thread(taskB).start();
        new Thread(taskC).start();

        System.out.println("end");
    }
}
