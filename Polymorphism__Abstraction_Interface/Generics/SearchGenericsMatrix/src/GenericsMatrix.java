/*
An example of a generic class that implements a method for finding an element in
a two-dimensional matrix

The generic class GenericMatrix<Type> is declared, which implements
the searchKey() method.

The searchKey() method calculates the number of occurrences of the given
key element in the matrix.
It receives the following parameters:
    - M –--> the initial matrix of the generic type Type[][], in which the key is searched;
    - m, n –--> the dimensions of the matrix, the number of rows and columns, respectively;
    - key –--> a key (element), whose number of occurrences in the matrix M needs
      to be calculated.
 */

public class GenericsMatrix <Type> {
    // constructor which receives the 2D matrix M, the num of rows m
    // and the num of columns n
    public int searchKey( Type[][] M, int m, int n, Type key ){
        int count = 0;

        for ( int rowIndex = 0; rowIndex < m; rowIndex++ )
            for ( int colIndex = 0; colIndex < n; colIndex++)
                try {
                    if (key == M[rowIndex][colIndex])
                        count += 1;
                }
                catch (Exception e) {
                    if ( key.equals( M[rowIndex][colIndex] ) );   // for Strings
                        count += 1;
                }
        return count;
    }
}
