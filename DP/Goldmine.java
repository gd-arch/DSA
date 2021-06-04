package DP;

import java.util.Scanner;

public class Goldmine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxGold(arr));
    }

    static int maxGold(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int dp[][] = new int[row][col];
        //direction from last column to 0th
        for (int i = col - 1; i >= 0; i--) {
            for (int j = row - 1; j >= 0; j--) {
                //part 1- last column ans is same as in arr
                if (i == col - 1) {
                    dp[j][i] = arr[j][i];

                }
                //part 2-last row( last row last col not included)possible moves is 2 top r and r
                else if (j == row - 1) {
                    dp[j][i] = arr[j][i] + Math.max(dp[j][i + 1], dp[j - 1][i + 1]);

                }
                //part 3-top row possible moves is 2 bottom r and r
                else if (j == 0) {
                    dp[j][i] = arr[j][i] + Math.max(dp[j][i + 1], dp[j + 1][i + 1]);

                }
                //part 4- rest of the array ,possible moves is 3
                else {
                    dp[j][i] = arr[j][i] + Math.max(dp[j - 1][i + 1], Math.max(dp[j][i + 1], dp[j + 1][i + 1]));

                }


            }


        }
        //finding max element int the 0th column
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < dp.length; k++) {
            max = Math.max(max, dp[k][0]);
        }


        return max;
    }
}
