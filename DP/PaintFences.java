package DP;

import java.io.IOException;
import java.util.Scanner;

public class PaintFences {


    public static void main(String[] args) throws IOException {


        try {


            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n == 1) System.out.println(0);
            else {
                int same = k;
                int diff = k * (k - 1);
                int total = same + diff;
                for (int i = 3; i <= n; i++) {
                    same = diff;
                    diff = total * (k - 1);
                    total = same + diff;
                }
                System.out.println(total);
            }

        } catch (Exception e) {
            System.out.println("Exception occured:" + e);
        }
    }


}
