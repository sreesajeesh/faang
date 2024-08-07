package designpatterns.factory.method;

public class EmailCommunication implements Communication{
    @Override
    public void process(Employee employee) {
        System.out.println(employee.getName() + " is communicated via email : " + employee.getEmail());
    }
}
