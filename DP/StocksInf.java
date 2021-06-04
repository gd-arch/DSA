package DP;

import java.io.IOException;
import java.util.Scanner;

public class StocksInf {
     private static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws IOException {




             try{

                 int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                             int arr[]=new int[n];
                        for(int i=0;i<arr.length;i++){
                            arr[i]=scanner.nextInt();
                        }

                        int i=0,j=1,min=arr[0],pr=0;
                        boolean firstMax=false,firstMin=true;
                        while(j<n){
                            if(arr[i]>arr[j]){
                                if(firstMax){
                                    pr+=arr[i]-min;
                                    firstMax=false;
                                    firstMin=true;
                                }
                                i++;
                                j++;
                            }
                          else  if(arr[i]<=arr[j])
                            {
                                if(firstMin){
                                    min=arr[i];
                                    firstMax=true;
                                    firstMin=false;
                                }
                                i++;
                                j++;
                            }
                          if(j==n&&firstMax&&!firstMin){
                              pr+=arr[i]-min;
                          }


                        }


                 System.out.println(pr);





          scanner.close();
                }catch(Exception e){
                    System.out.println("Exception occured:"+e);
                       }
         }
}
