import java.util.Scanner;

public class Main {
    static void printTriangles(int num_of_patterns, int size) {

        for (int row = 0; row < size; row++) {
            for (int patternNum = 0; patternNum < num_of_patterns; patternNum++) {

                if (patternNum % 2 == 0)
                    System.out.print("*".repeat(row + 1) + " ".repeat(size - row));
                else
                    System.out.print("*".repeat(size - row) + " ".repeat(row + 1));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );

        System.out.print( "\nEnter the size of the pattern: " );
        int size = scan.nextInt();

        System.out.print( "\nEnter the number of patterns: " );
        int num_of_patterns = scan.nextInt();

        System.out.println();
        printTriangles(num_of_patterns, size);

    }
}