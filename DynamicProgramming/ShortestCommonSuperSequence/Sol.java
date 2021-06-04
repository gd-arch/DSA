/*
Given two strings str1 and str2, find the length of the smallest string which has both, str1 and str2 as its sub-sequences.
Note: str1 and str2 can have both uppercase and lowercase letters.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains two space-separated strings.

Output:
For each testcase, in a new line, output the length of the required string.

Expected Time Complexity: O(Length(str1) * Length(str2)).
Expected Auxiliary Space: O(Length(str1) * Length(str2)).

Constraints:
1 <= T <= 100
1<= |str1|, |str2| <= 100

Example:
Input:
2
abcd xycd
efgh jghi
Output:
6
6
Explanation:
Test Case 1: One of the shortest answer can be abxycd, which is of length 6.
 */
package DynamicProgramming.ShortestCommonSuperSequence;

import java.util.Scanner;

/**
 *
 * @author g
 */
public class Sol {
    public static int lcs(String a,String b,int n,int m){
         int t[][]=new int[n+1][m+1];
         for(int i=0;i<=n;i++){
             for(int j=0;j<=m;j++){
                 if(i==0||j==0){
                     t[i][j]=0;
                 }
                 
             }
         }
          for(int i=1;i<=n;i++){
             for(int j=1;j<=m;j++){
                 if(a.charAt(i-1)==b.charAt(j-1)){
                     t[i][j]=1+t[i-1][j-1];
                 }
                 else t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
             }
             
          }
       for(int x[]:t){
           for(int j:x){
               System.out.print(j);
           }System.out.println("");
       }
       
       //print
       
       
       
        return t[n][m];
    }
    
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
        int test = s.nextInt();

        while (test-- != 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            String s1 = s.next();
            String s2 = s.next();
         
            System.out.println(lcs(s1, s2, n, m));
           

        } 
    }
}
