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
public class UseSort {
    public static void main(String[] args) {
         int arr[]={99,-6,7,98,-23,78,70};
       
//       BubbleSort bs=new BubbleSort();     
//       bs.sort(arr);
 


    //  InsertionSortE ss=new InsertionSortE();
    MergeSort ss=new MergeSort();
  int a[]=    ss.  mergeSort(arr,0,arr.length-1);
            for(int x:a) System.out.println(" "+x);
        
    }
}
