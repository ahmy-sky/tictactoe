import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functionality {

    Scanner scanner = new Scanner(System.in);
    String player;
    String position;
    String[] board = new String[8];
    public String[] changeBoard(String[] board, String player, String position) {
        System.out.println(pretty(board).replace(position, player));
        board[Integer.parseInt(position ) - 1] = player;

        System.out.println(randomNumber(board));

        return board;
    }

    public boolean gameNotFinished(String[] board, String player) {
        if (board[0].equals(player) && board[1].equals(player) && board[2].equals(player)) {
            System.out.println("Winner is " + player);
            return false;
        } else if (board[3].equals(player) && board[4].equals(player) && board[5].equals(player)) {
            System.out.println("Winner is " + player);
            return false;
        } else if (board[6].equals(player) && board[7].equals(player) && board[8].equals(player)) {
            System.out.println("Winner is " + player);
            return false;
        } else if (board[0].equals(player) && board[3].equals(player) && board[6].equals(player)) {
            System.out.println("Winner is " + player);
            return false;
        } else if (board[1].equals(player) && board[4].equals(player) && board[7].equals(player)) {
            System.out.println("Winner is " + player);
            return false;
        } else if (board[2].equals(player) && board[5].equals(player) && board[8].equals(player)) {
            System.out.println("Winner is " + player);
            return false;
        } else if (board[0].equals(player) && board[4].equals(player) && board[8].equals(player)) {
            System.out.println("Winner is " + player);
            return false;
        } else if (board[2].equals(player) && board[4].equals(player) && board[6].equals(player)) {
            System.out.println("Winner is " + player);
            return false;
        }
        return true;
    }

    public String pretty(String[] board) {
        return String.format("------------------" +
                "\n%s   |   %s   |   %s" +
                "\n%s   |   %s   |   %s" +
                "\n%s   |   %s   |   %s" +
                "\n------------------",
                board[0], board[1], board[2], board[3], board[4],
                board[5], board[6], board[7], board[8]);
    }

    public List<Integer> randomNumber(String[] board) {
        int min = 9;
        int max = 0;

        List<Integer> positionsAvailable = new ArrayList<>();

        for (String string : board) {
            if (string.equals("X") || string.equals("O")) {
                continue;
            } else {
                positionsAvailable.add(Integer.parseInt(string) - 1);
            }
        }

        return positionsAvailable;
    }

}
