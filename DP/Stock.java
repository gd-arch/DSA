package DP;

import java.io.IOException;
import java.util.Scanner;

public class Stock {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {




             try{


                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[]=new int[n];
                        for(int i=0;i<arr.length;i++){
                            arr[i]=scanner.nextInt();
                        }

                int min=arr[0],pr=0;
                 for (int i = 1; i <n ; i++) {
                    pr=Math.max(pr,arr[i]-min);
                    min=Math.min(min,arr[i]);
                 }
                 System.out.println(pr);






           scanner.close();
                }catch(Exception e){
                    System.out.println("Exception occurred:"+e);
                       }
         }
}
