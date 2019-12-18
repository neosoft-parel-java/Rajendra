package neo.spring5.javaFeatures.java10;



public class LocalVariableTypeInference_var {
    /*
     * var (local variable type – JEP 286) to declare variables in java.
     * When you are using var to declare the variable, basically, instead of
     * declaring a variable type, it assumes its type from what it is being set to.
     */
     public static void main(String[] args) {
         /*
          * When using var, you must initialize the variable at same place.
          * You cannot put declaration and initialization at different places.
          * If you do not initialize the variable in place, then you will get
          * compilation error – Cannot use 'var' on variable without initializer.
          */
          //var i;  //Invalid Declaration - - Cannot use 'var' on variable without initializer
            var j = 13; //Valid Declaration

          //var is not a reserved java keyword. therefore we can use 'var' as a variable.
            var var = "Rajendra";
            var vin = "Let's go";
         /*
          * Usage NOT allowed as :
            -Method parameters
            -Constructor parameters
            -Method return types
            -Class fields
            -Catch formals (or any other kind of variable declaration)
          */
        }
}