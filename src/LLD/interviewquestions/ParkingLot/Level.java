package LLD.interviewquestions.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;

public class Level {

    int levelId ;
    ArrayList<Slot> slots;

    public Level(int levelId , ArrayList<Slot> slots){
        this.slots = new ArrayList<>();
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
}
