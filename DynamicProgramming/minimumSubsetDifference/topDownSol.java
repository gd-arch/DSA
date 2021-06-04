/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming.minimumSubsetDifference;

import java.util.Arrays;

/**
 *
 * @author g
 */
public class topDownSol {
    
    public static int minSubSumDiff(int arr[],int size){
           int sum=0;
         for(int k:arr){
             sum+=k;
         }
         System.out.println("sum:"+sum);
        //minimum subset diff
        
        //initialize
        boolean dp[][]=new boolean[size+1][sum+1];
         for(int i=0;i<=size;i++){
             dp[i][0]=true;
         }
         for(int j=1;j<=sum;j++){
             dp[0][j]=false;
         }
         for(int i=1;i<=size;i++){
        
         for(int j=1;j<=sum;j++){
         dp[i][j]=dp[i-1][j];
            if(arr[i-1]<=j){
                dp[i][j]=dp[i-1][j-arr[i-1]]||  dp[i][j];
            }
         
             
             
         }}


         
         
         int diff=Integer.MAX_VALUE;
          for (int j = sum / 2; j >= 0; j--) 
        { 
            // Find the  
            if (dp[size][j] == true) 
            { 
                diff = sum - 2 * j; 
                System.out.println("j"+j);
                break; 
            } 
        } 
        return diff; 
         
         
        
    }
    
    
    public static void main(String[] args) {
        int arr[]={3, 1, 4, 2, 2, 1};
        
        System.out.println("min subsset difference"+minSubSumDiff(arr,arr.length));
        
        
    }
}
