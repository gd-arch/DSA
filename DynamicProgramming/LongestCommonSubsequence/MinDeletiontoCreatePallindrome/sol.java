/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming.LongestCommonSubsequence.MinDeletiontoCreatePallindrome;

import java.util.Scanner;

/**
 *
 * @author g
 */
public class sol {
    
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
           return t[n][m];
       }
    
    public static void main(String[] args) {
          Scanner s = new Scanner(System.in);
        int test = s.nextInt();

        while (test-- != 0) {
            String s1 = s.next();
            int n =s1.length() ;
           int m=n;
            
            String s2="";
            for(int i=s1.length()-1;i>=0;i--){
                s2=s2+s1.charAt(i);
            }
            
         
            System.out.println(n-lcs(s1, s2, n, m));
    }
}

}
