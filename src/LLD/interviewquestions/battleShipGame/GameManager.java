package LLD.interviewquestions.battleShipGame;

public class GameManager {

    public static void main(String[] args) {

        Player p1 = new Player(101,"A", true);
        Player p2 = new Player(103,"B", false);

        Game game = new Game(20,p1,p2);

        game.initBattleField(game,p1,p2);

        System.out.println("Player A BattleFields: "+ game.leftShips+" \n"+ "Player B BattleFields: "+ game.rightShips);

        game.viewBattleField();

        game.play(p1,p2);


    }

}
