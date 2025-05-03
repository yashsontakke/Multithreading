package stream.GroupingBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        Map<K, Set<V>> map = stream.collect(
//                Collectors.groupingBy(
//                        classifier,                  // how to group
//                        TreeMap::new,                // which Map to use (default hashmap)
//                        Collectors.toSet()           // how to collect values  (default is list )
//                )
//        );

        List<String> items = List.of("apple", "avocado", "banana", "blueberry");

        Map<Character, List<String>> grouped = items.stream()
                .collect(Collectors.groupingBy(
                        s -> s.charAt(0),
                        ()->new HashMap<>(),
                        Collectors.toList()
                ));




    }
}
