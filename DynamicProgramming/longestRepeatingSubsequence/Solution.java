/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming.longestRepeatingSubsequence;

import java.util.Scanner;

/**
 *
 * @author g
 */
public class Solution {
      public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();

        while (test-- != 0) {
            int n = s.nextInt();
            int m = n;
            String s1 = s.next();
            String s2 = s1;
           
            System.out.println(lcs(s1, s2, n, m));
          
        }
    }

    private static int lcs(String s1, String s2, int n, int m) {
        int arr[][]=new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            arr[i][0]=0;
            arr[0][i]=0;
        }
         
for(int i=1;i<=n;i++){
            
        
         for(int j=1;j<=m;j++){
          if(s1.charAt(i-1)==s2.charAt(j-1)&&i!=j){
              arr[i][j]=1+arr[i-1][j-1];
          }  
          else  arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
        }
}
  for(int x[]:arr){
           for(int j:x){
               System.out.print(j);
           }System.out.println("");
       }
return arr[n][m];


    }
}
