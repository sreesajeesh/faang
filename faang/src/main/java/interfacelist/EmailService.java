package interfacelist;

public class EmailService implements MessageService{
    @Override
    public String sendMsg(String message) {
        return "Email message";
    }
}
