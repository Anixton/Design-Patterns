/*
 * Hakan Gezginci
 * 
 * Mediator Design Pattern
 * 
 * This pattern is used to reduce communication complexity between multiple objects or classes.
 * In this case, the ChatRoom class acts as the mediator between User objects.
 * 
 * User:
 * The User class represents a user in the chat room. Each user has a name and belongs to a chat room.
 * Users can send general messages to the chat room or personal messages to specific users.
 * They can also receive messages from the chat room.
 * 
 * ChatRoom:
 * The ChatRoom class represents a chat room where users can send and receive messages.
 * It maintains a list of users in the chat room.
 * When a user sends a message, the chat room shows the message to all other users or to a specific user, 
 * depending on the type of the message.
 */

public class ChatRoomApp {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User alice = new User("Alice", chatRoom);
        User bob = new User("Bob", chatRoom);
        User charlie = new User("Charlie", chatRoom);

        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);

        alice.sendPersonalMessage("Hi Bob!",bob);
        bob.sendPersonalMessage("Hi Alice!",alice);
        charlie.sendGeneralMessage("Hi I'm Charlie!");
    }
}