package DP;

import java.io.IOException;
import java.util.Scanner;

public class PaintNHouses {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int dp[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {

                if (i == 0) {
                    dp[i][j] = arr[i][j];

                } else {
                    int min = Integer.MAX_VALUE;

                    for (int t = 0; t < k; t++) {
                        if (t != j)
                            if (min > dp[i - 1][t]) {
                                min = dp[i - 1][t];
                            }
                    }


                    dp[i][j] = min + arr[i][j];
                }


            }

        }
        int min = Integer.MAX_VALUE;
        for (int val : dp[n - 1]) {
            min = Math.min(val, min);
        }
        System.out.println(min);

    }
}


// int finalJ = j;
//                        Function leftmin = () -> {
//                            int min=dp[i-1][finalJ];
//                            for(int t = finalJ; t<n; t++){
//                                if(min>arr[i-1][t]){
//                                    min=arr[i-1][t];
//                                }
//                                return min;
//                            }
