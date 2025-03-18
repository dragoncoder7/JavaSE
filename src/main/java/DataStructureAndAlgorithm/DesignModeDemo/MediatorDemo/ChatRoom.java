package DataStructureAndAlgorithm.DesignModeDemo.MediatorDemo;

import java.lang.invoke.TypeDescriptor;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom extends AbstractChatRoom{
    private List<User> users = new ArrayList<>();

    public void Register(User user){
        users.add(user);
    }

    @Override
    public void notify(String message, User user) {
        for (User u: users
             ) {
            if (u != user){
                u.getMessage(message);
            }
        }
    }
}
