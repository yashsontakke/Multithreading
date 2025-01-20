package LLD.observerdesignpattern;

public class Main {

    public static void main(String[] args) {

        Observer aman = new Observer("aman");
        Observer kunal = new Observer("kunal");
        Observer priyesh = new Observer("priyesh");

        Subject x = new Subject();

        x.add(aman);
        x.add(kunal);
        x.add(priyesh);

        x.setValue(20);

        x.remove(aman);


        x.setValue(30);
    }
}
