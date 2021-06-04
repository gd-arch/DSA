package DP;

import java.util.Scanner;

public class knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {

            val[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {

            wt[i] = sc.nextInt();
        }
        int cap = sc.nextInt();
        System.out.println(knapsack(val, wt, cap, n));
    }

    static int knapsack(int[] val, int[] wt, int cap, int n) {
        if (cap == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= cap) {
            return Math.max(val[n - 1] + knapsack(val, wt, cap - wt[n - 1], n - 1), knapsack(val, wt, cap, n - 1));
        } else {
            return knapsack(val, wt, cap, n - 1);
        }
    }


    static int dpKnapsack(int[] val, int[] wt, int cap, int n) {

        int dp[][] = new int[n + 1][cap + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= cap; j++) {
                //part 1
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    int curCap = j;
                    int curIndex = i - 1;
                    //If unbounded knapsack remember jo value li hai usse dobara le sakte hai but jo value nhi li usse nhi lenge dobara

                    if (curCap >= wt[curIndex])
                        dp[i][j] = Math.max(val[curIndex] + dp[i - 1][j - wt[curIndex]], dp[i - 1][j]);
                    else dp[i][j] = dp[i - 1][j];
                }


            }
        }

        return dp[n][cap];
    }
}
