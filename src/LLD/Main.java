package LLD;
class A {
    void method() {
        System.out.println("Class A method");
    }
}

class B extends A {

    void method() {
        System.out.println("Class B method");
    }
}

public class Main {
    public static void main(String[] args) {
        A obj = new B();
        obj.method(); // Class B method
    }
}


