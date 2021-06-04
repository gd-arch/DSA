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
public class ShellSort {
     void sort(int arr[]){
       
       
       for(int gap=arr.length/2;gap>0;gap/=2){
          
       for(int i=gap;i<arr.length;i++){
           
         int element=arr[i];
           //compare with gap index value with arr[j-gap]
        int j;
        //finding the j(index) where the element should be inserted
        //considering each sublist is sorted
           for(  j=i;j-gap>=0&&(arr[j-gap]>element);j-=gap){
             
                 arr[j]=arr[j-gap];
             
         }
           //place element at its correct position
           arr[j]=element;
       }
       }
        
    }
}
