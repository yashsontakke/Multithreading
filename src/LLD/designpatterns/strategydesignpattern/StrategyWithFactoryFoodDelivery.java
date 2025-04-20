package LLD.designpatterns.strategydesignpattern;
import java.util.*;

// ----------- Strategy Interface -----------
interface PaymentStrategy1 {
    boolean pay(double amount);
}

// ----------- Concrete Strategies -----------

 class UpiPayment1 implements PaymentStrategy {
    private String upiId;

    public UpiPayment1(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI: " + upiId);
        return true;
    }
}

class CreditCardPayment1 implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment1(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Credit Card: " + cardNumber);
        return true;
    }
}

class CashOnDelivery1 implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Cash on Delivery selected. Pay ₹" + amount + " at delivery.");
        return true;
    }
}

// ----------- Factory to Create Strategy -----------

class PaymentStrategyFactory {

    // Factory encapsulates object creation logic
    public static PaymentStrategy getStrategy(String type, Map<String, String> details) {
        switch (type.toLowerCase()) {
            case "upi":
                return new UpiPayment(details.get("upiId"));
            case "creditcard":
                return new CreditCardPayment(details.get("cardNumber"));
            case "cod":
                return new CashOnDelivery();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}

// ----------- Payment Service Using Strategy -----------

class PaymentService1 {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public boolean payAmount(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }
        return paymentStrategy.pay(amount);
    }
}

// ----------- Main App Class (Only public class) -----------

public class StrategyWithFactoryFoodDelivery {

    public static void main(String[] args) {
        // Simulating user input or frontend selection
        String paymentType = "upi";
        Map<String, String> details = new HashMap<>();
        details.put("upiId", "yash@upi");

        // Factory creates the appropriate strategy instance
        PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(paymentType, details);

        // We inject the strategy into the service
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentStrategy(strategy);

        // We now use the selected strategy to make the payment
        paymentService.payAmount(750.0);
    }
}

/*
Why Factory + Strategy instead of only Strategy?

👉 With only Strategy:
   - You need to create the correct PaymentStrategy manually each time.
   - All object creation logic gets scattered across code.

👉 With Factory + Strategy:
   - Strategy handles payment behavior.
   - Factory centralizes object creation logic and isolates complexity.
   - Easy to add new payment types (Open/Closed Principle).
   - Clean separation of responsibilities.
   - Great for extensibility and testing.

This combo is ideal when you have dynamic runtime selection of strategies.
*/

