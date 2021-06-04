/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
package DsaQuestions;

import java.util.Arrays;

/**
 *
 * @author g
 */
public class SortColors {
    //Counting sort
       public static int[] sortColors(int[] nums) {
           int red=0,white=0,blue=0;
       for(int i=0;i<nums.length;i++){
           switch(nums[i]){
               case 0: red++; break;
               case 1: white++;break;
               case 2: blue++;break;
           }
       }
           System.out.println("red"+red+",white="+white+",blue="+blue);
           int i=0;
       while(i<nums.length){
           while(red-->0){
               nums[i]=0;
               i++;
           }
           while(white-->0){
               nums[i]=1;
               i++;
           }
           while(blue-->0){
               nums[i]=2;
               i++;
           }
       }
       return nums;
    }
       public static int[] dutchFlag(int nums[]){
       int low=0,mid=0,high=nums.length-1,temp=0;
       while(high>=mid){
           switch(nums[mid]){
               case 0://swap a[mid] pointer with a[low] pointer increase low and mid by 1
                   temp=nums[mid];
                   nums[mid]=nums[low];
                   nums[low]=temp;
                   mid++;low++;
                   break;
               case 1:mid++;
                   break;
               case 2:
                   temp=nums[mid];
                   nums[mid]=nums[high];
                   nums[high]=temp;
                   high--;
                   break;
               
           }
           
           
           
       }
       return nums;
       
       }
    
    
    
    public static void main(String[] args) {
        
        int arr[]={2,0,2,1,1,0};
       
        System.out.println(Arrays.toString(dutchFlag(arr)));

        
    }
    
    
}
