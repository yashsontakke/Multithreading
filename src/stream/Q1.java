package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Q1 {
    public static void main(String[] args) {

        String st = "iuwbefdiwbcsdnjcdsjncbdsjcdnjc";

        int arr [] = new int []{234,23423,4234,24234,23};
//        st.chars()

        Stream<String> streamOfStrings =  Stream.generate(()->{
            String s = "helo ";
            System.out.println("x");
            return s;
        });

        streamOfStrings.limit(5).forEach((elem)->System.out.println(elem));



    }
}
