/*
Given an integer array, find number of ways to calculate a target number using only array elements and addition or subtraction operator.
Input: arr[] = {-3, 1, 3, 5}, k = 6
Output: 4
Explanation - 
- (-3) + (3)
+ (1) + (5)
+ (-3) + (1) + (3) + (5)
- (-3) + (1) - (3) + (5)

Input: arr[] = {2, 3, -4, 4}, k = 5
Output: 6
Explanation - 
+ (2) + (3)
+ (2) + (3) + (4) + (-4)
+ (2) + (3) - (4) - (-4)
- (3) + (4) - (-4)
- (2) + (3) + (4)
- (2) + (3) - (-4)
 */
package DynamicProgramming.TargetSum;

/**
 *
 * @author g
 */
public class Solution {
    public static int targetSum(int arr[],int size,int k){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        boolean t[][]=new boolean[size+1][sum+1];
        //initialization through base cases
        for(int i=1;i<sum;i++){
            t[0][i]=false;
        }
        for(int j=0;j<size;j++){
            t[j][0]=true;
        }
       // minimum=range-2s1=s1-s2
         for(int i=1;i<=size;i++){
             for(int j=1;j<=sum;j++){
                 if(arr[i-1]<=j){
                     t[i][j]=t[i-1][j-arr[i-1]]||t[i-1][j];
                     
                 }
                 else  t[i][j]= t[i-1][j];
                  System.out.print("t["+i+"]["+j+"]="+t[i][j]);
             }
             System.out.println("");
             
             
         }int count=0;
         for(int i=sum;i>0;i--){
             
            if(t[size][i]==true){
                System.out.println("t["+size+"]["+i+"]="+t[size][i]);
                if(k==sum-2*i){
                    count++;
                }
            } 
             
             
         }
         return count;
         
         
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int k = 4;
       int sol= targetSum(arr,arr.length,k);
        System.out.println("Solution="+sol);
    }
}
