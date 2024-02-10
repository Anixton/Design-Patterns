public class User {
    private String name;
    private ChatRoom chatRoom;

    User(String name, ChatRoom chatRoom){
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName(){
        return this.name;
    }

    public void sendGeneralMessage(String message){
        chatRoom.showMessage(this, message);
    }

    public void sendPersonalMessage(String message, User receiver){
        chatRoom.showMessageToSpecificUser(this, message, receiver);
    }

    public void receiveMessage(String message){
        System.out.println("[" + this.name + "'s chat window] : " + message);
    }
}
