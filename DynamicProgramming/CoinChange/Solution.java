 /*
1 7 2 2 1
   2
 3 
1 2 3
 4
 4
 2 5 3 6 
10



 */
package DynamicProgramming.CoinChange;

import java.util.Scanner;

/**
 *
 * @author g
 */
public class Solution {
    public static int coinChange(int sum,int val[],int n ){
        int arr[][]=new int[n+1][sum+1];
        //base condition
//        if(sum==0&&n>=0){
//            return 1;
//        }
//          if(n==0&&sum>0){
//            return 0;
//        } 
// if(val[n-1]<=sum){
//            return  coinChange(sum,val,n-1)+ coinChange(sum-val[n-1],val,n);
//        }
//        else 
//            return coinChange(sum,val,n-1);
//       
          
          for(int i=0;i<=n;i++){
            arr[i][0]=1;
        }
        for(int i=1;i<=sum;i++){
            arr[0][i]=0;
        }
         for(int i=1;i<=n;i++){
             for(int j=1;j<=sum;j++){
         
       if(val[i-1]<=j){
           arr[i][j] = arr[i-1][j]+ arr[i][j-val[i-1]];
       }
      else 
           arr[i][j] = arr[i-1][j];
  }
 



    }
       if(arr[n][sum]==Integer.MAX_VALUE-1)
 return -1;
 else return arr[n][sum];

    }
    
    
    public static void main(String[] args) {
        	            Scanner s = new Scanner(System.in);
                int test= s.nextInt();
                int n=0;
while(test--!=0){
     int cents=s.nextInt();
     n=s.nextInt();
  
      int a[] = new int[n];
        for(int i = 0; i < n; i++)
     {
             a[i] = s.nextInt();
         }
    
    
     System.out.println(coinChange(cents, a,n ));

       
     
}
        
        
        
    }
}
