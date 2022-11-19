package Sorting;

//Sort a List of String using Lambda expression

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String firstName, lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old",
                this.getFirstName(), this.getLastName(), this.getAge());
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public  String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class GetArrList {
    List<Person> getPersonArrList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Virat", "Kohli", 32));
        personList.add(new Person("Arun", "Shaurya", 45));
        personList.add(new Person("Saurav", "Mohan", 12));
        personList.add(new Person("Rahul", "Dravid", 28));
        personList.add(new Person("Gokul", "Gopal", 40));
        return personList;
    }
}

public class SortString {

    public static void main(String[] args) {

        List<Person> personListForLastName_Nat = new ArrayList( new GetArrList().getPersonArrList() );

        System.out.println("Before sorting --> ");
        personListForLastName_Nat.stream().forEach( System.out :: println);

        // sort by last name natural ordering
        Comparator<Person> compLastName_Nat = Comparator.comparing(Person :: getLastName );
        personListForLastName_Nat.sort( compLastName_Nat );
        System.out.println("\nAfter sorting last name natural ordering --> ");
        personListForLastName_Nat.stream().forEach( System.out :: println);
// ------------------------------------------------------------------------------------------------------------------
        // sort by last name descending
        List<Person > personListForLastName_Desc = new ArrayList( new GetArrList().getPersonArrList() );
        Comparator<Person> compLastName_Desc =
                Comparator.comparing( Person :: getLastName );
        personListForLastName_Desc.sort( compLastName_Desc.reversed() ); // <-----------
        System.out.println("\nAfter sorting last name descending order --> ");
        personListForLastName_Desc.stream().forEach( System.out :: println);

// ------------------------------------------------------------------------------------------------------------------
        // sort by length of last name in descending order
        // -- option 1: set up the comparator to sort by descending order of length of last name
        // -- option 2: set up the comparator to sort by natural order of length of last name and then
        //              reverse it while sorting

        // option 1
        List<Person> personListForLastNameLength_Desc = new ArrayList( new GetArrList().getPersonArrList() );
        Comparator<Person> compLastNameLength_Desc =
                Comparator.comparing(  Person :: getLastName ,
                                    ( name1, name2) -> Integer.compare( name2.length(), name1.length() ) );
        personListForLastNameLength_Desc.sort( compLastNameLength_Desc );
        System.out.println("\nAfter sorting last name length descending order (Option 1) --> ");
        personListForLastNameLength_Desc.stream().forEach( System.out :: println);

        // option 2
        List<Person> option2 = new ArrayList( new GetArrList().getPersonArrList() );
        Comparator<Person> compOption2 =
                Comparator.comparing( Person :: getLastName,
                                     ( name1, name2 ) -> Integer.compare( name1.length(), name2.length() ));
        option2.sort( compOption2.reversed() ); // <--------
        System.out.println("\nAfter sorting last name length descending order (Option 2) --> ");
        option2.stream().forEach( System.out :: println);
// ------------------------------------------------------------------------------------------------------------------
        // sort by first name natural ordering
        List<Person> personListForFirstName_Nat = new ArrayList( new GetArrList().getPersonArrList() );
        Comparator<Person> compFirstName_Nat = Comparator.comparing( Person :: getFirstName );
        personListForFirstName_Nat.sort( compFirstName_Nat );
        System.out.println("\nAfter sorting first name natural ordering --> ");
        personListForFirstName_Nat.stream().forEach(System.out :: println );
// --------------------------------------------------------------------------------------------------------------
        // sort by age natural ordering
        List<Person> personListForAge_Nat = new ArrayList( new GetArrList().getPersonArrList() );
        Comparator<Person> compAge_Nat = Comparator.comparing( Person :: getAge );
        personListForAge_Nat.sort( compAge_Nat );
        System.out.println("\nAfter sorting age natural ordering --> ");
        personListForAge_Nat.stream().forEach(System.out :: println );

        // sort by age descending order
        List<Person> personListForAge_Desc = new ArrayList( new GetArrList().getPersonArrList() );
        Comparator<Person> compAge_Desc = Comparator.comparing( Person :: getAge );
        personListForAge_Desc.sort( compAge_Desc.reversed() );
        System.out.println("\nAfter sorting age descending order --> ");
        personListForAge_Desc.stream().forEach(System.out :: println );
    }
}
