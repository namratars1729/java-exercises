public class Employee1 {
    int id, age, yearOfJoining;
    String name, gender, department;
    double salary;

    public Employee1(int id, String name, int age,
                     String gender, String department,
                     int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return this.department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format( "Id : %d | Name : %s | age : %d | Gender : %s \n" +
                               "Department : %s | Year Of Joining : %s | Salary : %.2f",
                               this.getId(), this.getName(), this.getAge(), getGender(),
                               this.getDepartment(), this.getYearOfJoining(), this.getSalary() );
    }
}
