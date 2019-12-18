package neo.spring5.javaFeatures.java8;

/*
    Lambda expression (or function) is just an anonymous function,
    i.e., a function with no name and without being bounded to an identifier.
 */


import java.util.ArrayList;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(25);
        integers.add(35);
        integers.add(45);

        integers.forEach((i) -> {
            System.out.println(i);
            // some action to be performed.
        } );

    }
}
