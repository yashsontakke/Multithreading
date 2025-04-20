package LLD.interviewquestions.bookmyshow;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class Main {
    List<Movie> movies ;
    List<Theater> theaters;

    public static void main(String[] args) {

        Random random = new Random();

        Location location = new Location(1,"pune",500002);
        Location location1 = new Location(2,"mumbai",500054);

        Theater theater  = new Theater(1,1);
        Theater theater2 = new Theater(2,2);
        Theater theater3 = new Theater(3,2);
        Theater theater4 = new Theater(4,1);

        Screen screen = new Screen(1,2);
        Screen screen1 = new Screen(2,1);
        Screen screen2 = new Screen(3,1) ;
        Screen screen3 = new Screen(4,2);
        Screen screen4 = new Screen(5,3);
        Screen screen5 = new Screen(6,3);
        Screen screen6 = new Screen(7,3);
        Screen screen7 = new Screen(8,4) ;
        Screen screen8 = new Screen(9,2)  ;
        Screen screen9 = new Screen(10,2);

        Movie movie = new Movie(1,"sultan",120);
        Movie movie1 = new Movie(2,"bb",120);
        Movie movie2 = new Movie(3,"kick",120);
        Movie movie3= new Movie(4,"hahk",120);
        Movie movie4= new Movie(5,"terenaam",120);
        Movie movie5 = new Movie(6,"dil",120);





    }
}
