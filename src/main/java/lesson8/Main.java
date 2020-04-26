package lesson8;

import lesson8.util.MyHashMap;
import lesson8.util.MyMap;

public class Main {

    public static void main(String[] args) {
        MyMap<String, String> myMap = new MyHashMap<>();
        myMap.put("1", "one");
        System.out.println(myMap.get("1"));
        myMap.put("2", "two");
        myMap.put("3", "three");
        System.out.println(myMap.containsKey("0"));
        myMap.put("0", "nil");
        System.out.println(myMap.containsKey("0"));
        System.out.println(myMap.containsValue("nil"));
        myMap.put("0", "zero");
        myMap.remove("3");
        System.out.println(myMap);
        System.out.println(myMap.size());
    }

}
