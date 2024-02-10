// Mediator

import java.util.ArrayList;
import java.util.List;


public class ChatRoom {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void showMessage(User user, String message){
        for (User userOtherThanSender : users) {
            if (userOtherThanSender != user) {
                userOtherThanSender.receiveMessage(user.getName() + ": " + message);
            }
        }
    }

    public void showMessageToSpecificUser(User sender, String message, User reciever){
        for (User targetUser : users) {
            if (targetUser.equals(reciever)) {
                targetUser.receiveMessage(sender.getName() + ": " + message);
            }
        }
    }
}