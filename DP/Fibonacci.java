package DP;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = fib(n, new int[n + 1]);
        System.out.println(ans);
    }

    //memoized DP
    public static int fib(int n, int[] qb) {
        if (n == 0 || n == 1) return n;
        if (qb[n] != 0) return qb[n];
        qb[n] = fib(n - 1, qb) + fib(n - 2, qb);
        return qb[n];


    }

}
