package DP;

import java.io.IOException;
import java.util.Scanner;

public class StocksInfFee {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {





                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[]=new int[n];
                        for(int i=0;i<arr.length;i++){
                            arr[i]=scanner.nextInt();
                        }
             int fee = scanner.nextInt();
//ssp=stock selling price
//bsp=bought stock price considered as negative
                        int ossp=0,nssp=0,obsp=-arr[0],nbsp;
             for (int i = 1; i <n ; i++) {
                 nbsp=Math.max(obsp,ossp-arr[i]);
                 nssp=Math.max(ossp,arr[i]-fee+obsp);
                 obsp=nbsp;
                 ossp=nssp;

             }
             System.out.println(nssp);









           scanner.close();

         }
}
