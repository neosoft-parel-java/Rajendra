package neo.spring5.javaFeatures.java8.FunctionalInterfaceDemo;

import java.util.ArrayList;
import java.util.List;

public class Animal implements Moveable {

    public static void main(String[] args) {
        Animal tiger = new Animal();
        tiger.move();

        List<Animal> list = new ArrayList<>();
        list.add(new Animal());
        list.add(new Animal());
        list.add(new Animal());

        //Iterator code reduced to one line
        list.forEach((Moveable p) -> p.move());
    }

    /*
       if class willingly wants to customize the behavior then it can provide it’s own custom
       implementation and override the method. Now it’s own custom method will be called.
     */
    public void move(){
        System.out.println("() : I am running...");
    }
}
