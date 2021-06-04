package DP;

import java.io.IOException;
import java.util.Scanner;

public class MinCostToPaintHouses {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        try {


            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int arr[][] = new int[n][3];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 3; j++)
                    arr[i][j] = scanner.nextInt();
            }

            double prevRed = arr[0][0], prevBlue = arr[0][1], prevGreen = arr[0][2];

            for (int i = 1; i < arr.length; i++) {


                double nextRed = arr[i][0] + Math.min(prevBlue, prevGreen);
                double nextBlue = arr[i][1] + Math.min(prevRed, prevGreen);
                double nextGreen = arr[i][2] + Math.min(prevRed, prevBlue);
                prevRed = nextRed;
                prevBlue = nextBlue;
                prevGreen = nextGreen;

            }
            double cost = Math.min(prevRed, Math.min(prevGreen, prevBlue));
            System.out.println(cost);


            scanner.close();
        } catch (Exception e) {
            System.out.println("Exception occured:" + e);
        }
    }


}
