public class Person {
    String name;
    int age;

    public Person( String name, int age ) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s Age: %d", this.getName(), this.getAge() );
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void sayHello() {
        System.out.printf( "%s says hello!\n", this.getName() );
    }
}
