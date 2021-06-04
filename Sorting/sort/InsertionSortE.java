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
public class InsertionSortE {
    public void sort(int arr[]){
         for(int unsortedIndex=1;unsortedIndex<arr.length;unsortedIndex++){
              int temp=arr[unsortedIndex];
         
              //find the position of first unsorted index
              int i;
              for( i=unsortedIndex;i>0&&arr[i-1]>temp;i--){
                  arr[i]=arr[i-1];
              }
              
              
              
              //insert the value at unsorted index to its correct position in sorted array
              arr[i]=temp;
              
             
             
             
         }
         
         
         
     }
}
