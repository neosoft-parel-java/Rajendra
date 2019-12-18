package neo.spring5.javaFeatures.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        System.out.println("#-----------Stream---------------#");
        //Stream
        System.out.println("Adding values in List...");
        List< String> li = new ArrayList<>();
        li.add("Rajendra");
        li.add("Shailesh");
        li.add("Snehal");
        li.add("Abhijit");
        li.add("Gaurav");
        System.out.println("Values Added...");

        /*
         Filter accepts a predicate to filter all elements of the stream.
         This operation is intermediate which enables us to call another stream operation,
         on the result.
         */
        long count = li.stream()
                .filter(s->!(s.length() < 7))
                .count();

        System.out.println("Count of Strings !(less) than 7 characters: "+count);

        //Iterating values using Stream
        System.out.println("#--------------------------------#");
        System.out.println("Iterating values using Stream");
        Stream.iterate(1, c -> c+1)
                .filter(no->no%3==0)
                .limit(5)
                .forEach(System.out::println);

        //List Concatenation using Stream
        System.out.println("#--------------------------------#");
        System.out.println("List Concatenation using Stream");
        List<String> lis = Arrays.asList("Pooja","Abhishek","Rohit","Sagar");
        Stream<String> opstream = Stream.concat(li.stream(),lis.stream());
        opstream.forEach(System.out::println);

        //Integer Stream
        System.out.println("#--------------------------------#");
        System.out.println("Integer Stream");
        int i = IntStream
                .range(1, 11)
                //if filter is not used then it will print from 1 to 10.
                .filter(no -> no%2 == 0)
                //skip option
                .skip(2)
                .sum();
        //.sequential()
        //.unordered()
        //.forEach(System.out::print);
        System.out.println(i);

        //Stream.of, sorted and findFirst.
        System.out.println("#--------------------------------#");
        System.out.println("Stream.of, sorted and findFirst.");
        Stream.of("Da","Ba","Aa","Da")
                .sorted()
                .findFirst()
                //.findAny()
                .ifPresent(System.out::println);

        //Stream from Array, sort, filter and print
        System.out.println("Stream from Array, sort, filter and print");
        li.stream()//
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach((x) -> System.out.println(x));

        //Average of squares of an int Array
        System.out.println("#--------------------------------#");
        System.out.println("Average of squares of an int Array");
        Arrays.stream(new int[]{2,4,6,8})
                .map(x-> x*x)
                .average()
                .ifPresent(System.out::println);

        // Stream from List, filter and print
        System.out.println("#--------------------------------#");
        System.out.println("Stream from List, filter and print");
        li
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);

        /*
         Stream.reduce()
         This terminal operation performs a reduction on the elements of the stream,
          with the given function. The result is an Optional holding the reduced value.
         */
        Optional<String> reduced = li.stream()
                .reduce((s1,s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);

        // Reduction - summary
        System.out.println("#--------------------------------#");
        System.out.println("Reduction - summary");
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);

        // Stream Collectors groupingBy() & counting()
        System.out.println("#--------------------------------#");
        System.out.println("Stream Collectors groupingBy() & counting()");
        List< String> names = Arrays.asList("Hello","Welcome","to","Java_8","Hello","Java_8");
        Map< String, Long> hm = (Map< String, Long>) names.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(hm);

        System.out.println("#--------Square------#");
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        integers.stream()
                .map((x) -> x*x)
                .forEach(System.out::println);

        /*
        Convert Stream to List
        Type 1:
         */
        List<Integer> list = new ArrayList<Integer>();
        for(int j = 1; j< 10; j++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        List<Integer> evenNumbersList = stream
                .filter(j -> j%2 == 0)
                .collect(Collectors.toList());
        System.out.print(evenNumbersList);

        /*
        Convert Stream to array
        Type 2:
         */
        List<Integer> list1 = new ArrayList<Integer>();
        for(int a = 1; a< 10; a++){
            list1.add(a);
        }
        Stream<Integer> stream1 = list.stream();
        Integer[] evenNumbersArr = stream1.filter(a -> a%2 == 0).toArray(Integer[]::new);
        System.out.print(evenNumbersArr);


    }
}