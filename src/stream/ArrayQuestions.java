package stream;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ArrayQuestions {
    public static void main(String[] args) {
        int arr [] = new int []{12,43,12,35,2342,4543,234,1234,44};


          // ******** QUESTION :find second highest element in array ***********


//        arr is of type int[], Arrays.stream(arr) returns an IntStream (not Stream<Integer>)— a stream of primitive ints
//        IntStream, DoubleStream, and LongStream are primitive streams in Java — optimized for performance.
//        But they don't support object-specific operations like Comparator.

//        Rule of Thumb:
//        Whenever you need to:
//        Use custom comparators (Comparator.reverseOrder(), etc.)
//        Perform object-based operations (like .collect(Collectors.toList()))
//        Work with boxing/unboxing, or
//        Use methods that exist only for object streams


        // .mapToObj(a -> a)      // manually boxes each int to Integer
        // .boxed()               // convenience method that does the same thing

        Arrays.stream(arr).mapToObj(a->a).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> sortedArray =  Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());

        System.out.println(sortedArray.get(1));

        // OR

       Integer secondHighest =  Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        // ******** QUESTION :find the second-longest string from a given array ***********

          // All these are same sorting based on alphabetical order
//        strArr.stream().sorted()
//        strArr.stream().sorted(Comparator.naturalOrder())
//        strArr.stream().sorted(Comparator.comparing(a -> a))
//        strArr.stream().sorted(Comparator.comparing(Function.identity()))

        String []strArr = new String[]{"wqw","werwer","sdff","t"};

        // Comparator.comparingInt(k -> k.length()) does same as sort((a, b) -> Integer.compare(a.length(), b.length())), but cleaner.
        // Comparator.comparingInt(s -> s.length()) instead of method reference
        String str =  Arrays.stream(strArr).sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst().get();

        // if it has to found the {{{{largest}}}} can use {{{{{{{reduce}}}}}}}}
        Optional<String> str1 = Arrays.stream(strArr).reduce((s1,s2)->s1.length()>s2.length()?s1:s2);

        // or use {{{{{{{{max}}}}}}}}
        String longest = Arrays.stream(strArr)
                .max(Comparator.comparingInt(String::length))
                .orElse("No strings found");


        System.out.println(str1);
    }
}
