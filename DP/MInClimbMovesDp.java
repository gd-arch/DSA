package DP;

import java.util.Scanner;

public class MInClimbMovesDp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }
        int ans = minMoves(arr);
        System.out.println(ans);
    }

    private static int minMoves(int[] arr) {
        int n = arr.length;
        Integer dp[] = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            if (arr[i] != 0) {
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);

                    }
                    //min can be Int.Max


                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = 1 + min;
                }
            }
        }
        return dp[0];
    }


}
