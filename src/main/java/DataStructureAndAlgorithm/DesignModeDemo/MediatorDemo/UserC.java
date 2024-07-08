package DataStructureAndAlgorithm.DesignModeDemo.MediatorDemo;
public class UserC extends User{
    public UserC (AbstractChatRoom chatRoom) {
        super(chatRoom);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("C发送: " +msg);
        chatRoom.notify(msg,this);
    }

    public void getMessage(String msg) {
        System.out.println("C收到: " +msg);
    }
}

