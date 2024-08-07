package designpatterns.factory.method;

public class MobileCommunication implements Communication{
    @Override
    public void process(Employee employee) {
        System.out.println(employee.getName() + " communicated via phone : " + employee.getPhoneNumber());
    }
}
