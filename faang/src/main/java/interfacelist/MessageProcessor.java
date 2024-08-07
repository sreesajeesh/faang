package interfacelist;

public class MessageProcessor {

    private MessageService messageService;

    public void getMessage(){
        System.out.println(messageService.sendMsg("Sajeesh"));
    }

}
