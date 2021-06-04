/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LongestIncreasingSub;

import java.util.Arrays;

/**
 *
 * @author g
 */
public class Memozisation {
//    static int t[][]=new int[100][100];
//        public static int lengthOfLIS(int[] nums,int n,int currentpos) {
//          if(n==0){
//              return 0;
//          }
//          if(t[n][currentpos]!=0)return t[n][currentpos];
//          if(nums[n-1]<=nums[currentpos]){
//              return t[n][currentpos]=Math.max(1+lengthOfLIS(nums,n-1,n-1),lengthOfLIS(nums,n-1,currentpos) );
//          }
//          else return t[n][currentpos]=lengthOfLIS(nums,n-1,currentpos);
//        
//          
//    }
          public static int LIS(int[] nums,int n,int currentpos,int t[][]) {
          if(n==0){
              return 0;
          } 
          
           
          if(t[n][currentpos]!=-1)return t[n][currentpos];
          if(nums[n-1]<nums[currentpos]||currentpos==n-1){
              return t[n][currentpos]=Math.max(1+LIS(nums,n-1,currentpos-1,t),LIS(nums,n-1,currentpos,t) );
          }
          else return t[n][currentpos]=LIS(nums,n-1,currentpos,t);
        
          
    }
    public static int lengthOfLIS(int[] arr) {
     int length=arr.length;
        int t[][]=new int[arr.length+1][arr.length+1];
        for (int[] l : t) {
            Arrays.fill(l, -1);
        }
        
        
        return  LIS(arr
                  ,length,length-1,t);
    }   
        
        
      public static void main(String[] args) {
        int arr[]={1,3,6,7,9,4,10,5,6};
        System.out.println(""+lengthOfLIS(arr));
    }
}
