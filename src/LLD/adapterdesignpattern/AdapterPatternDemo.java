package LLD.adapterdesignpattern;

// target
interface DollarPayment{
    double getPayment();
}

// adaptee
class RupeesPayment {
    double getBill(){
       double bill =Math.random()*10000;
       System.out.println(bill);
       return bill;
    }
}

// adapter
class DollarPaymentAdapter implements  DollarPayment{

    RupeesPayment rupeesPayment ;

    public DollarPaymentAdapter(RupeesPayment rupeesPayment) {
        this.rupeesPayment = rupeesPayment;
    }

    @Override
    public double getPayment() {
        return rupeesPayment.getBill()/100;
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {

        RupeesPayment rupeesPayment = new RupeesPayment();
        // i used to get bill in rs now i want it in dollar
//        System.out.println(rupeesPayment.getBill()+ " Rs");

        DollarPayment dollarPayment = new DollarPaymentAdapter(rupeesPayment);
        System.out.println("$" + dollarPayment.getPayment() );

    }
}
