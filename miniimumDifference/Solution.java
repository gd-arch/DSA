/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniimumDifference;

import java.util.Arrays;

/**
 *
 * @author g
 */
public class Solution {
    public static void main(String[] args) {
        int arr1[]={1,7,14,21};
        int arr2[]={45,90,135};
        Arrays.sort(arr2);
        Arrays.sort(arr1);
        int i=0,j=0;
        int minimum=Integer.MAX_VALUE;
        int diff=Integer.MAX_VALUE;
        System.out.println("1.");
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<arr2[j]){
                diff=arr2[j]-arr1[i];
                i++;
            }
            else if(arr1[i]>arr2[j]){
                diff=arr1[i]-arr2[j];
                j++;
            }
            else {minimum=0;
            break;
           }
            if(minimum>diff){
                minimum=diff;
            }
            
        }
        System.out.println("Minimum difference is "+minimum);
        
        
        
        
        
        
    }
}
