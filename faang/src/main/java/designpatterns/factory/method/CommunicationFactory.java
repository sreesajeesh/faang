package designpatterns.factory.method;

public class CommunicationFactory {

    public Communication getProcess(String mode){
        if(mode.equalsIgnoreCase("email")){
            return new EmailCommunication();
        } else if(mode.equalsIgnoreCase("mobile")){
            return new MobileCommunication();
        }
        return null;
    }
}
