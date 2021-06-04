package DP;

import java.io.IOException;
import java.util.Scanner;

//Total NO of Strings of length n with no consecutive 0's
public class CountBinaryStrings {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        try {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            //sam each block represent NO of Strings of length 1 with no consecutive 0's
            //Dean-smallest problem at length 1
            int prevEnd0 = 1;//0
            int prevEnd1 = 1;//1
            for (int i = 2; i <= n; i++) {
                //i=length of string
                int nextEnd0 = prevEnd1;//no consecutive 0
                int nextEnd1 = prevEnd1 + prevEnd0;//no constraints take all possible pairs
                //update prev var
                prevEnd0 = nextEnd0;
                prevEnd1 = nextEnd1;

            }
            //no of strings with no consecutive zeroes
            int noOfStr = prevEnd0 + prevEnd1;
            System.out.println(noOfStr);

            scanner.close();
        } catch (Exception e) {
            System.out.println("Exception occured:" + e);
        }
    }


}
