package COREJAVA;

final class Student{   // CLAS SHOULD BE FINAL AVOIDING SUBCLASSING
     private final int id ;   // name is final so it cannot be reassigned after the constructor is executed.
     private final String name ;  //  name is private so it is not accessible outside the class directly.

      Student(int id ,String name , Address address){
         this.id = id ;
         this.name = name;
          // Create a copy of the Address object to protect immutability
          this.address = new Address(address.getPincode());
     }
     private  Address address ;  // presence of mutable class

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Address getAddress() {
        return address;  // THIS WE ADDRESS CAN BE MODIFIED SO AVOID THIS
    }

    public Address getAddress2(){
        return new Address(address.getPincode());   //THIS IS WAY WE ARE CREATING ANOTHER COPY REFERENCE AND PASSING
    }

    public Address getAddress3(){    // COPY CONSTRUCTOR
        return new Address(address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address.getPincode() +
                '}';
    }
// No setter method exists, further ensuring the value cannot be modified
}

class Address {
    int pincode ;

    public Address(int pincode) {
        this.pincode=pincode;
    }

    public Address(Address address) {
         this(address.getPincode());
    }

    public  int getPincode(){
        return  pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}

// ONCE OBJECT IS CONSTRUCTED ITS STAGE CAN NOT BE CHANGED
public class ImmutableClassDemo {

    public static void main(String[] args) {
        Address address = new Address(123);
        Student student = new Student(213,"yash",address);

        System.out.println(student);

        Address address1 = student.getAddress2();   // assuming we dont have address refernce before hand
        address1.setPincode(6575);
        address.setPincode(34534);   // you will get an idea if you see student constructor

        System.out.println(student);

    }
}
