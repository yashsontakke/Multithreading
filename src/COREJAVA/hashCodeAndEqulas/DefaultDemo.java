package COREJAVA.hashCodeAndEqulas;

public class DefaultDemo {
    int a ;

    public DefaultDemo(int a ){
        this.a = a;
    }

    public static void main(String[] args) {
        {
            DefaultDemo a = new DefaultDemo(3);
            DefaultDemo b = new DefaultDemo(3);
            DefaultDemo c = new DefaultDemo(4);

            System.out.println(a.hashCode()); //1175962212
            System.out.println(b.hashCode()); //918221580
            System.out.println(c.hashCode()); // 2055281021

            // the default hashCode implementation typically uses the memory address of the object,
            // which is different for each instance.
            // ****** its value is determined using memory address not actual memory address *******


            System.out.println(a.equals(b));   // false
            System.out.println(c.equals(b));   // false

            //The default equals method checks if two references point to the same memory address
        }

        {
            // but two different objects or memory address can have same hashcode
            String st1 = "FB";
            String st2 = "Ea";

            System.out.println(st1.hashCode());  // 2236
            System.out.println(st2.hashCode());  // 2236


            // clear that equals check memory address not hashcode
            System.out.println(st1.equals(st2));  // false
        }
    }
}

