package LLD.designpatterns.strategydesignpattern;

interface PaymentStrategy {
    boolean pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
        return true;
    }
}

class UpiPayment implements PaymentStrategy {
    private String upiId;
    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI: " + upiId);
        return true;
    }
}

 class CashOnDelivery implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Cash on Delivery selected. Amount to be paid: ₹" + amount);
        return true;
    }
}

class PaymentService {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public boolean payAmount(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment method not selected.");
        }
        return paymentStrategy.pay(amount);
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        // UPI
        paymentService.setPaymentStrategy(new UpiPayment("yash@upi"));
        paymentService.payAmount(599.0);

        // Credit Card
        // Add new gateway without touching existing code
        paymentService.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        paymentService.payAmount(799.0);

        // Cash on Delivery
        paymentService.setPaymentStrategy(new CashOnDelivery());
        paymentService.payAmount(299.0);
    }
}
