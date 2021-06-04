

import java.util.Scanner;

public class SortDates {

    public static void sortDates(String[] arr) {
        countSort(arr, 32, 1000000, 100);
        countSort(arr, 13, 10000, 100);
        countSort(arr, 2501, 1, 10000);
    }

    public static void countSort(String[] arr, int range, int div, int mod) {
        int[] farr = new int[range];
        for (int i = 0; i < arr.length; i++) {
            farr[Integer.parseInt(arr[i], 10) / div % mod]++;
        }
        //create prefixsum array
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }
        //Creating an ans array
        //value which needs to be placed in ans array is retrieved from the value array in reverse order to maintain order Stable sort i.e the value which comes after similar value  must come after all values of same type
        //last index at which the value need to be retrieved is given by prefixsum array and value is updated at prefixsum array


        String ans[] = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {

            int arrtoFarrIndex = Integer.parseInt(arr[i], 10) / div % mod;
            int lastIdx = farr[arrtoFarrIndex] - 1;
            ans[lastIdx] = arr[i];
            farr[arrtoFarrIndex]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }

}
