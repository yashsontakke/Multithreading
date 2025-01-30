package LLD.bridgedesignpattern;

interface DeliveryPartner {
    void deliver(String address);
}

class FedExDelivery implements DeliveryPartner {
    @Override
    public void deliver(String address) {
        System.out.println("Delivering via FedEx to " + address);
    }
}

class UPSDelivery implements DeliveryPartner {
    @Override
    public void deliver(String address) {
        System.out.println("Delivering via UPS to " + address);
    }
}


interface  PaymentMethod{
    public void makePayment();
}

class CreditCardPayment implements  PaymentMethod{

    @Override
    public void makePayment() {
        System.out.println("Made payment using credit card ");
    }
}

class UpiPayment implements  PaymentMethod{

    @Override
    public void makePayment() {
        System.out.println("Made payment using upi payment");
    }
}

abstract class Order{
    PaymentMethod paymentMethod;
    DeliveryPartner deliveryPartner;

    public Order(PaymentMethod paymentMethod , DeliveryPartner deliveryPartner){
        this.paymentMethod = paymentMethod;
        this.deliveryPartner = deliveryPartner;
    }

    public void makeOrder(){}

}

class OnlineOrder extends  Order{
     public OnlineOrder(PaymentMethod paymentMethod, DeliveryPartner deliveryPartner){
        super(paymentMethod,deliveryPartner);
    }

    @Override
    public void makeOrder() {
        System.out.println("Online Order");
        paymentMethod.makePayment();
        deliveryPartner.deliver("hyderabad");
    }
}

class StoreOrder extends  Order{
    public StoreOrder(PaymentMethod paymentMethod, DeliveryPartner deliveryPartner){
        super(paymentMethod,deliveryPartner);
    }
    @Override
    public void makeOrder() {
        System.out.println("Store Order");
        paymentMethod.makePayment();
        deliveryPartner.deliver("mumbai");
    }
}


public class BridgeDesignPatternExample {
    public static void main(String[] args) {
        Order order1 = new OnlineOrder(new CreditCardPayment(), new FedExDelivery());
        order1.makeOrder();


        Order order2 = new StoreOrder(new UpiPayment(), new UPSDelivery());
        order2.makeOrder();
    }
}
