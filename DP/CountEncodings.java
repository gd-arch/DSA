package DP;
//1. You are given a string str of digits. (will never start with a 0)
//2. You are required to encode the str as per following rules
//    1 -> a
//    2 -> b
//    3 -> c
//    ..
//    25 -> y
//    26 -> z
//3. You are required to calculate and print the count of encodings for the string str.
//
//     For 123 -> there are 3 encodings. abc, aw, lc
//     For 993 -> there is 1 encoding. iic
//     For 013 -> This is an invalid input. A string starting with 0 will not be passed.
//     For 103 -> there is 1 encoding. jc
//     For 303 -> there are 0 encodings. But such a string maybe passed. In this case
//     print 0.

import java.util.Arrays;
import java.util.Scanner;

public class CountEncodings {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(dpCountEnc(str));
    }

    public static int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return countEnc(s, dp);
    }

    public static int countEnc(String str, int dp[]) {
        int n = str.length();
        if (str.length() < 0 || str.equals("0")) return 0;
        if (str.length() == 0 || str.length() == 1) return 1;
        if (dp[n] != -1) return dp[n];
        String one = str.substring(0, 1);
        String two = str.substring(0, 2);
        int ans1 = 0, ans2 = 0;
        if (isCharacter(one)) {

            ans1 = countEnc(str.substring(1), dp);
        }
        if (isCharacter(two)) {

            ans2 = countEnc(str.substring(2), dp);
        }
        return dp[n] = ans1 + ans2;

    }


    private static boolean isCharacter(String str) {

        if (str.length() == 1) {
            int no = Integer.parseInt(str);
            return no > 0;
        } else {
            if (str.charAt(0) != '0') {
                int no = Integer.parseInt(str);
                return no <= 26 && no > 0;
            }

        }
        return false;

    }

    public static int dpCountEnc(String str) {
        int n = str.length();
        int dp[] = new int[n];
        //basically depends on value of i and i-1 character

        dp[0] = 1;
        for (int k = 1; k < n; k++) {
            char i = str.charAt(k);
            char iSub1 = str.charAt(k - 1);

            //if i-1 and i th characters is of the type 0 0
            if (iSub1 == '0' && i == '0') return dp[k] = 0;
            //if i-1 and i th characters is of the type 0 Num
            if (iSub1 == '0' && i != '0') {
                //Consider only single Num as valid
                dp[k] = dp[k - 1];
            }
            //if i-1 and i th characters is of the type Num 0
            if (iSub1 != '0' && i == '0') {
                //Consider only single Num as valid iff it is 1 or 2 which will form 10 or 20
                if (iSub1 == 1 || iSub1 == 2) dp[k] = (k - 2) >= 0 ? dp[k - 2] : 1;
            }
            //if i-1 and i th characters is of the type Num Num
            else {
                //if num num is less than 26 consider both the scenario
                if (Integer.parseInt(str.substring(k - 1, k + 1)) <= 26) {

                    dp[k] = dp[k - 1] + (k - 2) >= 0 ? dp[k - 2] : 1;
                }
                //consider the case when single digit Num is only taken
                else {
                    dp[k] = dp[k - 1];
                }
            }

        }
        return dp[n - 1];


    }

}
