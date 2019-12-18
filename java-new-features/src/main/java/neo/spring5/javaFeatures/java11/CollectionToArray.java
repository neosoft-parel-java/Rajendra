package neo.spring5.javaFeatures.java11;

import java.util.ArrayList;
import java.util.List;

public class CollectionToArray {
    public static void main(String[] args) {

        /* Collection.toArray(IntFunction)
         * Before Java 11, converting a collection to array was not straightforward.
         * Java 11 makes the conversion more convenient.
         */

        List<String> names = new ArrayList<>();
        names.add("Anuj");
        names.add("Nitin");
        names.add("Sameer");

        String[] namesArr1 = names.toArray(new String[names.size()]); //Before Java 11.
        String[] namesArr2 = names.toArray(String[]::new); //Since Java 11.

        for(String s: namesArr1){
            System.out.println("-> "+s);
        }
        for(String s: namesArr2){
            System.out.println("--> "+s);
        }

    }
}
