package COREJAVA.polymorphism;

public abstract class Vehicle{

    int  speedLimit(){
     return 50;
  }


}

 class Car extends  Vehicle{
   @Override
    int speedLimit(){
       return 50+30;
    }
}


 class Bike extends  Vehicle{
 @Override
  int speedLimit(){
   return 50-30;
  }

  int wheels(){
     return 2;
  }

  public static void main(String[] args) {
   Vehicle car = new Car();
   System.out.println(car.speedLimit());

   //Parent Class Reference: You can only access methods defined in the parent class.
   Vehicle bike = new Bike();
   //bike.wheels() this will give error

      Bike bike2 = new Bike();
        bike2.wheels();
  }
}
