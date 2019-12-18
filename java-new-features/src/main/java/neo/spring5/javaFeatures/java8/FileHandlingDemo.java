package neo.spring5.javaFeatures.java8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandlingDemo {
    public static void main(String[] args) throws IOException {

        //1. Java 8 read file – line by line
        // This program output will print the content of the file in the console line by line.
        Path filePath = Paths.get(".", "java-8-Features.txt");
        try(Stream<String> lines =  Files.lines(filePath)){
            lines.forEach(System.out::println);
        } catch(IOException e){
            e.printStackTrace();
        }

        //2. Java 8 read file – filtering stream of lines
        //we will read the file content as stream of lines as. Then we will filter all lines which have the word "stream" in it
        System.out.println("##########################################################");
        Path filePath1 = Paths.get(".", "java-8-Features.txt");
        try(Stream<String> lines =  Files.lines(filePath1)){
            List<String> filteredLines = lines
                    .filter(s -> s.contains("Stream"))
                    .collect(Collectors.toList());
            filteredLines.forEach(System.out::println);

        } catch(IOException e){
            e.printStackTrace();
        }

        //3. Java 8 write to file using BufferedWriter
        // BufferedWriter is used to write text to a character or byte stream. Before printing the characters,
        // it stores the characters in buffer and print in bunches. Without buffering,
        // each invocation of a print() method would cause characters to be converted into bytes that would then,
        // be written immediately to the file, which can be very inefficient.


        Path path = Paths.get(".", "writefile.txt");

        //Use try-with-resource to get auto-closeable writer instance
        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            writer.write("Overwrite File. !!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. Write to file using Files.write()
        //Using Files.write() method is also pretty much clean code.
        String content = "Changes Overwrite !!";
        Files.write(Paths.get(".", "writefile.txt"), content.getBytes());
    }

}
