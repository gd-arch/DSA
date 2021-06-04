package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinClimbMoves {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }
        int qb[] = new int[n + 1];
        Arrays.fill(qb, Integer.MAX_VALUE);
        int ans = minMoves(arr, 0, qb);
        if (ans != Integer.MAX_VALUE)
            System.out.println(ans);
    }

    //Memoization
    private static int minMoves(int[] arr, int index, int qb[]) {
//base case
        if (index == arr.length - 1) {
            return qb[index] = 0;
        }
        //Negative base cases
        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }
        if (qb[index] != Integer.MAX_VALUE) return qb[index];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[index]; i++) {
            min = Math.min(min, minMoves(arr, index + i, qb));
        }
        if (min != Integer.MAX_VALUE) {
            return qb[index] = min + 1;
        } else return qb[index] = min;

    }


}
