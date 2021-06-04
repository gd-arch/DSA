/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveElementToTheEnd;

import java.util.Scanner;

/**
 *
 * @author g
 */
public class Solution {
    public static void main(String[] args) {
        int arr[]={25,1,22,3,2,33,33,2};
        System.out.println("input an element to move its occurence to end");
        Scanner st=new Scanner(System.in);
        int element=st.nextInt();
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element)count++;
        }
       
        for(int j=arr.length-1,i=j+1;j>=0&&i>0;j--){
            if(count==0)break;
            else {
                if(arr[j]!=element){
                    while(arr[i]!=element&&i>0){
                        i--;
                    }
                   arr[i]=arr[j];
                   arr[j]=element;
                }
                 count--;
            }
        
    }
        for(int x:arr)System.out.print(x+"\t");
        
        
    }
}
