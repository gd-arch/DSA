package DP;

import java.util.Scanner;

public class ClimbStairsVariableMoves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }
        System.out.println(climbVStairs(arr));
    }

    static int climbVStairs(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        //SAM store and Meaning nth index will have all the paths to top from 0 to arr[i] value at that index
        dp[n] = 1;
        //path from n to n is counted 1
        //Direction of problem solving- easy to solve path from n(6) to n(6) then from path m to n(6) where m<6 .therefore direction opposite
        // travel from bottom to top
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0)
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    dp[i] += dp[i + j];

                }

        }
        return dp[0];//represent all the paths from 0 to n
    }
}
