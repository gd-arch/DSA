

import java.util.Scanner;

public class Partition {
    public static void partition(int[] arr, int pivot) {
        //At any time in the array consider three partitions-
        //partition-1 unknown elements from  i to end
        //partition-2 greater than elements from j to i-1
        //partition 3- smaller than equal to elements  from 0 to j-1
        //0..less-than...j-1,j..greater-than...i-1,i.unknown...n
        //point of interest is i
        int i = 0, j = 0;
        while (i < arr.length) {
            if (arr[i] > pivot) {
                i++;
            } else {
                swap(arr, i, j);


                i++;
                j++;
            }
        }

    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = scn.nextInt();
        partition(arr, pivot);
        print(arr);
    }
}
