package multithreading.basicMultithreading;

public class SequentialExectionDemo {
    public static void main(String[] args) {
        demo1();
        demo2();
    }

    public static  void demo1(){
        for(int i=0;i<5;i++){
            System.out.println("from demo 1 " + i);
        }
    }

    public static void demo2(){
        for(int i=0;i<5;i++){
            System.out.println("from demo 2 " + i);
        }
    }

}
