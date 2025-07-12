package JAVA8;

@FunctionalInterface
interface Baccha{

  default void marrige(){
      System.out.println("chud jaoge ");
  };

  void gandu(int val);

}

class Shybhya implements  Baccha{

    @Override
    public void gandu(int val) {
        System.out.println("bola tha shadi nhi krneka "+ val);
    }

    private void inside(){
        System.out.println("called from inside");
    }
}



public class Lamda {

    public static void main(String[] args) {

         Shybhya shybhya = new Shybhya();

         System.out.println(shybhya);

         Baccha y = (int a)->System.out.println("kakakk"+ a);
         y.gandu(4);

    }
}
