package neo.spring5.javaFeatures.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionAPIChanges {
    public static void main(String[] args){

        List<String> actors=new ArrayList<>();
        actors.add("Anuj");
        actors.add("Sameer");
        System.out.println("Intial Actors List: "+actors);  //[Anuj, Sameer]

        //Creates an UnModifiable List
        List<String> copyActors=List.copyOf(actors);
        System.out.println("New (UnModifiable) List: "+copyActors);  //[Anuj, Sameer]

        //copyActors.add("Nitin");  //Runtime Exception (UnsupportedOperationException)

        actors.add("Nitin");
        System.out.println("Recent Actors List: "+actors);  //[Anuj, Sameer, Nitin]
        System.out.println("Recent (UnModifiable) List: "+copyActors);  //[Anuj, Sameer]

        //New added API : Collectors.toUnmodifiableList
        List<String> copy = actors.stream().collect(Collectors.toUnmodifiableList());
        //copy.add("Akhil");  //Runtime Exception (UnsupportedOperationException)

    }
}
