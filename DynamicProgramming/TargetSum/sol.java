/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming.TargetSum;

/**
 *
 * @author g
 */
public class sol {
    
    
    
     public static int targetSum(int arr[],int size,int k){
           int s=0;
         for(int i:arr){
             s+=Math.abs(i);
         }
         //subsetsum with a given difference k
         //s1-s2=difference which can be considered as that sum which is provided as input in target sum here k
         int sum=(s+k)/2;
         
         
        int t[][]=new int[size+1][sum+1];
        //initialization through base cases
        for(int i=1;i<sum;i++){
            t[0][i]=0;
        }
        for(int j=0;j<size;j++){
            t[j][0]=1;
        }
       // minimum=range-2s1=s1-s2
         for(int i=1;i<=size;i++){
             for(int j=1;j<=sum;j++){
                 if(Math.abs(arr[i-1])<=j){
                     t[i][j]=t[i-1][j-Math.abs(arr[i-1])]+t[i-1][j];
                 }
                 else  t[i][j]= t[i-1][j];
             }
             
             
         }
       
          return t[size][k];
                
         
         
         
    }
    public static void main(String[] args) {
        int arr[] =  {-3, 1, 3, 5};
        int k = 6;
       int sol= targetSum(arr,arr.length,k);
        System.out.println("Solution="+sol);
    }
}
