import java.util.*;
public class Main {

    public static void main(String[] args) {

        Queue<Integer> q = new ArrayDeque<>();

        // producer threads
        for(int i=0;i<100;i++){
            int finalI = i;
            new Thread(()->{
//                wait();
                q.add(finalI);
            }).start();
        }

        // consumer thread
        for(int i=0;i<100;i++){
            new Thread(()->{
                q.remove();
            }).start();
        }
    }

}
