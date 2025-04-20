package LLD.interviewquestions.snakeandladder;

import java.util.*;

class Board {

    private final int size;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;
    private final Queue<Player> players;
    private final Dice dice;

    public Board(int size, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> playerList) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = new LinkedList<>(playerList);
        this.dice = new Dice();
    }

    public void playGame() {
        while (true) {
            Player currentPlayer = players.poll();
            int diceValue = dice.roll();
            int newPosition = currentPlayer.getPosition() + diceValue;

            if (newPosition > size) {
                players.offer(currentPlayer);  // Skip turn if exceeds board size
                continue;
            }

            if (snakes.containsKey(newPosition)) {
                System.out.println(currentPlayer.getName() + " got bitten by a snake at " + newPosition);
                newPosition = snakes.get(newPosition);
            } else if (ladders.containsKey(newPosition)) {
                System.out.println(currentPlayer.getName() + " climbed a ladder at " + newPosition);
                newPosition = ladders.get(newPosition);
            }

            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + " moved to " + newPosition);

            if (newPosition == size) {
                System.out.println(currentPlayer.getName() + " wins the game!");
                break;
            }

            players.offer(currentPlayer);
        }
    }
}

class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

class Dice {
    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1; // Returns 1 to 6
    }
}

public class SnakeLadderGame {
    public static void main(String[] args) {
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(97, 78);
        snakes.put(95, 56);
        snakes.put(88, 24);
        snakes.put(62, 18);
        snakes.put(36, 6);

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(2, 38);
        ladders.put(7, 14);
        ladders.put(8, 31);
        ladders.put(15, 26);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(78, 98);
        ladders.put(87, 94);

        List<Player> players = Arrays.asList(new Player("Alice"), new Player("Bob"));

        Board board = new Board(100, snakes, ladders, players);
        board.playGame();
    }
}
