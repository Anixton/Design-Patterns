/**
 * Hakan Gezginci
 * 
 * This application demonstrates the Chain of Responsibility design pattern 
 * in the context of a customer support system.
 * 
 * The Chain of Responsibility pattern allows a request to be passed along a chain of handlers. 
 * Each handler decides whether to process the request or pass it along the chain.
 * 
 * Components:
 * - SupportHandler: An interface defining the contract for handling support requests and 
 *   setting the next handler in the chain.
 * 
 * - CEO, Manager, Operator: Handlers that represent different levels of support. 
 *   They implement the SupportHandler interface.
 * 
 * - CustomerIssue: Represents a support request, containing a description and a complexity level.
 * 
 * - Customer: Represents a customer, containing a name, an email, and a support request.
 * 
 * - CustomerSupport: The base class for support service handlers, managing the chain of responsibility.
 * 
 * - CustomerSupportGUI: The graphical user interface allowing users to enter a support request and 
 *   see how it's handled by the chain of handlers.
 * 
 * - CustomerSupportSystem: The entry point of the application, initializing and 
 *   starting the customer support system.
 * 
 * Upon receiving a request, each handler (CEO, Manager, Operator) decides either to process the 
 * request or to pass it along the chain, based on the complexity of the issue.
 */


public class CustomerSupportSystem {
    public static void main(String[] args) {
        new CustomerSupportGUI();
    }
}