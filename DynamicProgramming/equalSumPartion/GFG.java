/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming.equalSumPartion;

/**
 *
 * @author g
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class GFG {
    public static boolean equalPartition(int []arr,int size){
   int sum=0;
        for(int i=0;i<arr.length;i++){
        sum=sum+arr[i];
    }
        if(sum%2==0) return subSumDP(arr,sum/2,size);
        else return false;
        
        
    }
    static boolean t[][]=new boolean[100][100];
    public static boolean subSumDP(int []arr,int sum,int size){
       if(sum==0&&size-1>0) return t[sum][size]=true;
      if(sum>0&&size-1==0) return t[sum][size]= false;
      if(sum>=arr[size-1]){
          return t[sum][size]=subSumDP(arr,sum-arr[size-1],size-1)||subSumDP(arr,sum,size-1);
      }else return t[sum][size]=subSumDP(arr,sum,size-1);
        
    }
//    public static boolean subsetsum(int arr[],int sum,int n){
//        
//      //size of array  
//      //base condition & min valid value returned by method
//      if(sum==0&&n-1>0) return true;
//      if(sum>0&&n-1==0)return false;
//      if(n-1>=0)
//  if(sum>=arr[n-1]){
//      return subsetsum(arr,sum-arr[n-1],n-1)||subsetsum(arr,sum,n-1);
//  }
//  else return subsetsum(arr,sum,n-1);
//      else return false;   
//        
//    }
	public static void main (String[] args) {
	 Scanner s = new Scanner(System.in);
                int test= s.nextInt();
                int n=0;
while(test--!=0){
    n=s.nextInt();
      int a[] = new int[n];
        for(int i = 0; i < n; i++)

        {

            a[i] = s.nextInt();

        }
    
	System.out.println(equalPartition(a,n));
	
	
	}
        }
}
