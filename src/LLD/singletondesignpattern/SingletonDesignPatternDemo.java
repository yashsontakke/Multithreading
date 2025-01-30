package LLD.singletondesignpattern;
class Yash{

    static Yash yashinstance ;

    private Yash (){

    } ;

//    public static synchronized  Yash getInstance(){      // locking for each and every method call
//        if(yashinstance==null){
//            yashinstance = new Yash();
//            return yashinstance;
//        }
//        return yashinstance;
//    }

    public static Yash getInstance(){

        if(yashinstance==null){
            synchronized(new Object()){    // locking occurs only once unitll object gets created
                if(yashinstance==null){
                    yashinstance = new Yash();
                    return yashinstance;
                }

            }

        }
        return yashinstance;
    }

}

public class SingletonDesignPatternDemo {

    public static void main(String[] args) {
        Yash yash = Yash.getInstance();
    }
}
