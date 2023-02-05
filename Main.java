import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello User....");
        System.out.println("Do you want to play the Snake and Ladders?(Y/N)");
        String wantsToPlay = sc.next();
        if (wantsToPlay.equalsIgnoreCase("Y")) {
            System.out.println("......................Welcome to Snake and Ladders......................");
            System.out.print("\nEnter the number of Players : ");
            int NoOfPlayers = sc.nextInt();
            sc.nextLine();
            Queue<Player> players = new LinkedList<>();
            for (int i = 1; i <= NoOfPlayers; i++) {
                System.out.print("\nEnter the player " + i + " name : ");
                String playerName = sc.nextLine();
                Player player = new Player(i, playerName);
                players.offer(player);
            }

            System.out.print("\nEnter the Board Size : ");
            int boardSize = sc.nextInt();
            System.out.print("\nEnter the Number of the Die you want to use : ");
            int NoOfDice = sc.nextInt();

            System.out.print("\nEnter the Number of Snakes : ");
            int NoOfSnakes = sc.nextInt();
            HashMap<Integer, Snake> snakes = new HashMap<>();
            if (NoOfSnakes != 0) {
                System.out.println("\nEnter the Head and Tail positions of each Snake :");
                int i = 0;
                while (i < NoOfSnakes) {
                    int head = sc.nextInt();
                    int tail = sc.nextInt();
                    if (head == boardSize) {
                        System.out.println("!!Snake should not be present at the Destination!!");
                        System.out.println("Please Enter a valid head position...");
                        continue;
                    }
                    if (head > boardSize || tail > boardSize || head < 1 || tail < 1) {
                        System.out.println("!!Please Enter valid positions from 1 to " + boardSize + "!!");
                        continue;
                    }
                    Snake snake = new Snake(head, tail);
                    snakes.put(head, snake);
                    i++;
                }
            }

            System.out.println("\nEnter the Number of Ladders : ");
            int NoOfLadders = sc.nextInt();
            HashMap<Integer, Ladder> ladders = new HashMap<>();
            if (NoOfLadders != 0) {
                System.out.println("Enter the Initial and Final positions of each ladder :");
                int i = 0;
                while (i < NoOfLadders) {
                    int bottom = sc.nextInt();
                    int top = sc.nextInt();
                    if (snakes.containsKey(top) || snakes.containsKey(bottom)) {
                        System.out.println("!!Ladder ends should not be present at the Snake's head!!");
                        System.out.println("Please Enter a valid Ladder position...");
                        continue;
                    }
                    if (top == boardSize) {
                        System.out.println("!!Ladder's end should not be present at the Destination!!");
                        System.out.println("Please Enter a valid Ladder position...");
                        continue;
                    }
                    if (top > boardSize || bottom > boardSize || top < 1 || bottom < 1) {
                        System.out.println("!!Please Enter valid positions from 1 to " + boardSize + "!!");
                        continue;
                    }
                    Ladder ladder = new Ladder(bottom, top);
                    ladders.put(bottom, ladder);
                    i++;
                }
            }

            Board board = new Board(boardSize, NoOfDice);
            board.setPlayer(players);
            board.setLadder(ladders);
            board.setSnake(snakes);

            System.out.println("......................Let's Play......................");
            board.play();

        } else {
            System.out.println("No problem, let me know if you change your mind");
        }
        sc.close();
    }
}
