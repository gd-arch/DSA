package PepCode.src.RecursionBackTracking;

import java.util.Scanner;

public class TargetSumSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int tar = sc.nextInt();
        printTargetSumSubsets(arr, 0, "", 0, tar);
    }

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {

        if (idx == arr.length && sos == tar) {
            set += ",.";
            System.out.println(set);
            return;
        }
        if (idx == arr.length || sos > tar) return;
        String st = "";
        if (set.length() == 0) {
            st = set + arr[idx];
        } else st = set + "," + arr[idx];
        printTargetSumSubsets(arr, idx + 1, st, sos + arr[idx], tar);
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }
}
