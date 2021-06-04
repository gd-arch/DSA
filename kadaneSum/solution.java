/*leetcode
 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
package kadaneSum;

import static java.lang.Math.max;
import java.util.ArrayList;

/**
 *
 * @author g
 */
public class solution {
    public static void main(String[] args) {
        int arr[]={1,8,4,-6,3,-6,-6,8};
        //O(N3)
        int max=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
 int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                     max=Math.max(max,sum);
if (sum > max)
                max = sum;
                }
            }}
  
System.out.println("Maximum sum="+max);

//    sol 2
//O(N2)
        int max1=0;
        for(int i=0;i<arr.length;i++){
int sum1 = 0;
            for(int j=i;j<arr.length;j++){
 
              
                    sum1+=arr[j];
                     max1=Math.max(max1,sum1);

                
            }
        }
         System.out.println("Maximum sum="+max1);
         ArrayList<Integer> li=new ArrayList<>();

        
    }
}
