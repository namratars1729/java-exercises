import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetOperations {
    // a method that creates and returns a new HashSet
    private static Set<String> createSet( String ... cities ){
        return new HashSet<>( Arrays.asList( cities ) );
    }

    public static void main(String[] args) {
        Set<String> setA = createSet( "Bangalore ", "Delhi ", "Hyderabad ", "Austin ");
        Set<String> setB = createSet( "Mysore ", "Dallas ", "Houston ", "Delhi ", "Bangalore " );

        // ------------ 1. union
        Set<String> unionSet = new HashSet<>( setA );
        unionSet.addAll( setB );
        System.out.print("Union = ");
        unionSet.stream().forEach( System.out :: print );

        // union with streams using Stream.concat
        Set<String> unionWithStreams = Stream.concat( setA.stream(), setB.stream() )
                                             .collect(Collectors.toCollection(HashSet :: new ) );
        System.out.print("\nUnion with Stream.concat = ");
        unionSet.stream().forEach( System.out :: print );

        // ------------ 2. intersection
        Set<String> intersectionSet = new HashSet<>(setA);
        intersectionSet.retainAll( setB ) ;
        System.out.print("\n\nIntersection = ");
        intersectionSet.stream().forEach( System.out :: print );

        // intersection with streams using set::contains
        Set<String> intersectionWithStreams = setA.stream()
                                                  .filter( setB :: contains )
                                                  .collect( Collectors.toCollection( HashSet :: new ) );
        System.out.print("\nIntersection with Stream set::contains =  ");
        intersectionSet.stream().forEach( System.out :: print );

        // ------------ 3. difference or relative compliment.
        /*
        Relative compliment means the values from one set that are not in another.
        It is also referred to as the set difference.
        Eg. setA : {1, 2, 3, 4}
            setB : {2, 4, 6, 8}

            relative complement of setB in setA
            i.e A – B = elements which belong only to A and not to B ---> { 1,3 }

            relative complement of setA in setB
            i.e B – A = elements which belong only to B and not to A ---> {6, 8}
         */
        // A - B
        Set<String> setAminusB = new HashSet<>(setA);
        // removeAll elements from setA that are also in setB:
        setAminusB.removeAll(setB);
        System.out.print("\n\nA - B = ");
        setAminusB.stream().forEach( System.out :: print );

        // A - B with streams
        Set<String> aMinusB = setA.stream()
                                  .filter( element -> !setB.contains(element) )
                                  .collect(Collectors.toCollection( HashSet :: new ) );

        System.out.print("\nA - B with Stream filter( element -> !setB.contains(element) ) =  ");
        aMinusB.stream().forEach( System.out :: print );

        // B - A
        Set<String> setBminusA = new HashSet<>(setB);
        // removeAll elements from setB that are also in setA:
        setBminusA.removeAll( setA );
        System.out.print("\n\nB - A = ");
        setBminusA.stream().forEach( System.out :: print );

        // B - A with streams
        Set<String> bMinusA = setB.stream()
                                  .filter( element -> !setA.contains( element ) )
                                  .collect(Collectors.toCollection( HashSet :: new ));

        System.out.print("\nB - A with Stream filter( element -> !setA.contains(element) ) =  ");
        bMinusA.stream().forEach( System.out :: print );

    }
}
