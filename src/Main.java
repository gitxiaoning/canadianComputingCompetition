import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[3][3];
        char[][] boardX = new char[3][3];

        String[] str = new String[3];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            str[i] = in.nextLine();

            for (int n = 0; n < 3; n++) {

                try {
                    if (str[i].indexOf(' ', index) == -1)
                        board[i][n] = Integer.parseInt(str[i].substring(index));
                    else
                        board[i][n] = Integer.parseInt(str[i].substring(index, str[i].indexOf(' ', index)));
                } catch (NumberFormatException e) {
                    boardX[i][n] = 'X';
                }
                index = str[i].indexOf(' ', index);
                index++;

                //                System.out.println(index);
                //                System.out.print(board[i][n] + " ");
            }

        }

        for (int i = 0; i < 3; i++) {
            for (int n = 0; n < 3; n++) {
                if (boardX[i][n] == 'X')
                    board[i][n] = ((board[i][n + 1] - board[i][n - 1]) / 2) + board[i][n - 1];
            }
        }
        for (int i = 0; i < 3; i++)
            for (int n = 0; n < 3; n++)
                System.out.print(board[i][n] + " ");

    }
}
