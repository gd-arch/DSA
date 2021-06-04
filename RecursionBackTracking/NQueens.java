package PepCode.src.RecursionBackTracking;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);

    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
//base condition to print
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }

        //first put queen in all possible positions

        int colLength = chess[0].length;
        for (int col = 0; col < colLength; col++) {

            if (isQueenSafe(chess, row, col)) {
                //mark queen position
                chess[row][col] = 1;
                //check for settling another queen by incr. row ;single row single queen
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                //when call is returned we are going to check another column for same queen so unmark the already marked position
                chess[row][col] = 0;


            }
        }

    }

    private static boolean isQueenSafe(int[][] chess, int row, int col) {
        //top up check for any queen
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) return false;
        }
        //top left position
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) return false;
        }
        //top right position
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 1) return false;
        }
        //there is no bottom position because no queen is placed there yet
        return true;
    }


}
