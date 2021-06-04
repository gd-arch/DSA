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
class MergeSort {
    //merge two sorted array to get final result
    int[] mergeSort(int arr[],int lo,int hi){
       if(lo == hi){
      int[] bans = new int[1];
      bans[0] = arr[lo];
      return bans;
    }
    int mid = (lo + hi) / 2;
    int[] lsa = mergeSort(arr,lo,mid);
    int[] rsa = mergeSort(arr,mid + 1,hi);
    int[] ans = merge(lsa,rsa);
    return ans;
        //Merge to sorted array
        
    }
    int[] merge(int a[],int b[]){
        
    int i = 0, j =0, k = 0;
    int[] ans = new int[a.length + b.length];
    while(i < a.length && j < b.length){
        if(a[i] <= b[j]){
          ans[k] = a[i];
          i++;
          k++;
        }else{
          ans[k] = b[j];
          j++;
          k++;
        }
    }

    while(i < a.length){
      ans[k] = a[i];
      k++;
      i++;
    }

    while(j < b.length){
      ans[k] = b[j];
      k++;
      j++;
    }
    
    return ans;
  }
}
