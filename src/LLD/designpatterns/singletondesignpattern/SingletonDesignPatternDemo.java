package LLD.designpatterns.singletondesignpattern;
class Yash{

    static volatile Yash instance ;  // It prevents the CPU from reordering the object creation steps.
    //volatile: Ensures that once instance is assigned, it’s visible to all threads and not read as a half-initialized object.

    private Yash (){

    } ;

//    public static synchronized  Yash getInstance(){      // locking for each and every method call
//        if(yashinstance==null){
//            yashinstance = new Yash();
//            return yashinstance;
//        }
//        return yashinstance;
//    }
    public static Yash getInstance() {
        if (instance == null) {   // 🚨 Thread 2 sees instance as non-null (but not fully initialized!)
            synchronized (Yash.class) {
                if (instance == null) {
                    instance = new Yash(); // 🚨 Steps might be reordered!
                    //Object construction (new Yash()) isn't atomic. It's actually broken down into three steps:
//                    Allocate memory.
//                    Assign reference to instance (i.e., instance != null now).
//                    Call the constructor.
                }
            }
        }
        return instance;  // 🚨 Another thread may get a half-constructed object!
    }
}

 class Singleton {
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
public class SingletonDesignPatternDemo {

    public static void main(String[] args) {
        Yash yash = Yash.getInstance();
    }
}
