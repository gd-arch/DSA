package DP;

import java.util.Scanner;

public class CoinChangeCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {

            val[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        System.out.println(coinComb(val, amt, n));

    }

    //add all choices
    static int coinComb(int val[], int amt, int size) {
        if (amt == 0) return 1;
        if (size == 0) return 0;
        if (val[size - 1] <= amt) {
            return coinComb(val, amt - val[size - 1], size) + coinComb(val, amt, size - 1);
        } else return coinComb(val, amt, size - 1);

    }

}
