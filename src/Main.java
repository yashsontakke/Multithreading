import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // Inserted values
        map.put("apple", 2);
        map.put("banana", 5);
        map.put("orange", 3);

        for(String key: map.keySet()){
            System.out.println(key+" "+map.get(key));
        }

        List<String> countryNameList = new ArrayList<>(map.keySet());

        for (String s : countryNameList) {
            System.out.println(s);
        }

        for(Map.Entry<String ,Integer> entry: map.entrySet() ){
            System.out.println(entry.getKey() +" "+ entry.getValue());
        }

    }

}
