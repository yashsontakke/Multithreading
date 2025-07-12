package LLD.designpatterns;

public abstract class X {
    String description ;

    public static void main(String[] args) {
        Base b  = new Base("auau");
        System.out.println(b.description);
    }

}

 class Base extends X{

     public Base(String auau) {
         this.description = auau;
     }
 }
