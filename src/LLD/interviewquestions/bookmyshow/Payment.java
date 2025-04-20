package LLD.interviewquestions.bookmyshow;

abstract class Payment {
    int paymentId ;

    public void pay() {

    }

}

class CreditCardPayment extends  Payment{
    @Override
    public void pay(){
        System.out.println("going to credit card payment page ");
    }
}

class UpiPayment extends  Payment{
    @Override
    public void pay(){
        System.out.println("going to upi payemnt");
    }
}
