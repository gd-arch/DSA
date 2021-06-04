/*
 Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}  

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20} 
Input:
First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.

Output:
For each test case, print (X + Y) space separated integer representing the merged array.

Constraints:
1 <= T <= 100
1 <= X, Y <= 5*104
0 <= arr1i, arr2i <= 109

Example:
Input:
2
4 5
1 3 5 7
0 2 6 8 9
2 3
10 12
5 18 20

Output:
0 1 2 3 5 6 7 8 9
5 10 12 18 20

Explanation:
Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.

 
 */

package Arrays;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author g
 */
public class BetterSortedArrayCombination {
    
  private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 	{
        
        
        
        
        try{
  int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int a[]=new int[n];
        int b[]=new int[m];
           for(int i=0;i<n;i++){
               a[i]=scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
           }
     for(int i=0;i<m;i++){
               b[i]=scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
           }
           //Gap Method 
           int l=a.length+b.length;
         int gap=(l)/2;
         while(gap>0){
             
            for(int i=0;i+gap<l;i++) {
             
             
             
             gap/=2;
         }
           
     
           
           
           
     
     
       
          
            //print a[] and b[]
             for (int x : a) {
                System.out.print(x + " ");}  
            
          
             
           
for (int x : b) {
                System.out.print(x + " ");}  

      System.out.println("");  
    
    }  scanner.close();
           }
        }catch(Exception e){
               System.out.println("Exception occured:"+e);   
                  }
    }
  
    
  
    void swap(int arr[],int index1,int index2){
        
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
        
    }
}