package DP;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = climbStairs(n, new int[n + 1]);
        System.out.println(ans);
    }

    private static int climbStairs(int n, int[] qb) {

        if (n == 0) return 1;
        if (n < 0) return 0;
        if (qb[n] != 0) return qb[n];
        int n1 = climbStairs(n - 1, qb);
        int n2 = climbStairs(n - 2, qb);
        int n3 = climbStairs(n - 3, qb);

        int cs = n1 + n2 + n3;
        System.out.println(cs);
        qb[n] = cs;
        return cs;

    }

    private static int climbStairs(int n) {

        //tabulation
        int qb[] = new int[n + 1];
        qb[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                qb[i] = qb[i - 1];
            } else if (i == 2) {
                qb[i] = qb[i - 1] + qb[i - 2];
            } else qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];

        }
        return qb[n];

    }
}
