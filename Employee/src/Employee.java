/*
A class called Employee, which models an employee with an ID, name and salary.
The method raiseSalary(percent) increases the salary by the given percentage.
Write the Employee class.
 */

public class Employee {
    private int id, salary;
    private String firstName, lastName;

    // ------- constructor
    public Employee( int id, String firstName, String lastName, int salary ){
        this.id = id;
        setSalary( salary ); // salary per month
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // --------- toString()
    public String toString() {
        return String.format("Employee[ id = %d, name = %s, salary = %d ]",
                                    this.getID(), this.getName(), this.getSalary() );
    }

    // --------- getters
    public int getID(){
        return this.id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getName() {
        return this.firstName + " " + this.lastName;
    }
    public int getSalary() {
        // salary per month
        return this.salary;
    }
    public int getAnnualSalary(){
        return this.salary * 12;
    }

    // ----------- setter
    public void setSalary( int salary ){
        this.salary = salary;
    }

    // ---------- method
    public int raiseSalary ( int percent ){
        int raisedSalary = 0;
        raisedSalary = this.getSalary() + (this.getSalary() * percent/100);
        this.setSalary( raisedSalary );
        return this.getSalary();
    }
}
