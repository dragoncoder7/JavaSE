package DesignModeDemo.MediatorDemo;

public class UserB extends User{

    @Override
    public void sendMessage(String msg) {
        System.out.println("B发送: " + msg);
        chatRoom.notify(msg,this);
    }

    @Override
    public void getMessage(String msg) {
        System.out.println("B收到: " +msg);
    }

    public UserB(AbstractChatRoom chatRoom) {
        super(chatRoom);

    }
}
