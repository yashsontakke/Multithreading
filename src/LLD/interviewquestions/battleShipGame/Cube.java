package LLD.interviewquestions.battleShipGame;

public class Cube {
    int x ;
    int y ;
    boolean isShipPresent;
    int shipId ;
    Player player;

    Cube(int x, int y , boolean isShipPresent , int shipId , Player player){
        this.x = x;
        this.y = y;
        this.isShipPresent = isShipPresent;
        this.shipId = shipId;
        this.player = player;
    }
}
