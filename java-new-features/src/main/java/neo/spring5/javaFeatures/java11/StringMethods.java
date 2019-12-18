package neo.spring5.javaFeatures.java11;

import java.util.ArrayList;
import java.util.List;

//String API Changes.
public class StringMethods {
    public static void main(String[] args) {

        /* 1) String.repeat(Integer)
         * This method simply repeats a string n times.
         * It returns a string whose value is the concatenation of given string repeated N times.
         * If this string is empty or count is zero then the empty string is returned.
         */

        String str = "1".repeat(5);
        System.out.println(str); // 11111

        /* 2) String.isBlank()
         * This method indicates whether a string is empty or contains only white-spaces.
         * Previously, we have been using it from Apache’s StringUtils.java.
         */

        System.out.println("1".isBlank()); // false
        System.out.println("".isBlank()); // true
        System.out.println("     ".isBlank()); //true

        /* 3) String.strip()
         * This method takes care of removing leading and trailing white-spaces.
         * We can be even more specific by removing just the leading characters by using String.stripLeading(),
         * or just the trailing characters by using String.stripTrailing().
         */

        String name = "     Rajendra     ";
        System.out.println(name.strip()); //"Rajendra"
        System.out.println(name.stripLeading()); //"Rajendra     "
        System.out.println(name.stripTrailing()); //"     Rajendra"

        /* 4) String.lines()
         * This method helps in processing multi-line texts as a Stream.
         */

        String s = "Hello\nRajendra\nwelcome\nto\nJAVA\n11";
        List<String> lines = new ArrayList<>();
        s.lines().forEach(lines::add);
        lines.forEach(System.out::println);
        /*
         Output:
         Hello
         Rajendra
         welcome
         to
         JAVA
         11
         */

    }
}
