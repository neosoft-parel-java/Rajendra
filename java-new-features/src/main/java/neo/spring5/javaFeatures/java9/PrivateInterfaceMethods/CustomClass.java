package neo.spring5.javaFeatures.java9.PrivateInterfaceMethods;

public class CustomClass implements CustomInterface {

    public static void main(String[] args) {
        CustomInterface customInterfaceInstance = new CustomClass();
        customInterfaceInstance.method1();
        customInterfaceInstance.method2();


    }

    @Override
    public void method1() {
        System.out.println("Abstract Method.");
    }
}
