package multithreading.questions;

import java.util.HashMap;

public class ThreadSafeKeyValueStore {
    HashMap<Integer,Integer> map = new HashMap<>();

    // problems to solve 

    public void put(int key , int val ){
        map.put(key,val);
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        return map.get(key);
    }


    public static void main(String[] args) {

        ThreadSafeKeyValueStore threadSafeKeyValueStore = new ThreadSafeKeyValueStore();
        new Thread(()->{
            for(int i=0;i<10;i++){
                threadSafeKeyValueStore.put(i,i+20);
            }
        }).start();

        new Thread(()->{
            for(int i=0;i<12;i++){
                System.out.println(threadSafeKeyValueStore.get(i));
            }
        }).start();

    }
}
