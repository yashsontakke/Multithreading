package LLD.designpatterns.nulldesignpattern;

interface  Animal{
    void speak();
}

class Dog implements Animal{
    @Override
    public void speak() {
        System.out.println("bho bho");
    }
}

class Cat implements Animal{
    @Override
    public void speak() {
        System.out.println("meaw meaw");
    }
}

class NullAnimal implements Animal{

    @Override
    public void speak() {
        System.out.println("animal ran away ");
    }
}

class AnimalFactory{
    public Animal getAnimal(String type){
        if ("Dog".equalsIgnoreCase(type)) {
            return new Dog();
        }

        if ("Cat".equalsIgnoreCase(type)) {
            return new Cat();
        }
        return new NullAnimal();
    }
}

public class NullDesignPatternDemo {

    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal animal1 = animalFactory.getAnimal("dog");
        Animal animal2 = animalFactory.getAnimal("cat");
        Animal animal3 = animalFactory.getAnimal("cow");

        animal1.speak();
        animal2.speak();
        animal3.speak();

    }
}
