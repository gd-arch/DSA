/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting.sort;

/**
 At each swap the maximum element is found and replaced at last position of array
 */
public class SelectSortEasy {
    public void sort(int arr[]){
    int maxIndex;
for(int i=arr.length-1;i>=0;i--){
    maxIndex=i;
    for(int j=0;j<=i;j++){
        
       if(arr[maxIndex]<arr[j])maxIndex =j;
      
                
            
    }
               int temp=arr[maxIndex];
                arr[maxIndex]=arr[i];
                arr[i]=temp;
}
}
}
