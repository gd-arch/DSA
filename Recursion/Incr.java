/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PepCode.src.Recursion;

import java.util.Scanner;

/**
 *
 * @author g
 */
public class Incr {
   static void incr(int n){
        //Recursion
        //High Lvl Thinking
        //Expectation=incr(n)=> print=>1,2,3,4,...n
        //Faith=>incr(n-1)=> print=>1,2,3,4...n-1
        //meet Expectatation via faith=> incr(n)=incr(n-1)+ print(n)
        //Low Lvl Thinking
        //DryStack Test=>stack has two path upward and downward
        //BaseCase Determination
        
        if(n==0)return;
        incr(n-1);
        System.out.println(n);
        
        
    }
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       incr(n);
    }
}
