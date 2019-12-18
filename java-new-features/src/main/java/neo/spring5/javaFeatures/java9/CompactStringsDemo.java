package neo.spring5.javaFeatures.java9;

public class CompactStringsDemo {

    /*
     Prior to Java 9, string data was stored as an array of chars. This required 16 bits for each char.

     public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
        //The value is used for character storage.
        private final char value[];
     }

     */
    /*
     Starting with Java 9, strings are now internally represented using a byte array,
      along with a flag field for encoding references.

      public final class String implements java.io.Serializable, Comparable<String>, CharSequence {

        //The value is used for character storage.
        @Stable
        private final byte[] value;

        private final byte coder;

     */
}
