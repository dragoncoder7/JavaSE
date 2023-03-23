package DesignModeDemo.MediatorDemo;

public class UserA extends User{
    public UserA (AbstractChatRoom chatRoom) {
        super(chatRoom);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("A发送: " +msg);
        chatRoom.notify(msg,this);
    }

    public void getMessage(String msg) {
        System.out.println("A收到: " +msg);
    }
}
