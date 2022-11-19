public class TestGenericsMatrix <Type> {
    public static void main(String[] args) {
        // 2D Integer matrix
        Integer[][] intArr = {
                { 2, 5, -8 },
                { 3, 1, 5 },
                { 4, 8, 2 },
                { 5, 1, 8 }
        };

        Character[][] charArray = {
            {'A','B','S','C','D','E'},
            {'F','G','S','G','S','G'},
            {'A','D','O','H','E','F'},
            {'D','D','I','G','H','H'},
            {'E','H','D','O','G','E'},
            {'X','V','H','O','G','P'}
        };

        String[][] strArray = {
                {"Dog", "Cat", "Elephant", "animals"},
                {"D", "animals", "E", "animals"},
                {"Coffee", "Tea", "animals", "animals"},
                {"animals", "animals", "animals", ""},
        };

        int count = 0;
        int intkey = 8;
        char charKey = 'G';
        String strKey = "animals";

        // ------  creating parameterized objects
        // i.e. declaring and instantiating an Integer GenericsMatrix object
        GenericsMatrix<Integer> gMIntObject = new GenericsMatrix<>();

        // declaring and instantiating a Character GenericsMatrix object
        GenericsMatrix<Character> gMCharObject = new GenericsMatrix<>();

        // declaring and instantiating a String GenericsMatrix object
        GenericsMatrix<String> gStrObject = new GenericsMatrix<>();

        // ------- calling the searchKey()
        count = gMIntObject.searchKey( intArr, 4, 3, intkey );
        System.out.printf( "Found %d occurrences of %d in 2D Integer Matrix%n", count, intkey );

        count = gMCharObject.searchKey( charArray, 6, 6, charKey );
        System.out.printf( "Found %d occurrences of %c in 2D Character Matrix%n", count, charKey );

        count = gStrObject.searchKey( strArray, 4, 4, strKey );
        System.out.printf( "Found %d occurrences of %s in 2D String Matrix%n", count, strKey );


    }
}
