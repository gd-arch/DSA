/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author g
 */
public class SortedArrayCombination {
    
   private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 	{
        
        
        
        
        try{
  int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int a[]=new int[n];
        int b[]=new int[m];
           for(int i=0;i<n;i++){
               a[i]=scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
           }
     for(int i=0;i<m;i++){
               b[i]=scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
           }
                     
       int i=0,j=0,temp;
       while(i<n){
   if(a[i]>b[j]){
       temp=a[i];
       a[i]=b[j];
       b[j]=temp;
       i++;
       //sort B
       for(int ii=1;i<b.length;ii++){
           int var=b[0];
           if(b[ii]>b[0]){
               //0 to ii shift array backwards
               for(int jj=1;jj<ii;jj++){
                   b[jj-1]=b[jj];
               }
               b[ii-1]=var;
               break;
           }
           
       }
                

   }
   else{
      i++; 
   }
       }
       
          
            
             for (int x : a) {
                System.out.print(x + " ");}  
            
          
             
           
for (int x : b) {
                System.out.print(x + " ");}  

      System.out.println("");  
    
    }  scanner.close();
           }catch(Exception e){
               System.out.println("Exception occured:"+e);   
                  }
    }
}
