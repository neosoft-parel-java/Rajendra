package neo.spring5.javaFeatures.java8;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64Demo {

    /*
     Base 64 encoding convert your binary data into 64 printable ASCII characters.
     Generally it is done for binary data in email messages and "basic" HTTP authentication.
     These 64 printable characters are:
     -> 26 uppercase letters [A…Z]
     -> 26 lowercase letters [a…z]
     -> 10 digits [0…9]
     -> 2 symbols [Read more]
     The encoded string with above characters is safe to be transferred over network supporting text data without,
      fear of losing data in confusion of control characters.
     */

    public static void main(String[] args) throws IOException {

        //1. Encoding a string to base 64
        Base64.Encoder encoder = Base64.getEncoder();
        String normalString = "username:password";
        String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedString);

        //2) Decoding a base 64 encoded string
        // Just get the instance of Base64.Decoder and use it to decode the base 64 encoded string.
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(encodedString);
        System.out.println(new String(decodedByteArray));

        //3. Wrap to a base 64 encoded output stream
        //If you don’t want to directly work with data and rather prefer to work with streams,
        // you can wrap the output stream such that all data written to this output stream,
        // will be automatically base 64 encoded.
        Path sourcePath = Paths.get(".", "writefile.txt");
        Path targetPath = Paths.get(".", "encoded.txt");
        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
        try(OutputStream output = Files.newOutputStream(targetPath)){
            //Copy the encoded file content to target file
            Files.copy(sourcePath, mimeEncoder.wrap(output));
            //Or simply use the encoded output stream
            OutputStream encodedStream = mimeEncoder.wrap(output);
        }
    }
}
