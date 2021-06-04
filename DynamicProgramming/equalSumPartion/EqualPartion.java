/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming.equalSumPartion;

import static SubsetSum.SubSum.subsetsum;


public class EqualPartion {

    public static boolean equalPartition(int []arr,int size){
   int sum=0;
        for(int i=0;i<arr.length;i++){
        sum=sum+arr[i];
    }
        if(sum%2==0) return subsetsum(arr,sum/2,size);
        else return false;
        
        
    }
    
    public static void main(String[] args) {
            int arr[]={2,3,8,7,10};
    
        boolean b=equalPartition(arr,arr.length);
        System.out.println("Sol="+b);
        
        
    }
    
    
}
