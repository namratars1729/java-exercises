import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Set<Person> personsSet = new HashSet<>();
        personsSet.add( new Person("Peter", 21) );
        personsSet.add(new Person("Paul", 18));
        personsSet.add(new Person("John", 60));
        personsSet.add(new Person("Rama", 10));
        personsSet.add(new Person("Lakshmana", 20));
        personsSet.add(new Person("Bharata", 34));
        personsSet.add(new Person("Parvati", 75));

        System.out.println("personsSet = ");
        personsSet.stream().forEach( System.out :: println ) ;

        // Set does not support duplicate elements
        System.out.println("\n" + personsSet.add( new Person("Peter", 21)));

        // get all above 21 years
        System.out.println("\nPersons above 21 = ");
        Predicate<Person> above21 = p -> p.getAge() >= 21;
        personsSet.stream()
                .filter( above21 )
                .forEach( System.out :: println );

        // Get the average age of all adults (filter-map-reduce(aggregate))
        System.out.print("\nAverage age of adults = ");
        double avgAge = personsSet.stream()
                                .filter( above21 )
                                .mapToInt( Person::getAge )
                                .average()
                                .getAsDouble();
        System.out.println( avgAge );

        // Collect the sum of ages (reduce(aggregate))
        System.out.print("\nThe sum of ages = ");
        int sum = personsSet.stream()
                .mapToInt( Person::getAge )
                .sum();
        System.out.println( sum );

        // Collect the sum of ages using Collectors.summingInt
        System.out.print("\nThe sum of ages using Collectors.summingInt = ");
        int summingAge = personsSet.stream().collect( Collectors.summingInt( Person :: getAge ) );
        System.out.println( sum );

        // Collect the names starting with 'P' (filter-map-reduce(collect))
        Predicate<String> beginsWithP = name -> name.startsWith("P");
        List<String> namesP = personsSet.stream()
                .map( Person::getName )
                .filter( beginsWithP )
                .collect( Collectors.toList() );
        System.out.print("\nThe names starting with P = " + namesP );
    }
}