import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Boolean isPlayerX = true;
        String position;
        Scanner scanner = new Scanner(System.in);

        Functionality functionality = new Functionality();
        Random random = new Random();
        System.out.println(functionality.pretty(board));

        System.out.print("Would you like to play against AI? Enter Y or N: ");
        Boolean playAgainstAI = scanner.next().toUpperCase() == "Y" ? true : false;

        boolean keepPlaying = true;

        if (!playAgainstAI) {
            while (keepPlaying) {
                System.out.print(isPlayerX ? "X please enter a number to fill: " : "O please enter a number to fill: ");
                position = scanner.next();

                if (isPlayerX) {
                    board = functionality.changeBoard(board, "X", position);
                    isPlayerX = false;
                } else {
                    board = functionality.changeBoard(board, "O", position);
                    isPlayerX = true;
                }

                keepPlaying = functionality.gameNotFinished(board, "X");
                if (!keepPlaying) break;

                keepPlaying = functionality.gameNotFinished(board, "O");
                if (!keepPlaying) break;
            }
        } else {
            while (keepPlaying) {
                if (isPlayerX) {
                    System.out.print("X please enter a number to fill: ");
                    position = scanner.next();

                    board = functionality.changeBoard(board, "X", position);
                    isPlayerX = false;
                } else {
                    System.out.println("AI Turn");
                    board = functionality.changeBoard(board, "O", "9");
                    isPlayerX = true;
                }

                keepPlaying = functionality.gameNotFinished(board, "X");
                if (!keepPlaying) break;

                keepPlaying = functionality.gameNotFinished(board, "O");
                if (!keepPlaying) break;
            }
        }
    }
}
