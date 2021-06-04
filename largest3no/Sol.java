/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largest3no;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author g
 */
public class Sol {
    public static void greatestthree(int arr[],int max[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<max.length;j++){
                if(arr[i]>max[j]){
              shiftFrom(max,j);
                    max[j]=arr[i];
                    break;
                    
                }
            }
        }
    }
    public static void shiftFrom(int []arr,int begin){
       int l=arr.length;
      
        for(int i=l-1;i>begin;i--){
           arr[i]= arr[i-1];
        }
            for(int k:arr)System.out.print("    "+k);
            System.out.println("");
    }
    public static void main(String[] args) {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int max[]={0,0,0};
                int arr[]={3,45,1,3,66,3,77,88};
                greatestthree(arr,max);
                System.out.println("max=");
                for(int i:max)System.out.println(i);

        
        
        
        
    }
}
