import java.util.HashSet;
import java.util.Set;

public class HashSetPerson {

    public static void main(String[] args) {
        Set<Person> personHS = new HashSet<>();

        // populate the HashSet
        personHS.add( new Person("Pragna", 23 ) );
        personHS.add(new Person("Manisha", 19 ) );
        personHS.add(new Person("Swamy", 83 ) );
        personHS.add(new Person("Jai", 74 ) );

        System.out.println( "HashSet = " + personHS + "\n");

        for( Person p : personHS)
            p.sayHello();

    }
}
