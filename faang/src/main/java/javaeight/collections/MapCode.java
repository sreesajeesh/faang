package javaeight.collections;

import java.util.Map;
import java.util.TreeMap;

public class MapCode {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("John",18);
        map.put("Mary", 22);
        map.put("Chris",33);

        /*System.out.println(map.containsKey("John"));
        System.out.println(map.containsValue(18));
        for(String name : map.keySet() ){
            System.out.println(name);
        }
        for(Integer age : map.values()){
            System.out.println(age);
        }*/

        //map.forEach((k,v) -> System.out.println("The age of " + k + " is " + v));

        //map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        map.put("Mike", null);
        map.forEach((k,v) -> System.out.println(k + " " + v));
        System.out.println("======================");
        map.putIfAbsent("John",99);
        map.forEach((k,v) -> System.out.println(k + " " + v));
        System.out.println("======================");
        map.putIfAbsent("Mike", 37);
        map.forEach((k,v) -> System.out.println(k + " " + v));
        /*
        System.out.println("======================");
        map.putIfAbsent("Luke", 36);
        map.forEach((k,v) -> System.out.println(k + " " + v));
        System.out.println("======================");*/

        System.out.println(map.replace("John", 66));
        System.out.println(map);

        map.replaceAll((name, age)-> name.length());
        System.out.println(map);
    }
}
