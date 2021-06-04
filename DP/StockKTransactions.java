package DP;

import java.io.IOException;
import java.util.Scanner;

public class StockKTransactions {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {




             try{

                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[]=new int[n];
                        for(int i=0;i<arr.length;i++){
                            arr[i]=scanner.nextInt();
                        }int k = scanner.nextInt();

                        int dp[][]=new int[k+1][n];
                        for(int i=0;i<=k;i++){
                            int max=Integer.MIN_VALUE;
                            for(int j=0;j<n;j++){
                                if(i==0||j==0) dp[i][j]=0;
                                else {
                                    //k-1 th transaction
                                    max=Math.max(max,dp[i-1][j-1]-arr[j-1]);
                                    //kth transaction
                                    dp[i][j]= Math.max(dp[i][j-1],max+arr[j]);

                                }




                            }
                        }



                 System.out.println(dp[k][n-1]);








           scanner.close();
                }catch(Exception e){
                    System.out.println("Exception occured:"+e);
                       }
         }
}
//n3
//                                    int max=dp[i][j-1];
//                                    for(int p=0;p<j;p++){
//                                        max=Math.max(max,dp[i-1][p]+arr[j]-arr[p]);
//                                    }
//                                    dp[i][j]=max;