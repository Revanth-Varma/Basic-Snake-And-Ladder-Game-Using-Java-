import java.util.*;

public class Board {
    private int BoardSize; // Board Size 1-100
    private int NoOfDice; // Number of dice to be used
    private Queue<Player> player; // Used for the Players Turn while game play
    private HashMap<Integer, Snake> snake; // Jumps to Position from Higher Value to Lower Value
    private HashMap<Integer, Ladder> ladder; // Jumps to Position from Lower Value to Higher Value

    Board(int BoardSize, int NoOfDice) {
        this.BoardSize = BoardSize;
        this.NoOfDice = NoOfDice;
    }

    Board() {
        this(100, 1); // Making Default Value of BoardSize and NoOfDice to (100,1)
    }

    public int getBoardSize() {
        return BoardSize;
    }

    public void setPlayer(Queue<Player> player) {
        this.player = player;
    }

    public void setSnake(HashMap<Integer, Snake> snake) {
        this.snake = snake;
    }

    public void setLadder(HashMap<Integer, Ladder> ladder) {
        this.ladder = ladder;
    }

    public void play() {
        boolean isWon = false;
        Scanner sc = new Scanner(System.in);
        while (true) {
            Player currentPlayer = player.poll();
            System.out.println("\n" + currentPlayer.getPlayerName() + "!, It's your turn....");
            Dice dice = new Dice(NoOfDice);
            while (true) {
                System.out.print("\nEnter '1' to play: ");
                int isRoll = sc.nextInt();
                if (isRoll == 1) {
                    int currentPosition = currentPlayer.getPlayerPosition();
                    int diceValue = dice.rollDice();
                    System.out.println(currentPlayer.getPlayerName() + ", You rolled " + diceValue);
                    int newPosition = currentPosition + diceValue;
                    if (newPosition <= BoardSize) {
                        if (snake.containsKey(newPosition)) {
                            System.out.println("Oops!, You've swallowed by a Snake");
                            newPosition = snake.get(newPosition).getTail();
                        }

                        if (ladder.containsKey(newPosition)) {
                            System.out.println("Wow!, You climbed the Ladder and you get an extra turn...");
                            newPosition = ladder.get(newPosition).getTop();
                            currentPosition = newPosition;
                            currentPlayer.setPlayerPosition(currentPosition);
                            continue;
                        }
                        currentPosition = newPosition;
                        System.out.println(currentPlayer.getPlayerName() + " moved to " + currentPosition);
                        if (currentPosition == BoardSize) {
                            System.out
                                    .println("\nCongrats " + currentPlayer.getPlayerName() + "!, you Won the game....");
                            isWon = true;
                            break;
                        }
                        currentPlayer.setPlayerPosition(currentPosition);
                        if (diceValue != 6) {
                            break;
                        } else {
                            System.out.print("As you rolled 6, you get an extra turn...");
                        }
                    } else {
                        break;
                    }
                }
            }
            if (isWon) {
                break;
            }
            player.offer(currentPlayer);
        }
        sc.close();
    }
}
