package LLD.interviewquestions.battleShipGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Player {
    int id ;
    String name ;
    HashSet<Integer> hits ;
    boolean isLeft ;
    List<Ship> ships ;

    public Player(int id , String name , boolean isLeft ){
        this.id = id ;
        this.name = name ;
        this.isLeft = isLeft;
        hits = new HashSet<>();
        ships = new ArrayList<>();
    }

}
