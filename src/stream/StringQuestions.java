package stream;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringQuestions {
    public static void main(String[] args) {

        String st = "iuwbefdiwbcsdnjcdsjncbdsjcdnjc";

        int arr [] = new int []{234,13423,4234,24234,23,123213,5235,5423,41,11,435,1};
//      st.chars()

        Stream<String> streamOfStrings =  Stream.generate(()->{
            String s = "helo ";
            System.out.println("x");
            return s;
        });

        streamOfStrings.limit(5).forEach((elem)->System.out.println(elem));
        //streamOfStrings.limit(5).forEach((elem)->System.out.println(elem));   stream has already been operated upon or closed


        //***************** QUESTION :::count the occurrence of each character in a string *************
        //Use map() for int -> int
        //Use mapToObj() for int -> Object (like Character)
        //IntStream.of(65).map(i -> (char) i); // Compile error



//String st1 = new String("shubya");
//String st2 = st0;
//
//        System.out.println(st0.hashCode()+" "+stk.hashCode());
//        System.out.println(st1.equals(st2)+"heheheh");

        {
            // BUILD UP
            String str = "abc";

            st.chars() // returns IntStream of character codes
                    .forEach(ch -> {
                        System.out.println("Char: " + (char) ch + " | ASCII: " + ch);
                    });

//            Char: a | ASCII: 97
//            Char: b | ASCII: 98
//            Char: c | ASCII: 99

//            str.chars() → gets an IntStream of character codes.
//            mapToObj(ch -> (char) ch) → convert int to Character.
//            collect(Collectors.groupingBy(...)) → grouping logic.
//            Function.identity() → means "group by the item itself".
//            Collectors.counting() → tells how to reduce the group
        }

        Map<Character,Long> map = st.chars().mapToObj(ch->(char) ch).collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        );


        System.out.println(map);

        System.out.println("here start ");
        // entrySet() is a Map method
        Set<Map.Entry<Character, Long>> set= st.chars().mapToObj(a->(char)a).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet();
        System.out.println(set);
        System.out.println("here end ");




        //***************** QUESTION :::find all  duplicate character in a string *************

        st.chars().boxed().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        ).entrySet().stream().filter(key->key.getValue()>1).forEach(x->System.out.println(x));

        //***************** QUESTION ::find first not repeating character in a string *************

//        collect(Collectors.groupingBy(
//                (c) -> c,    // instead of Function.identity()
//                () -> new LinkedHashMap<>(),   // instead of LinkedHashMap::new
//                Collectors.counting()
//        ));

      Character firstNotRepeatingCharacter= st.chars().mapToObj(ch->(char) ch).collect(
                Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )
        ).entrySet().stream().filter(key->key.getValue()==1)
                .findFirst().get().getKey();

        System.out.println(firstNotRepeatingCharacter);

        // *******QUESTION : find elements in array who start with 1 ***********

        List<String> list = Arrays.stream(arr).mapToObj(a->a+"").filter(a-> a.charAt(0)=='1').collect(Collectors.toList());
        System.out.println(list);

        // *********** QUESTION ******** join method
        List<String> s = List.of("sdf","dsf","SD");
        String stjoined = st.join( "-", s);
        System.out.println(stjoined);       // sdf-dsf-SD
    }
}
