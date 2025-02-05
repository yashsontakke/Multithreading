package COREJAVA.exception;

import java.util.*;

public class ConcurrentExceptionDemo {

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(1,23,55,3,2); This does not allow modification
        // to modify list use
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 23, 55, 3, 2));

//        Iterator iterator = list.listIterator();

//        while (iterator.hasNext()){
//            Integer val = (Integer) iterator.next();
            // Modifying the list while iterating
            // This will throw ConcurrentModificationException
//            if(val==23){
//                list.remove(23);
//            }
//            System.out.println(val);
//        }


        // using ListIterator
        ListIterator<Integer> iterator2 = list.listIterator();

        while (iterator2.hasNext()){
            Integer val = iterator2.next();  // no need to casting

            if(val==23){
                iterator2.remove();  // does not throw concurrent  COREJAVA.exception
            }
            System.out.println(val);
        }

        System.out.println(list);  //
    }
}
