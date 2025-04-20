package LLD.designpatterns.chainofresponsibility;

abstract class SupportHandler {
    protected SupportHandler nextHandler;

    // Constructor chaining
    public SupportHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String issue, int severity);
}
class L1Support extends SupportHandler {
    public L1Support(SupportHandler nextHandler) {
        super(nextHandler);  // Passing next handler to parent constructor
    }

    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= 1) {
            System.out.println("L1 Support handling issue: " + issue);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        }
    }
}

class L2Support extends SupportHandler {
    public L2Support(SupportHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(String issue, int severity) {
        if (severity == 2) {
            System.out.println("L2 Support handling issue: " + issue);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        }
    }
}

class L3Support extends SupportHandler {
    public L3Support(SupportHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(String issue, int severity) {
        if (severity >= 3) {
            System.out.println("L3 Support handling issue: " + issue);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        }
    }
}

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // Chain initialization using constructor chaining
        SupportHandler supportChain = new L1Support(new L2Support(new L3Support(null)));

        // Test with different severity levels
        supportChain.handleRequest("Password Reset", 1);  // Handled by L1
        supportChain.handleRequest("System Crash", 2);    // Handled by L2
        supportChain.handleRequest("Database Down", 3);   // Handled by L3
    }
}
