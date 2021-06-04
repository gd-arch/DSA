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
public class SelectionSort {
    
public void sort(int arr[]){
    int min=0;
for(int i=0;i<arr.length;i++){
    min=i;
    for(int j=i+1;j<arr.length-1;j++){
        
       if(arr[min]>arr[j])min =j;
      
                
            
    }
               int temp=arr[min];
                arr[min]=arr[i];
                arr[i]=temp;
}
}
}
