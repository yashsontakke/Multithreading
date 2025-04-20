package LLD.designpatterns.templatedesignpattern;

// Step 1: Abstract class defining the template method
//The base class doesn’t change, but new behaviors can be added via subclasses.(Open-Closed Principle)
abstract class OrderProcessTemplate {

    // Template method defining the workflow (final so it can't be changed)
    public final void processOrder() {
        System.out.println(this.getClass());
        selectItem();
        makePayment();
        deliver();
    }

    // Common step for all orders
    private void selectItem() {
        System.out.println("Item selected.");
    }

    // Step that varies for different payment types
    protected abstract void makePayment();

    // Common step for all orders
    private void deliver() {
        System.out.println("Order delivered.");
    }
}

// Step 2: Concrete classes providing specific payment implementations
class CreditCardOrder extends OrderProcessTemplate {
    @Override
    protected void makePayment() {
        System.out.println("Payment made using Credit Card.");
    }
}

class PayPalOrder extends OrderProcessTemplate {
    @Override
    protected void makePayment() {
        System.out.println("Payment made using PayPal.");
    }
}

// Step 3: Client code
public class TemplateDesignPatternExample {
    public static void main(String[] args) {
        OrderProcessTemplate order1 = new CreditCardOrder();
        System.out.println("Processing Credit Card Order:");
        order1.processOrder();

        System.out.println("\nProcessing PayPal Order:");
        OrderProcessTemplate order2 = new PayPalOrder();
        order2.processOrder();
    }
}
