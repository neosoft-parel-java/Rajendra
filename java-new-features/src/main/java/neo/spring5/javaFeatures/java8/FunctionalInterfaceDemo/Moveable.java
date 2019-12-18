package neo.spring5.javaFeatures.java8.FunctionalInterfaceDemo;

public interface Moveable {

    /*
     Moveable interface defines a method move(); and provided a default implementation as well.
     If any class implements this interface then it need not to implement it’s own version
     of move() method. It can directly call instance.move();
     */
    default void move(){
        System.out.println("() : I am moving...");
    }
}
