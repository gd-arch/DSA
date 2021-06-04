

import java.util.Scanner;

public class QuickSelect {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));

    }

    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);
        if (pi == k) {
            return arr[pi];
        } else if (pi > k) {
            //search left side
            return quickSelect(arr, lo, pi - 1, k);

        } else {
            return quickSelect(arr, pi + 1, hi, k);

        }


    }

    static int partition(int[] arr, int pivot, int lo, int hi) {
        //high represent length of array
        //j-1 represent position of pivot because in last move the pivot is swapped with j-1 which is then incremented to become j
        int i = lo, j = lo;
        while (i < hi) {
            if (arr[i] > pivot) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }


        }
        return (j - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
