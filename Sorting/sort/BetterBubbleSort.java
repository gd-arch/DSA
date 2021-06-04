/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting.sort;

/**
 *
 * @author g
 */
public class BetterBubbleSort {
    void sort(int arr[]){
       
       
       for(int gap=arr.length/2;gap>0;gap/=2){
          
       for(int i=gap;i<arr.length;i++){
           
          int j=i;
           //compare with gap index value with arr[gap-j]
           if(arr[i-gap]>arr[i]){
                int temp=arr[i-gap];
                arr[i-gap]=arr[i];
                arr[i]=temp;
           }
           
       }
       }
        
    }
}
