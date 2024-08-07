package designpatterns.factory.method;

import java.util.ArrayList;
import java.util.List;

public class FactoryDesignPatternTest {

    public static void main(String[] args) {
        CommunicationFactory communicationFactory = new CommunicationFactory();
        Communication communication;
        List<Employee> empList = createEmployeeList();
        /*for(Employee employee : empList){
            communication = communicationFactory.getProcess(employee.getModeOfContact());
            communication.process(employee);
        }*/

        empList.forEach(employee -> {
            communicationFactory.getProcess(employee.getModeOfContact()).process(employee);
        });
    }

    private static List<Employee> createEmployeeList() {
        List<Employee> empList = new ArrayList<>();

        Employee e1 = new Employee("Ram", "Chennai", 44, "email", "ram@xyz.com", "1234567890");
        Employee e2 = new Employee("Lal", "Trichy", 54, "mobile", "lal@xyz.com", "1325476980");
        empList.add(e1);
        empList.add(e2);
        return empList;
    }
}
