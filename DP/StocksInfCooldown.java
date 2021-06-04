package DP;

import java.io.IOException;
import java.util.Scanner;

public class StocksInfCooldown {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {




             try{

             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[]=new int[n];
                        for(int i=0;i<arr.length;i++){
                            arr[i]=scanner.nextInt();
                        }

                 //old cooldown selling price
                        int ocsp=0;
                        int obsp=-arr[0],ossp=0;
                 //old stock buying price
                 //old stock selling price
                        for (int i = 1; i <n ; i++) {
                     int nssp=0,nbsp=0,ncsp=0;
                     nbsp=Math.max(obsp,ncsp-arr[i]);
                     nssp=Math.max(ossp,arr[i]+obsp);
                     ncsp=Math.max(ossp,ocsp);
                     //we don't use new variables while calculating values of new variables as itmight depend on the position of calculation of new var inside for loop


                     ossp=nssp;
                     ocsp=ncsp;
                     obsp=nbsp;

                 }
                 System.out.println(ossp);








           scanner.close();
                }catch(Exception e){
                    System.out.println("Exception occured:"+e);
                       }
         }
}
