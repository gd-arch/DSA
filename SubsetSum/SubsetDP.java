/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubsetSum;

/**
 *
 * @author g
 */
public class SubsetDP {
    static boolean t[][]=new boolean[100][100];
    public static boolean subSumDP(int []arr,int sum,int size){
       if(sum==0&&size-1>0) return t[sum][size]=true;
      if(sum>0&&size-1==0) return t[sum][size]= false;
      if(sum>=arr[size-1]){
          return t[sum][size]=subSumDP(arr,sum-arr[size-1],size-1)||subSumDP(arr,sum,size-1);
      }else return t[sum][size]=subSumDP(arr,sum,size-1);
        
        
        
    }
}
