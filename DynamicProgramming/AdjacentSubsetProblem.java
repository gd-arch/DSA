/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Arrays;

/**
 *
 * @author g
 */
public class AdjacentSubsetProblem {
    static int t[]=new int[100];
    public static int subsum(int arr[],int size){
        //Base case 
        if(size<=0) return 0;
        //return value if already present in t [ ] to reduce access time 
        if(t[size]!=0)return t[size];
        
       //subsum(arr,size-2)+arr[size-1] when last element of arr is chosen
       //subsum(arr,size-1) when last element of array is not chosen
      
       int val= t[size]=Math.max(subsum(arr,size-2)+arr[size-1], subsum(arr,size-1));
       
       return val;
    }
    
    public static void main(String[] args) {
     Arrays.fill(t, 0);
        int arr[]={1,2,3};
        System.out.println("Ans to the adjacent subset problem is :"+subsum(arr,arr.length));
        
        
    }
}
