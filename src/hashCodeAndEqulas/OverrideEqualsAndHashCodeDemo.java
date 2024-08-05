package hashCodeAndEqulas;

import java.util.Objects;

public class OverrideEqualsAndHashCodeDemo {
    public static void main(String[] args) {
        Human human = new Human(123,"yash");
        Human human1 = new Human(123,"yash");


        // if equals not overridden this would give false
        System.out.println(human.equals(human1));// true as we have overridden and it will check context for equality instead memeory address


        // if hashcode not overridden then different hashcode values
        System.out.println(human.hashCode());    // 3706371
        System.out.println(human1.hashCode());   // 3706371

        // as hashcode is overridden then hash will be generated based on content not memory address


    }
}

class Human {
    int aadhar ;
    String name ;
    public Human(int aadhar , String name ){
        this.aadhar= aadhar;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return aadhar == human.aadhar && Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aadhar, name);
    }
}
