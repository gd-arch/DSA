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
public class InsertionSort {
     public void sort(int arr[]){
         for(int i=1;i<arr.length;i++){
              int temp=arr[i];
             for(int j=i-1;j>=-1;j--){
                if(j==-1){
                   arr[j+1]=temp;
                    break; 
                }
                if(temp<arr[j]){
                    arr[j+1]=arr[j];
                   
                }else if(temp>arr[j]) {
                    arr[j+1]=temp;
                    break;
                }
               
                 
             }
             
             
             
         }
         
         
         
     }
}
