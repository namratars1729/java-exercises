// https://www.baeldung.com/java-initialization


// Arrays are objects in Java
// The direct superclass of an array type is Object.
// In Java, all arrays are dynamically allocated.
// Arrays are stored in contagious memory [consecutive memory locations].
// The size of an array must be specified by int or short value.....not long
// Every array type implements the interfaces Cloneable and java.io.Serializable.
// An array can contain primitives (int, char, etc.) OR object (or non-primitive) references of a class
// In the case of primitive data types, the actual values are stored in contiguous memory locations.
// In the case of class objects, the actual objects are stored in a heap segment.


public class Arrays {

    public static void main(String[] args) {
/*
    int myArray[];    //declaring integer array

     Although the declaration establishes that myArray is an array variable, no actual array exists.
     It merely tells the compiler that this variable (myArray) will hold an array of the integer type.
     To link myArray with an actual, physical array of integers, you must allocate one using 'new' and
     assign it to myArray. Thus, in Java, all arrays are dynamically allocated.


    myArray = new int[20];  // allocating memory to array. Each element is initialized to its default value,
                            //  zero (for numeric types), false (for boolean), or null (for reference types)

     OR

    int[] myArray = new int[20]; // combining both statements in one

    OR

     declare and initialize an array:
 */     int[] myArray = new int[]{3, 5, 2, 5, 14, 4};

        // Since arrays are objects in Java, we can find their length using the object property 'length'.
        System.out.println("Length of myArray = " + myArray.length);

        // print the array elements - (if array of objects, then use (for int i : <name of the array of objects>)
        System.out.println("Elements of myArray = ");
        for(int i=0; i < myArray.length; i++)
            System.out.println(myArray[i]);

        // the first item of an array is associated with the index value 0
        int firstItem = myArray[0];

        // the last item is associated with the index value "array.length - 1"
        int lastIndex = myArray.length - 1;
        int lastItem = myArray[lastIndex];

        System.out.println("first item in myArray = " + firstItem + "\nlast item in myArray = " + lastItem) ;

        // Accessing a random element in the array


    }

}
/*
---------- Array of objects-------------------:
     Student[] studentArray = new Student[5]; // Array of 5 students created but NO students are
                                              // there in the array
     The studentArray contains five memory spaces each containing the memory address where the Student object
     can be found.
     The Student objects have to be instantiated using the constructor of the Student class, and their
     references should be assigned to the array elements in the following way:

// Java program to illustrate creating an array of objects

class Student
{

    public String name;
    Student(String name)
    {
        this.name = name;
    }
      @Override
    public String toString(){
        return name;
    }
}
public static void main (String[] args){
     Student[] myStudents = new Student[]{
          new Student("Dharma"),
          new Student("Sanvi"),
          new Student("Rupa"),
          new Student("Ajay")
    }
    // accessing the elements of the specified array
        for(Student stud : myStudents){
            System.out.println(stud);
        }
}

Other types of arrays -
    Object[]  ao,        // array of Object
    Collection[] ca;  // array of Collection of unknown type
----------------------------------------------------------------------------------------------------
 */