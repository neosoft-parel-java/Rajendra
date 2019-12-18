package neo.spring5.javaFeatures.java8.FunctionalInterfaceDemo;

@FunctionalInterface
interface MyFunctionalInterface {
    public void standardOperations();
    /*
       Adding more than one abstract method in Functional Interface is not allowed,
       it will throw an error.
     */
    //public void moreOperations();
    /*
        default methods have implementations, so they are not abstract.
        So you can add as many as default methods to your functional interface.
     */
    default void operation1(){
        //Add Operations to perform
        System.out.println("Performing Operations 1");
    }
    default void operation2(){
        //Add Operations to perform
        System.out.println("Performing Operations 2");
    }

    /*
     If an interface declares an abstract method overriding one of the public methods of java.lang.Object,
     that also does not count toward the interface’s abstract method count since any implementation of the interface
     will have an implementation from java.lang.Object
     */

    @Override
    public String toString();

    @Override
    public boolean equals(Object o);
}
