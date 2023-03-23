package DesignModeDemo.MediatorDemo;

public abstract class User {
    protected AbstractChatRoom chatRoom;

    public User(AbstractChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
    public abstract void sendMessage(String msg);

    public abstract void getMessage(String msg);

}
