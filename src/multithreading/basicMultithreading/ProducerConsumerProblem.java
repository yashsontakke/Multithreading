package multithreading.basicMultithreading;


import java.util.LinkedList;
public class ProducerConsumerProblem {

//    When notify() is called, a waiting thread moves from "Waiting" to "Runnable".
//    However, it does not directly get the lock.
//    The thread is now competing with other threads for the CPU and lock.
//    The JVM thread scheduler decides which thread actually gets the lock and runs.

    public static void main(String[] args) {

    }
}

//❌ Misconception: Threads Need Another notify() to Get the Lock
//🚫 Wrong: "All threads need to be notified again before they can run."
//✅ Correct: "Threads are already in RUNNABLE after notifyAll(), they just need to wait for the lock."


//❓ Does notifyAll() Make All Threads RUNNING?
//❌ No!
//✅ It only moves them to RUNNABLE.
//✅ They still need to compete for the lock before they can run.

//        1️⃣ notifyAll() Wakes Up Only WAITING Threads
//
//        All threads that are currently in WAITING move to RUNNABLE.
//        Threads that are already in RUNNABLE remain unchanged (they do not get notified again).
//        Only one thread at a time gets the lock and enters RUNNING.
//        2️⃣ Competition for Lock (RUNNABLE Threads Compete)
//
//        All RUNNABLE threads now compete for the lock.
//        The thread that wins gets the lock and enters RUNNING state.
//        The rest stay in RUNNABLE, waiting for the lock.
//        3️⃣ When the Lock is Released, Another RUNNABLE Thread Gets It
//
//        The currently running thread finishes its work and releases the lock.
//        One of the remaining RUNNABLE threads gets the lock next.
//        No new notification (notifyAll()) is needed for RUNNABLE threads—they are just waiting for the lock.
//        4️⃣ WAITING Threads Do Not Move Until Another notifyAll() is Called
//
//        If any thread enters WAITING after notifyAll() was already called, it will NOT be notified again until the next notifyAll().

class BlockingQueue{
    LinkedList<Integer> list = new LinkedList<>();
    int counter =0;
    public void produce() throws InterruptedException {
            synchronized (list){

                while(list.size()==5){
                //A scenario where multiple producers are in WAITING state happens when:
                //✅ The buffer is full.
                //✅ All producers call wait() because they cannot add more items.
                //✅ They remain stuck in WAITING until a consumer consumes and calls notifyAll().
                    list.wait();
                    // thread release lock when waiting so other producer thread can also enter synchronized block
                    // multiple threads can wait in waiting queue here by releasing lock
                    // all waiting for notify (to be eligible to acquire lock again )that's why while instead of if
                    //Other threads do NOT immediately go back to WAITING after notifyAll().
                    //They remain in RUNNABLE state, waiting for the lock.
                    //Only after acquiring the lock do they check the while condition.
                    //If the condition is still true (buffer is empty), they call wait() again.
                }
                list.add(counter);
                System.out.println("Added" + counter++);
                list.notifyAll();    // notifies but does not release lock immediately
            }
            // here lock will be released and thread scheduler will give lock to one of the waiting thread (pro or consumer)
            Thread.sleep(500);
    }
    public void consume() throws InterruptedException{
        while (true){
            synchronized (list){
                while (list.isEmpty()){
                    list.wait();
                }
                int elem = list.remove(0);
                System.out.println("removed "+ elem);
                list.notifyAll();
            }
            Thread.sleep(500);
        }
    }

}
