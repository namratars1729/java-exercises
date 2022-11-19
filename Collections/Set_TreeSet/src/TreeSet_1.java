import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Student {
    int id;
    String name;
    int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getMarks(){
        return this.marks;
    }

    @Override
    public String toString() {
        return id +" : "+ name +" : " + marks;
    }
}

// a TreeSet by supplying a customized Comparator
//  create a TreeSet of Student objects ordered in the descending order
//  of the percentage of marks they have obtained.
//  That means, student with highest marks will be placed at the top.

public class TreeSet_1 {
    public static void main(String[] args) {
        Comparator<Student> compMarks = Comparator.comparingInt(Student :: getMarks) ;
        Set<Student> studentSet = new TreeSet<>( compMarks.reversed() );

        studentSet.add(new Student(121, "Santosh", 85));
        studentSet.add(new Student(231, "Cherry", 71));
        studentSet.add(new Student(417, "David", 82));
        studentSet.add(new Student(562, "Praveen", 91));
        studentSet.add(new Student(231, "Raj", 61));         //Duplicate element
        studentSet.add(new Student(458, "John", 76));
        studentSet.add(new Student(874, "Peter", 83));
        studentSet.add(new Student(231, "Hari", 52));       //Duplicate element
        studentSet.add(new Student(568, "Daniel", 89));

        /* ---- Constructor through Stream
        TreeSet<Player> myTreeSet = Stream.of(saajan, eric, kai, kevin)
            .collect(Collectors.toCollection( () -> new TreeSet<>(Comparator.comparingInt(Player::getNumberOfWins) )
        ));
         */
        studentSet.stream().forEach( System.out :: println);
    }
}
