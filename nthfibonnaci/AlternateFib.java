/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nthfibonnaci;

import java.util.Scanner;

/**
 *
 * @author g
 */
public class AlternateFib {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
       int a=0;
        int b=1;
        if(n==1)System.out.println(0);
           if(n==2)System.out.println(1);
        int c=0;
        int no=2;
        if(n>2){
    do{
            c=a+b;
          
            a=b;
            b=c;
    }  while(++no<=n);
           System.out.println(c);   
        }
        }
        
        
    }
    
    
    

