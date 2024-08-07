package exclusive.interview.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {


        private int id;
        private String name;
        private int age;
        private String gender;
        private String department;
        private int yearOfJoining;
        private double salary;

        public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.department = department;
            this.yearOfJoining = yearOfJoining;
            this.salary = salary;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        //id, name, age,gender,department, year of joining,salary

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));

        double maxSalary = employeeList.stream()
                .map(Employee::getSalary)
                .max(Double::compareTo)
                .get();

        System.out.println("Max Salary : " + maxSalary);



        /*Double averageSalary = employeeList.stream()
                .map(Employee::getSalary)
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();

        Map<String, String> map1 = employeeList.stream()
                .filter(sal-> sal.getSalary() > averageSalary)
                .collect(Collectors.toMap(Employee::getName, Employee::getDepartment));
*/
        List<Employee> secondSalary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .skip(2)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(secondSalary);

    }


}
