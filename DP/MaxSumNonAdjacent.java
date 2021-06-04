package DP;

import java.io.IOException;
import java.util.Scanner;

public class MaxSumNonAdjacent {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        try {

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int arr[] = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(maxSumDp(arr));


            scanner.close();
        } catch (Exception e) {
            System.out.println("Exception occured:" + e);
        }
    }

    static int maxASum(int arr[]) {
        int prevIncSum = 0, prevExSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int nextInc = prevExSum + arr[i];
            int nextEx = Math.max(prevExSum, prevIncSum);
            prevExSum = nextEx;
            prevIncSum = nextInc;
        }
        int maxAdSum = Math.max(prevExSum, prevIncSum);
        return maxAdSum;
    }

    private static int maxSum(int[] arr, int n) {
        if (n <= 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);
        return Math.max(arr[n - 1], Math.max(maxSum(arr, n - 1), arr[n - 1] + maxSum(arr, n - 2)));
    }

    private static int maxSumDp(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        if (arr.length >= 1)
            dp[1] = arr[0];
        if (arr.length >= 2)
            dp[2] = Math.max(arr[0], arr[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i - 1] + dp[i - 2]);
            //because subsequence for handling consecutive negative values  where we have the option to not take any value and max becomes 0
            dp[i] = Math.max(dp[i], arr[i - 1]);
        }
        return dp[n];
    }

}
