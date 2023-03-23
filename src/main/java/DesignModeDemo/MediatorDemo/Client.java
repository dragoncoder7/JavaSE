package DesignModeDemo.MediatorDemo;

public class Client {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        UserA userA = new UserA(chatRoom);
        UserB userB = new UserB(chatRoom);
        UserC userC = new UserC(chatRoom);
        chatRoom.Register(userA);
        chatRoom.Register(userB);
        chatRoom.Register(userC);
        userA.sendMessage("hello");
        userB.sendMessage("good bye");
        userC.sendMessage("I'm C, hello everyone！");
    }
}
