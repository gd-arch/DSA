/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming.MinInsertAndDelToConvertAtoB;

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
//       for(int x[]:t){
//           for(int j:x){
//               System.out.print(j);
//           }System.out.println("");
//       }
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
