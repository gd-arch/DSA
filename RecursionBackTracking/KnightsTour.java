package PepCode.src.RecursionBackTracking;

import java.util.Scanner;

public class KnightsTour {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] chess = new int[n][n];
        printKnightsTour(chess, row, col, 1);

    }

    //levels and choices
    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
        //remove invalid cases first else they will also get printed if move check is in  first line
        if (r >= chess.length || c >= chess[0].length || r < 0 || c < 0 || chess[r][c] != 0) {
            return;
        }
        if (move == chess.length * chess.length) {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = move;
        //Right possible moves
        printKnightsTour(chess, r - 2, c + 1, move + 1);
        printKnightsTour(chess, r - 1, c + 2, move + 1);
        printKnightsTour(chess, r + 1, c + 2, move + 1);
        printKnightsTour(chess, r + 2, c + 1, move + 1);
        //Left possible moves
        printKnightsTour(chess, r + 2, c - 1, move + 1);
        printKnightsTour(chess, r + 1, c - 2, move + 1);
        printKnightsTour(chess, r - 1, c - 2, move + 1);
        printKnightsTour(chess, r - 2, c - 1, move + 1);

        chess[r][c] = 0;

    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
