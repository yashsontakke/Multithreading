package COREJAVA.polymorphism;

class Parent {
    // Static method in Parent class
    public static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    // Static method in Child class with the same name
    public static void staticMethod() {
        System.out.println("Static method in Child");
    }
}

public class Main {
    public static void main(String[] args) {
        // Calling static methods
        Parent.staticMethod(); // Output: Static method in Parent
        Child.staticMethod();  // Output: Static method in Child

        // Reference of Parent type pointing to Child class
        // For non-static methods, the method to be invoked is determined at runtime based on the actual object type.
    // For static methods, the method to be invoked is determined at compile time based on the reference type.
        Parent parent = new Child();
        parent.staticMethod(); // Output: Static method in Parent
    }
}
