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
public class BubbleSort {
    public void sort(int arr[]){
        for(int j=0;j<arr.length-1;j++)
        for(int i=0;i<arr.length-1-j;i++){
            if(arr[i]>arr[i+1]) {
                int temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }

    }
 
}
