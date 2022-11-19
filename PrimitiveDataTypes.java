// Create all of the primitives (except long and double) with different values.
// Concatenate them into a string and print it to the screen

public class PrimitiveDataTypes {
    public static void main(String []args){
        boolean boolean_value = false;  // 1 bit

        byte byte_num = 100; // 8 bits (1 byte),
                            // default value is zero
                            // a byte is four times smaller than an integer.

        // short is used more for lower-level programming, such as image processing
        // or working with sound processing.
        short short_num = 30000; // 16 bits (2 bytes),
                                // default value is zero
                               // a short is two times smaller than an integer.

        char char_value = 'Y'; // 16 bits (2 bytes)

        int int_num = 5; // 32 bits, default value is zero,
        float float_num = 32.567f; // 32 bits, default value is 0.0

        // long takes 64 bits, default value is zero, Example: long a = 100000L, long b = -200000L
        // double takes 64 bits, double d1 = 123.4

        String a = new String("Wow");
        String b = new String("Wow");
        String sameA = a;

        boolean r1 = a == b;      // This is false, since a and b are not the same object
        boolean r2 = a.equals(b); // This is true, since a and b are logically equals
        boolean r3 = a == sameA;  // This is true, since a and sameA are really the same object

        System.out.println(byte_num + " " + short_num + " " + char_value + " " + int_num + " " + float_num);

    }
}
