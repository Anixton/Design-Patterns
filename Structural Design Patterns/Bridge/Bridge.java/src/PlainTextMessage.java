// Refined Abstraction: PlainTextMessage
public class PlainTextMessage implements Message {
    private MessageSender messageSender;

    public PlainTextMessage(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void composeMessage() {
        System.out.println("Composing plain text message.");
    }

    @Override
    public void sendMessage() {
        messageSender.sendMessage("Plain text message");
    }
}
