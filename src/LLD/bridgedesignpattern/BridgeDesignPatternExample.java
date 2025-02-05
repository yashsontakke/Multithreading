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
    void makePayment(int amount);
}

class CreditCardPayment implements  PaymentMethod{

    @Override
    public void makePayment(int amount) {
        System.out.println("Made payment using credit card " + amount +"transferred");
    }
}

class UpiPayment implements  PaymentMethod{

    @Override
    public void makePayment(int amount) {
        System.out.println("Made payment using upi payment"+ amount +" transferred");
    }
}


//core of the bridge design pattern and defines the crux. Contains a reference to the implementer.
abstract class Order{
    PaymentMethod paymentMethod;
    DeliveryPartner deliveryPartner;

    public Order(PaymentMethod paymentMethod , DeliveryPartner deliveryPartner){
        this.paymentMethod = paymentMethod;
        this.deliveryPartner = deliveryPartner;
    }

    public abstract void makeOrder(int amount, String address);
}

class OnlineOrder extends  Order{
     public OnlineOrder(PaymentMethod paymentMethod, DeliveryPartner deliveryPartner){
        super(paymentMethod,deliveryPartner);
    }

    @Override
    public void makeOrder(int amount , String address ) {

        paymentMethod.makePayment(amount);
        deliveryPartner.deliver(address);
    }
}

class StoreOrder extends  Order{
    public StoreOrder(PaymentMethod paymentMethod, DeliveryPartner deliveryPartner){
        super(paymentMethod,deliveryPartner);
    }
    @Override
    public void makeOrder(int amount , String address) {

        paymentMethod.makePayment(amount);
        deliveryPartner.deliver("mumbai");
    }
}

//The bridge pattern allows the Abstraction and the Implementation to be developed independently (i.e they are decoupled )and
// the client code can access only the Abstraction part without being concerned about the Implementation part.
public class BridgeDesignPatternExample {
    public static void main(String[] args) {

        //run-time binding of the implementation.
        Order order1 = new OnlineOrder(new CreditCardPayment(), new FedExDelivery());
        order1.makeOrder(1232,"hyderabad");


        Order order2 = new StoreOrder(new UpiPayment(), new UPSDelivery());
        order2.makeOrder(2312,"banglore");
    }
}
