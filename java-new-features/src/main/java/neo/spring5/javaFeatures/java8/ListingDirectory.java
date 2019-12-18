package neo.spring5.javaFeatures.java8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListingDirectory {

    //Java 8 List All Files In Directory
    public static void main(String[] args) throws IOException {

        //1. List all files and sub-directories using Files.list().
        // Files.list() method to list all file names and sub-directories in current directory.

        Files.list(Paths.get("./src/main/java/neo/spring5/javaFeatures/java8"))
                .forEach(System.out::println);

        //2. List only files inside directory using filter expression.
        //You can use filters to filter out sub-directories and print only file names, if you need it.
        System.out.println("############################################");
        Files.list(Paths.get("./src/main/java"))
                .filter(Files::isRegularFile)
                .forEach(System.out::println);

        //3. List files and sub-directories with Files.newDirectoryStream()
        // Java provides a more flexible way of traversing a directory content using Files.newDirectoryStream().
        // If we’re working with a large directory, then using DirectoryStream actually make code faster.
        System.out.println("############################################");
        Files.newDirectoryStream(Paths.get("."))
                .forEach(System.out::println);

        //4. List only files with Files.newDirectoryStream()
        //To list out only files and excluding all directories from stream, use path filter as second argument.
        System.out.println("############################################");
        Files.newDirectoryStream(Paths.get("."), path -> path.toFile().isFile())
                .forEach(System.out::println);

        //5. List files of certain extention with Files.newDirectoryStream()
        //You can change the path filter expression passed in second argument to get files of certain extension only.
        System.out.println("############################################");
        Files.newDirectoryStream(Paths.get("./src/main/java/neo/spring5/javaFeatures/java8"),
               path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);

        //6. Find all hidden files in directory
        // To find all hidden files, you can use filter expression file -> file.isHidden() in any of above example.

        final File[] files = new File(".").listFiles(file -> file.isHidden());
        //or
        //final​ ​File​​[]​ files = ​new​ ​File​(​"."​).listFiles(​File​::isHidden);

    }
}
