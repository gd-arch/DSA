package DP;

import java.util.Scanner;

public class MinMazePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(minMazePath(arr, 0, 0, new int[n][m]));
    }

    //Memoization recursion + 2lines of code
    private static int minMazePath(int[][] arr, int r, int c, int[][] qb) {

        if (r < 0 || c < 0 || r >= arr.length || c >= arr[0].length) {
            return Integer.MAX_VALUE;
        }
        if (qb[r][c] != 0) {
            return qb[r][c];
        }

        if (r == arr.length - 1 && c == arr[0].length - 1) {
            return qb[r][c] = arr[r][c];
        }
//Every return value for a particular row column represent path from that r,c to destination i.e solution of sub problems
        return qb[r][c] = arr[r][c] + Math.min(minMazePath(arr, r + 1, c, qb), minMazePath(arr, r, c + 1, qb));

    }
}
