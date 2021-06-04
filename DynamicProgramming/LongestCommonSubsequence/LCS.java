/*
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Input:
First line of the input contains no of test cases  T,the T test cases follow.
Each test case consist of 2 space separated integers A and B denoting the size of string str1 and str2 respectively
The next two lines contains the 2 string str1 and str2 .

Output:
For each test case print the length of longest  common subsequence of the two strings .

Constraints:
1<=T<=200
1<=size(str1),size(str2)<=100

Example:
Input:
2
6 6
ABCDGH
 AEDFHR
3 2
ABC
AC

Output:
3
2

Explanation
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.

LCS of "ABC" and "AC" is "AC" of length 2
 */
package DynamicProgramming.LongestCommonSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * //memoized approach dp
 */
public class LCS {

    static int t[][] = new int[100][100];
    static ArrayList<Character> stack = new ArrayList<>();

    public static int lcs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (t[n][m] != -1) {
            return t[n][m];
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            stack.add(s1.charAt(n - 1));
            return t[n][m] = 1 + lcs(s1, s2, n - 1, m - 1);

        } else {
            return t[n][m] = Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();

        while (test-- != 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            String s1 = s.next();
            String s2 = s.next();
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j <= m + 1; j++) {
                    t[i][j] = -1;
                }
            }
            System.out.println(lcs(s1, s2, n, m));
            for (Character ch : stack) {
                System.out.print(ch);
            }

        }
    }
}
