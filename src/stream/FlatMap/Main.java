package stream.FlatMap;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<List<String>> data = List.of(List.of("a", "b"), List.of("c", "d"));

//        [ [1,2], [3,4] ]  ->  [ Stream(1,2), Stream(3,4) ]  (Stream<Stream<Integer>>)

         Stream<Stream<String>> streamOfStream = data.stream().map(list -> list.stream());

//       [ [1,2], [3,4] ]  ->  Stream(1,2,3,4)  (Stream<Integer>)

         Stream<String> stream = data.stream().flatMap((list -> list.stream()));

    }
}
