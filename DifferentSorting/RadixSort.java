

public class RadixSort {
    public static void main(String[] args) {


    }

    public static void radixSort(int arr[]) {
        int exp = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        while (exp < max) {
            countSort(arr, exp);
            exp = exp * 10;
        }
    }

    public static void countSort(int[] arr, int exp) {

        int farr[] = new int[10];
        //creating frequency arr
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] / exp % 10;
            farr[idx]++;
        }
        //convert farr to prefix sum array to know the last position of element in the range of min and max

        for (int i = 1; i < farr.length; i++) {

            farr[i] = farr[i - 1] + farr[i];
        }
        int ans[] = new int[arr.length];
        //use the psum to find last index and place selected element from the last at that index
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            int idx = value / exp % 10;
            int lastIdx = farr[idx] - 1;
            ans[lastIdx] = value;
            farr[idx]--;

        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

}
