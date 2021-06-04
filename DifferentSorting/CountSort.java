

import java.util.Scanner;

public class CountSort {

    public static void countSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int farr[] = new int[range];
        //creating frequency arr
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            farr[idx]++;
        }
        //convert farr to prefix sum array to know the last position of elemenet in the range of min and max

        for (int i = 1; i < farr.length; i++) {

            farr[i] = farr[i - 1] + farr[i];
        }
        int ans[] = new int[arr.length];
        //use the psum to find last index and place selected element from the last at that index
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            int idx = value - min;
            int lastIdx = farr[idx] - 1;
            ans[lastIdx] = value;
            farr[idx]--;

        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }

}
