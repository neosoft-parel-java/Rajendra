package neo.spring5.javaFeatures.java8;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachMethod {
    public static void main(String[] args){

        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        /*
         Consumer<T> is an Functional interface.
         It has only one method - action(T t)
         */
        Consumer<Integer> listAction = System.out::println;
        /*
        Java program to iterate over all elements of a stream and perform an action.
         In this example, we are printing all even numbers
         */
        numberList.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // forEach method using List.
        numberList.forEach(listAction);

        // forEach example using Map.
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // -> 1) Map entries.
        // .entrySet() - is used to fetch (key, value)
        Consumer<Map.Entry<String, Integer>> mapAction = System.out::println;
        map.entrySet().forEach(mapAction);

        // -> 2) Map keys.
        // .keySet() - is used to fetch keys from map object.
        Consumer<String> mapActionOnKeys = System.out::println;
        map.keySet().forEach(mapActionOnKeys);

        // -> 3) Map values.
        // .values() - is used to fetch values from map object.
        Consumer<Integer> mapActionOnValues = System.out::println;
        map.values().forEach(mapActionOnValues);

        /*
        We can create custom action methods as well to perform our custom logic,
         for each element in the collection.
         */
        Consumer<Map.Entry<String, Integer>> customAction = entry -> {
            System.out.println("Key is: "+ entry.getKey());
            System.out.println("Value is: "+ entry.getValue());
        };
        map.entrySet().forEach(customAction);
    }
}
