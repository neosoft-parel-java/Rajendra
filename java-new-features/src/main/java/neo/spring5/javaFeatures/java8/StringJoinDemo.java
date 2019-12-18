package neo.spring5.javaFeatures.java8;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinDemo {
    public static void main(String[] args) {

        //1. Join String Array – Java 8 String.join()
        /* String.join() method has two overloaded forms.
           Join multiple string arguments
           This method takes all strings in var-args format and all strings are passed as argument in the method.
           The return string is received by appending all strings delimited by argument separator. */

        String joinedString = String.join(", ", "How", "To", "Do", "In", "Java");
        //This method can be used to join multiple strings which are not yet in form of collection or array.
        System.out.println(joinedString);

        // Joining list of Strings
        List<String> stringList = Arrays.asList("Welcome", "To", "Java 8", "Features.");
        String joinedString1 = String.join(", ", stringList);
        System.out.println(joinedString1);

        //2. Joining String using formatted
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("How")
                .add("To")
                .add("Do")
                .add("In")
                .add("Java");
        System.out.println(joiner);

        //3. String list of string with Collectors.joining()
        //While using Java 8 lambda, we can use Collectors.joining() to convert list to String.
        List<String> numbers = Arrays.asList("How", "To", "Do", "In", "Java");

        String joinedString2 =   numbers
                .stream()
                .collect(Collectors.joining(", ","[","]"));

        System.out.println(joinedString2);

        //4. Join String Array using StringUtils.join()
        String[] strArray = { "How", "To", "Do", "In", "Java" };

        String joinedString3 = StringUtils.join(strArray);
        System.out.println(joinedString3);
    }
}
