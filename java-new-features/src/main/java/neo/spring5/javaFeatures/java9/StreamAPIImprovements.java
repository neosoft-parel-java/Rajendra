package neo.spring5.javaFeatures.java9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIImprovements {

    public static void main(String[] args) {

        //takeWhile and dropWhile methods
        List<String> alphabets = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");

        List<String> subset1 = alphabets
                .stream()
//                .takeWhile(s -> !s.equals("d"))           //output : [a, b, c]
                .dropWhile(s -> s.equals("d"))          //output : [a, b, c, d, e, f, g, h, i]
                .collect(Collectors.toList());

        System.out.println(subset1);

        //iterate method

        /*
        * iterate() methods used for creating a stream which starts with a single element (the seed),
        *  and subsequent elements are produced by successively applying the unary operator.
        * The result is an infinite stream. To terminate the stream, a limit or some
        * other short-circuiting function, like findFirst or findAny is used.
        The iterate method in Java 8 has the signature:
            static Stream iterate(final T seed, final UnaryOperator f)
        In Java 9, new overloaded version of iterate takes a Predicate as the second argument:
            static Stream iterate(T seed, Predicate hasNext, UnaryOperator next)
        * */

        List<Integer> numbers = Stream.iterate(1, i -> i+1)
                .limit(10)
                .collect(Collectors.toList());
        //List<Integer> numbers = Stream.iterate(1, i -> i <= 10 ,i -> i+1)
        //                              .collect(Collectors.toList());
        System.out.println(numbers);        //output : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        //ofNullable() method======================================
        /*
         * Until Java 8, you cannot have null value in a stream. It would have caused NullPointerException.
         * In Java 9, the ofNullable method lets you create a single-element stream which
         *  wraps a value if not null, or is an empty stream otherwise.
         * */

        Stream<String> stream = Stream.ofNullable("123");
        System.out.println(stream.count());         //output : 1

        stream = Stream.ofNullable(null);
        System.out.println(stream.count());         //output : 0
    }
}
