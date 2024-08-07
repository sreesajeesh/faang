package interfacelist;

public class SMSService implements MessageService{


    @Override
    public String sendMsg(String message) {
        return "SMS message";
    }
}
