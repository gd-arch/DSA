/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubsetSum;

import static DynamicProgramming.minimumSubsetDifference.Solution.t;
import static SubsetSum.SubsetDP.subSumDP;


public class SubSum {
    public static boolean subsetsum(int arr[],int sum,int n){
        
      //size of array  
      //base condition & min valid value returned by method
      if(sum==0&&n-1>0) return true;
      if(sum>0&&n-1==0)return false;
  if(sum>=arr[n-1]){
      return subsetsum(arr,sum-arr[n-1],n-1)||subsetsum(arr,sum,n-1);
  }
  else return subsetsum(arr,sum,n-1);
        
        
    }
    public static void main(String[] args) {
        int arr[]={2,3,8,7,10};
        int sum=0;
        boolean b=subsetsum(arr,sum,arr.length);
                boolean c=subSumDP(arr,sum,arr.length);

        System.out.println("Sol="+b);
        for(boolean x[]:t){
              for(boolean y: x){
              System.out.print(y+" ");
          }System.out.println("");
          }
                System.out.println("DP Sol="+c);

        
        
        
    }
}
