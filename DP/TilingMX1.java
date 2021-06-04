package DP;

import java.util.Scanner;

public class TilingMX1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;//represent n*1(m) board and 1(m)* 1 tile

        for (int i = 2; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;//only one way that is vertical

            } else if (i == m) {
                dp[i] = 2;//only 2 ways that is vertical only and horizontal only

            } else {
                dp[i] = dp[i - 1] + dp[i - m];
                //i - m > 0  in this block

            }


        }


        System.out.println(dp[n]);

    }
}
