package LLD.designpatterns.chainofresponsibility;

//Handler Interface
//A Handler interface that declares a method to process requests and hold a reference to the next handler.
abstract class Handler {
    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public abstract void handleRequest(int days);
}

// concrete handlers
class TeamLead extends Handler {
    public void handleRequest(int days) {
        if (days <= 2) {
            System.out.println("Team Lead approved " + days + " day(s) leave.");
        } else if (next != null) {
            next.handleRequest(days);
        }
    }
}

//One or more Concrete Handlers that implement this interface and decide whether to handle the request or pass it along.
class Manager extends Handler {
    public void handleRequest(int days) {
        if (days <= 5) {
            System.out.println("Manager approved " + days + " day(s) leave.");
        } else if (next != null) {
            next.handleRequest(days);
        }
    }
}

class Director extends Handler {
    public void handleRequest(int days) {
        System.out.println("Director approved " + days + " day(s) leave.");
    }
}

// client that build the chain preferred over constructor chaining
//The Chain of Responsibility pattern is useful when a request needs to be processed by one of several handlers,
//but the handler isn’t known in advance.
//This pattern allows multiple objects to handle a request without tightly coupling sender and receiver

//Q: How do you prevent circular dependency or infinite loops in CoR?
//A: You ensure the chain is built properly and not cyclic.
//This is why the chain is usually assembled in a separate class (ChainBuilder) instead of handlers doing it themselves —
// it maintains separation of concerns and avoids accidental circular references.

//A Client that assembles the chain and initiates the request.
public class ChainClient {

//    It's a behavioral design pattern where a request is passed along a chain of handlers,
//    and each handler decides either to process the request or pass it along.

    public static void main(String[] args) {
        Handler lead = new TeamLead();
        Handler manager = new Manager();
        Handler director = new Director();

        lead.setNext(manager).setNext(director);

        lead.handleRequest(1); // Team Lead approves
        lead.handleRequest(4); // Manager approves
        lead.handleRequest(10); // Director approves

}
}
