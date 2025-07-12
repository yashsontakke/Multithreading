package LLD.designpatterns.singletondesignpattern;

import java.util.Objects;

class Client{

    public static void main(String[] args) {

        Shubya s1 =Shubya.getShubyaInstance(120);
        System.out.println(s1.escorts);
        Shubya s2 =Shubya.getShubyaInstance(1200);

        System.out.println(s2.escorts);


    }
}

public class Shubya {

    int escorts ;

    private static

    Shubya anothershubya = null ;

    private Shubya(int x) {
      this.escorts = x;
    }

    public static Shubya getShubyaInstance(int x){
        if(anothershubya==null){
            Shubya save= new Shubya(x);
            anothershubya = save;
            return anothershubya;
        }else{
            return  anothershubya;
        }

    }


}
