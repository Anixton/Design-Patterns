// Refined Abstraction: HTMLMessage
public class HTMLMessage implements Message {
    private MessageSender messageSender;

    public HTMLMessage(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void composeMessage() {
        System.out.println("Composing HTML message.");
    }

    @Override
    public void sendMessage() {
        messageSender.sendMessage("HTML message");
    }
}