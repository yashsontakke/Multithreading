package LLD;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(132,14,24,24,453,5,35,35,3,53,5);

//        Comparator<Integer> shubya = new ShubyaSort();

//        list.sort(shubya);

//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1,o2);
//            }
//
//        });

        Collections.sort(list, Comparator.comparingInt(a -> a));


        System.out.println(list);

    }

}




