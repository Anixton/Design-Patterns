//*******************************************************************************************
//*  Hakan Gezginci
//* 
//*  This application showcases the Bridge design pattern, separating the abstraction
//*  of different message types from their concrete implementations and delivery channels.
//*  The main components of the application include message abstractions (PlainTextMessage,
//*  HTMLMessage), concrete implementations of messages, and message senders (EmailSender,
//*  SMSSender, PushNotificationSender).
//*******************************************************************************************

/**
* 
*  Messaging Application
*
*  The Message interface defines the abstraction for different message types, requiring
*  methods for composing and sending messages. HTMLMessage and PlainTextMessage are
*  refined abstractions that implement this interface, allowing for the creation of
*  different types of messages.
*
*  The MessageSender interface serves as the bridge, providing an abstraction for
*  different message delivery channels. Concrete implementations (EmailSender, SMSSender,
*  PushNotificationSender) implement this interface, allowing the client code to send
*  messages through various channels without being tightly coupled to their concrete
*  implementations.
*
*  The main method in MessagingApplication demonstrates the usage of the Bridge pattern.
*  It creates instances of different message senders, associates them with specific
*  message types (PlainTextMessage, HTMLMessage), and showcases the flexibility of the
*  design pattern by composing and sending messages through various channels.
*
*  Components:
*  - Message Abstractions: PlainTextMessage, HTMLMessage
*  - Concrete Message Implementations: EmailSender, SMSSender, PushNotificationSender
*  - Bridge Interface: MessageSender
*  - Client Code: MessagingApplication
*
*  The application provides a foundation for extensibility, allowing the easy addition
*  of new message types or delivery channels without modifying existing code.
*/

public class MessagingApplication {
    public static void main(String[] args) throws Exception {
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SMSSender();
        MessageSender pushNotificationSender = new PushNotificationSender();

        Message plainTextEmailMessage = new PlainTextMessage(emailSender);
        plainTextEmailMessage.composeMessage();
        plainTextEmailMessage.sendMessage();
        System.out.println();

        Message htmlSMSMessage = new HTMLMessage(smsSender);
        htmlSMSMessage.composeMessage();
        htmlSMSMessage.sendMessage();
        System.out.println();

        Message plainTextPushNotificationMessage = new PlainTextMessage(pushNotificationSender);
        plainTextPushNotificationMessage.composeMessage();
        plainTextPushNotificationMessage.sendMessage();
    }
}
