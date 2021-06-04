/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KnapsackProblem;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g
 */
public class Knapsack {
    static int[][] t=new int[100][100];
   


    public static int knapsack(int wt[], int val[], int capacity, int size) {
        //base cases on values which are changing
        if (size == 0 || capacity == 0) {
            return 0;
        }
        //recovery condition 
       
        if(t[capacity][size]!=0)return t[capacity][size];
       
        //trial and error on  selection condition and rejection condition if we select
        if (capacity >= wt[size - 1]) {
            return t[capacity][size]=Math.max(val[size - 1] + knapsack(wt, val, capacity - wt[size - 1], size - 1), knapsack(wt, val, capacity, size - 1));
        }
        //rejection condition if we dont select
        else {
            return t[capacity][size]=knapsack(wt, val, capacity, size - 1);
        }
     
    }
    
    
    
    public static void main(String[] args) {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in) );
        int t=1,n=0,W;
        int []val =new int[1002];
        int []w = new int[1002];
        try {
            t = Integer.parseInt(bf.readLine());
            while(t!=0){
                n=bf.read();//no of items
              W= bf.read();// W, the maximum capacity of the knapsack.
              for(int i=0;i<n;i++){
               val[i]= bf.read();  

              }// values of the N items
               for(int i=0;i<n;i++){
               w[i]= bf.read();  

              } //weights of the corresponding items.
                System.out.println(knapsack( w,  val, W,  n));
               
               
               
                t--;
            }
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Knapsack.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(t);
    }
    
    
    
}
