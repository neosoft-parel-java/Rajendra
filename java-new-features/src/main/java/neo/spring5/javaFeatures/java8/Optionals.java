package neo.spring5.javaFeatures.java8;

import java.util.Optional;

/*
 Optional is a way of replacing a nullable T reference with a non-null value.
  An Optional may either contain a non-null T reference (in which case we say the reference
   is “present”), or it may contain nothing (in which case we say the reference is “absent”).
   Note: It is never said that optional “contain null”.
 */
public class Optionals {

    public static void main(String[] args) {
        Optional<Integer> canBeEmpty1 = Optional.of(5);
        canBeEmpty1.isPresent(); // returns true
        canBeEmpty1.get();       // returns 5

        Optional<Integer> canBeEmpty2 = Optional.empty();
        canBeEmpty2.isPresent(); // returns false

        /*
        Three ways to create an Optional
        i) use Optional.empty() to create an empty optional.
         */
        Optional<Integer> possible = Optional.empty();

        /*
         ii) Use Optional.of() to create optional with default non-null value.
             If you pass null in of(), then a NullPointerException is thrown immediately.
         */
        Optional<Integer> possible1 = Optional.of(5);

        /*
         iii) Use Optional.ofNullable() to create an Optional object that may hold a null value.
              If parameter is null, the resulting Optional object would be empty
              (remember that value is absent; don’t read it null).
         */
        Optional<Integer> possible2 = Optional.ofNullable(null);
        // or
        Optional<Integer> possible3 = Optional.ofNullable(5);
    }
}
