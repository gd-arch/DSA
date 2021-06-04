package DP;

import java.util.Scanner;

public class TargetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        System.out.println(targetSum(arr, tar));
    }

    private static boolean targetSum(int[] arr, int sum, int tar, int n) {
        if (sum == tar) return true;
        else if (sum > tar || n < 0) {
            return false;
        }

        return targetSum(arr, sum + arr[n], tar, n - 1) || targetSum(arr, sum, tar, n - 1);


    }

    static boolean targetSum(int arr[], int tar) {
//Remember these problems are base problems of knapsack
        //changing elements are n and the sum so we use 2d array with dimensions n(size always taken in left side) and sum
        boolean dp[][] = new boolean[arr.length + 1][tar + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                //part1
                if (i == 0 && j == 0) dp[i][j] = true;
                    //part2
                else if (i == 0) {
                    dp[i][j] = false;

                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    int curTarget = j;
                    int curVal = arr[i - 1];// i (n+1) is mapped to n
                    if (curTarget >= curVal) {
                        dp[i][j] = dp[i - 1][j - curVal] || dp[i - 1][j];
                        //purani team ne run banaliye ya current khiladi ne or team ne run bana liye kissi ek ne bhi banaye to match jeet gaye
                        //dono nhi banaye to match har gaye
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        //run jeetne bache hai usse jyada ban jayaega to current player ko mat khilao
                    }
                }


            }

        }
        return dp[arr.length][tar];
    }
}
