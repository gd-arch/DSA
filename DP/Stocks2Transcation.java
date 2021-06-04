package DP;

import java.io.IOException;
import java.util.Scanner;

public class Stocks2Transcation {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {




             try{



                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[]=new int[n];
                        for(int i=0;i<arr.length;i++){
                            arr[i]=scanner.nextInt();
                        }
                        //Max transaction from left
                        int left[]=new int[n];
                 //Max transaction from right
                        int right[]=new int[n];
                        int min=arr[0];

                        for(int i=1;i<n;i++){
                            min=Math.min(arr[i],min);
                            left[i]=Math.max(arr[i]-min,left[i-1]);
                        }
                        int max=arr[n-1];
                 for(int i=n-2;i>=0;i--){
                     max=Math.max(arr[i],max);
                     right[i]=Math.max(max-arr[i],right[i+1]);
                 }
                 int maxSum=0;
               for(int i=0;i<n;i++){
                   maxSum=Math.max(left[i]+right[i],maxSum);
               }
                 System.out.println(maxSum);













          scanner.close();
                }catch(Exception e){
                    System.out.println("Exception occured:"+e);
                       }
         }
}
