package LLD.designpatterns.bridgedesignpattern;
// Implementor Interface
interface DeliveryPartner {
    void deliver(String address);
}

//Concrete Implementor is the actual code that gets the low-level job done in a specific way.
//There can be different Concrete Implementors to provide different ways of doing the same thing
//(like drawing with different styles or using different technologies).
// Concrete Implementors 1
class FedExDelivery implements DeliveryPartner {

    @Override
    public void deliver(String address) {
        System.out.println("Delivering via FedEx to " + address);
    }
}

// Concrete Implementors 2
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
// Abstraction
abstract class Order{
    PaymentMethod paymentMethod;
    DeliveryPartner deliveryPartner;

    public Order(PaymentMethod paymentMethod , DeliveryPartner deliveryPartner){
        this.paymentMethod = paymentMethod;
        this.deliveryPartner = deliveryPartner;
    }

    public abstract void makeOrder(int amount, String address);
}
// Refined Abstraction 1
//the Refined Abstraction takes the general concept from the Abstraction and makes it more specific.
//It defines what kind of thing we are dealing with (like a circle or a rectangle)
//and then uses the Implementor to handle the how (how it gets drawn).

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
// Refined Abstraction 2
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

        //run-time dynamic binding of the implementation.
        //"At runtime we decide which implementation will get used by the bridge abstraction."
        Order order1 = new OnlineOrder(new CreditCardPayment(), new FedExDelivery());
        order1.makeOrder(1232,"hyderabad");


        Order order2 = new StoreOrder(new UpiPayment(), new UPSDelivery());
        order2.makeOrder(2312,"banglore");
    }
}

//    When comparing Adapter vs Bridge, you can remember:
//
//        Adapter = "make it fit"
//        Bridge = "design it to scale separately"