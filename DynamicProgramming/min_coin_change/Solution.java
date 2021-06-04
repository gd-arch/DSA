/*
Given a value V. You have to make change for V cents, given that you have infinite supply of each of C{ C1, C2, .. , Cm} valued coins. Find the minimum number of coins to make the change.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is V and N, V is the value of cents and N is the number of coins. The second line of each test case contains N input C[i], value of available coins.

Output:
Print the minimum number of coins to make the change, if not possible print "-1".

Constraints:
1 ≤ T ≤ 100
1 ≤ V ≤ 106
1 ≤ N ≤ 106
1 ≤ C[i] ≤ 106

Example:
Input:
1
7 2
2 1

Output:
4

Explanation :
Testcase 1: We can use coin with value 2 three times, and coin with value 1 one times to change a total of 7.nd open the template in the editor.
 */
package DynamicProgramming.min_coin_change;

import java.util.Scanner;

//solution 2=
//int arr[]=new  int[capacity+1];
//arr[0]=0;
//for(int i=1;i<capacity+1;i++){
//    arr[i]=Integer.MAX_VALUE-1;
//}
//for(int i:val){
//    for(int j=1;j<capacity+1;j++){
//        if(i<=j)
//            arr[j]=Math.min(arr[j], 1+arr[j-i]);
//        
//    }
//  
//    
//}
//
//  if(arr[capacity]==Integer.MAX_VALUE-1)
//  return -1;
//  else return arr[capacity];

public class Solution {
    
    public static int minCoin(int val[],int capacity,int size){
        int arr[][]=new int [size+1][capacity+1];
        arr[size][capacity]=-1;
        
        for(int i=1;i<capacity+1;i++){
            arr[0][i]=Integer.MAX_VALUE-1;
        }
         for(int i=1;i<capacity+1;i++){
         if(i%val[0]==0){
             arr[1][i]=i/val[0];
         }
         else arr[1][i]=Integer.MAX_VALUE-1;
        }
        
         for(int i=2;i<size+1;i++){
            for(int j=1;j<capacity+1;j++){
           if(val[i-1]<=j){
             arr[i][j]=Math.min(arr[i-1][j], 1+arr[i][j-val[i-1]]);
           }
         
              else  arr[i][j]= arr[i-1][j];
                
        }
        }
         
          
        return arr[size][capacity];
    }
    public static void main(String[] args) {
                 Scanner s = new Scanner(System.in);
                int test= s.nextInt();
                int n=0;
while(test--!=0){
   
    int v=s.nextInt(); 
    n=s.nextInt();
      int a[] = new int[n];
        for(int i = 0; i < n; i++)

        {

            a[i] = s.nextInt();
           

        }
     System.out.println(minCoin(a,v,n));
        
        
        
    }
    
}
}