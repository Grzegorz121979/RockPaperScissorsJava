import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random myRandom = new Random();
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Do you want to play rock, paper, scissors? (Y/N): ");
        String player = keyboard.next().toUpperCase();
        boolean game = true;
        while (game) {
            if (player.equals("Y")) {
                System.out.println(play());
                System.out.print("Do you want to play rock, paper, scissors? (Y/N): ");
                player = keyboard.next().toUpperCase();
            } else {
                game = false;
                System.out.println("Thanks for the game");
            }
        }

    }

    static String play() {
        Map<Integer, Character> computer = new HashMap<>();
        computer.put(1, 'r');
        computer.put(2, 'p');
        computer.put(3, 's');
        System.out.print("'r' for rock, 'p' for paper, 's' for scissors: ");
        char player = keyboard.next().charAt(0);
        int compPlayer = myRandom.nextInt(3) + 1;
        char comp = computer.get(compPlayer);

        if (player == comp) {
            System.out.println("It's tie.");
        }

        if (win(player, comp)) {
            return "You won!";
        }
        return "You lost!";
    }

    static boolean win(char user, char opponent) {
        if (user == 'r' && opponent == 's') {
            return true;
        } else if (user == 's' && opponent == 'p') {
            return true;
        } else if (user == 'p' && opponent == 'r') {
            return true;
        } else {
            return false;
        }
    }
}
