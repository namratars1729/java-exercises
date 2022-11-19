
public class Recursion{
    /*
        getSum(int number) is an instance method
        It can be accessed from within main() in 2 ways -
        1) make it a static method i.e public/private static int getSum(int number)
        2) keep the method private/public without it being a static method.
           Then this becomes an instance method....which can only be accessed via an object of the class.
           So in main() create an object of this class.
           Use var to define it. (var detects automatically the datatype of a variable based on
           the surrounding context)
           i.e
           var classInstance = new Recursion();

           Use this instance to access the instance method getSum(int number)
           i.e return number + classInstance.getSum(number-1);
     */
    private int getSum(int number){
        if (number > 0){
            return number + getSum(number-1);
        }
        else {
            return 0;
        }
    }

    /* Note on var:
            - Can be used only to declare local variables.
            - We can declare any datatype with the var keyword.
            - var CANNOT be used in an instance and global variable declaration.
            - var CANNOT be used without explicit initialization as they need explicit type
              E.g. var variable; var variable = null
            - var CANNOT be used with Lambda Expression.
            - var CANNOT be used for method parameters and return type.
    */
    public static void main(String args[]){
        var classInstance = new Recursion();

        int sum = classInstance.getSum(10);
        System.out.println("The sum of the 1st 10 numbers is: " + sum);
    }
}