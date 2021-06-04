/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LongestIncreasingSub;

/**
 *
 * @author g
 */
public class Recursion {
      public static int lengthOfLIS(int[] nums,int n,int currentMax) {
          if(n==0){
              return 0;
          }
          if(nums[n-1]<=currentMax){
              return Math.max(1+lengthOfLIS(nums,n-1,nums[n-1]),lengthOfLIS(nums,n-1,currentMax) );
          }
          else return lengthOfLIS(nums,n-1,currentMax);
        
          
    }
      public static void main(String[] args) {
        int arr[]={10,9,2,5,3,7,101,18};
          System.out.println(""+lengthOfLIS(arr,arr.length,arr[arr.length-1]));
    }
}
