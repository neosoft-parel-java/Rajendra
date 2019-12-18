package neo.spring5.javaFeatures.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReferences {
    public static void main(){


        /*
        Method reference to static method – Class::staticMethodName
        An example to use Math.max() which is static method.
         */
        List<Integer> integers = Arrays.asList(1,12,433,5);
        Optional<Integer> max = integers.stream().reduce( Math::max );
        max.ifPresent(value -> System.out.println(value));
        // Above line can also be written as --> max.ifPresent(System.out::println());

        /*
        Method reference to instance method from instance
        :-> ClassInstance::instanceMethodName
         */
        max.ifPresent( System.out::println );

        /*
        Method reference to instance method from class type
        :-> Class::instanceMethodName
         */
        List<String> strings = Arrays
                .asList("how", "to", "do", "in", "java", "dot", "com");

        List<String> sorted = strings
                .stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());

        System.out.println(sorted);

        List<String> sortedAlt = strings
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println(sortedAlt);

        /*
        Reference to constructor – Class::new
         */
        List<Integer> integers1 = IntStream
                .range(1, 100)
                .boxed()
                /* .boxed() it is used to convert Primitive data types,
                 to their respective wrapper classes. */
                .collect(Collectors.toCollection( ArrayList::new ));

        Optional<Integer> max1 = integers1.stream().reduce(Math::max);

        max1.ifPresent(System.out::println);

    }
}
