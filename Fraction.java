/*
We will look at how we define classes to create our own data types.
Lets start by creating a fraction class to extend the set of numeric data types.

The requirements for this new data type are as follows:
- Given an integer numerator and denominator create a new Fraction.
- When a fraction is printed it should be simplified.
- Two fractions can be added or subtracted
- Two fractions can be multiplied or divided
- Two fractions can be compared
- A fraction and an integer can be added together.
- Given a list of Fractions that list should be sortable by the default sorting function.

The instance variables (data members) we will need for our fraction class are the numerator and denominator.
In Java all data members must be declared up front.
 */

public class Fraction {
    /*
    - Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.
    - For example, when working with Collection objects, such as ArrayList, where primitive types cannot be
      used (the list can only store objects), wrapper classes have to be used
    - the auto boxing and unboxing feature converts primitive data type into object and object into primitive
      data type automatically.
     */

    // 1. DEFINE THE INSTANCE VARIABLES
    // ----------------------------------
    private Integer numerator, denominator; // private instance variables i.e available to only the
                                            // objects of this class
    /*
    - Direct access to instance variables is not allowed.
    - If we want to access the numerator or denominator instance variable, it is very common programming practice
      to provide getter and setter methods for instance variables in Java.
   */

    // getter and setter method for numerator
    public Integer getNumerator () {
        return numerator;
    }

    public void setNumerator(Integer new_numerator) {
        this.numerator = new_numerator;  /* ‘this’ is a reference variable that:
                                        - refers to the current object
                                        - or the current class instance variables.
                                        - is used to invoke the current class constructor E.g. this(10, 20)
                                        - to return the current class instance
                                        - as method parameter
                                        - to invoke a current class method
                                        - as an argument in the constructor call */

    }

    // getter and setter method for denominator
    public Integer getDenominator() {
        return denominator;
    }

    public void setDenominator(Integer new_denominator) { // if denominator = 0 print error msg
        if (new_denominator == 0) throw new IllegalArgumentException("Denominator cannot be 0");

        this.denominator = new_denominator;
    }

    // 2. WRITING A CONSTRUCTOR
    // --------------------------
    /* - In Java, constructors have the same name as the class and are declared public.
       - They are declared without a return type.
       - So any method that is named the same as the class and has no return type is a constructor.

       Our constructor will take two parameters: the numerator and the denominator.
     */

    // DEFAULT CONSTRUCTOR - no args passed in
    public Fraction(  )
    {
        this( 0, 1 );
    }

    public Fraction(Integer number){  // to convert an integer number to a Fraction
    // numerator = number;
    // denominator = 1;
        this( number, 1 );
    }

    // constructor for creating a fraction from numerator and denominator
    public Fraction (Integer top, Integer bottom){
        this.numerator = top;
        this.denominator = bottom;  /* Note: If instead of 'top' and 'bottom' our parameters were named the same
                                as the instance variables, then we use 'this' to differentiate between
                                a parameter or local variable and an instance variable.
                                i.e this.numerator = numerator
                                OR
                                use setter methods*/
    }



    // 3. WRITING THE METHODS
    // --------------------------
    /* We have to overload an 'add' method because the requirement is that
      (1) two fractions can be added and (2) a fraction and an integer can be added together.
     */
    public Fraction add(Fraction otherFraction){  // add the otherFraction to "this" Fraction instance
                                                 // use getters to access the instance variables.
        Integer newNumerator = (this.denominator * otherFraction.getNumerator() ) + (this.numerator * otherFraction.getDenominator() );
        Integer newDenominator = this.denominator * otherFraction.getDenominator() ;
        Integer commonFactor = gcd(newNumerator, newDenominator );

        // a new Fraction is returned as the result of the computation.
        return new Fraction(newNumerator/commonFactor, newDenominator/commonFactor );
    }

    public Fraction add(Integer number){    // add an Integer to a Fraction
        /* we will overload both the constructor and the add method.
        We will overload the constructor so that if it only receives a single Integer
        it will convert the Integer into a Fraction.
        We will also overload the add method so that if it receives an Integer as a
        parameter it will first construct a Fraction from that integer and then add the two Fractions together.
         */
        return add(new Fraction(number));
    }

    private static Integer gcd(Integer a, Integer b) { // If the second number (b) is equal to 0, then GCD = a
                                                      // else GCD = gcd( b, a % b)
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }

    /* toString() method
    A friendly string representation for our Fraction objects.
    Without a toString() method present in our Fraction class, the print statement would output a number.
    That number would be the address in memory where the Fraction object's data is stored i.e it simply contains
    the address of WHERE the data is, NOT the data itself.
     */
    public String toString()
    {
        return numerator.toString() + "/" + denominator.toString();
    }


    // main method
    public static void main(String []args){
        // initialize fraction 1
        Fraction f1 = new Fraction (3,4);

        // initialize fraction 2
        Fraction f2 = new Fraction(1, 2);

        System.out.println(f1.add(f2));  // 3/4 + 1/2
        System.out.println(f1.add(5));   // 3/4 + 5
    }
}