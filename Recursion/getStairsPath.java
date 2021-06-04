package PepCode.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author g
 */
public class getStairsPath {
 
    public static void main(String[] args) throws Exception {
 Scanner sc=new Scanner(System.in);
        int str=sc.nextInt();
        ArrayList<String> al=getStairPaths(str);
        System.out.print(al);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0) return new ArrayList<String>(Arrays.asList(""));
        if(n<0) return new ArrayList <String> ();
        

      ArrayList <String> p1=getStairPaths(n-1);
       ArrayList <String> p2=getStairPaths(n-2);
        ArrayList <String> p3=getStairPaths(n-3);
        
        ArrayList <String> paths=new ArrayList<>();
        
        for(String x:p1){
            paths.add(1+x);
        }
        for(String y:p2){
            paths.add(2+y);
        }
        for(String z:p3){
            paths.add(3+z);
        }
        return paths;
      
      
    }


    
//Expectation ->getStairpaths(n) will give all path possible to reach ground
//since we have three options i.e we can either  climb 1 step, 2 steps or 3 steps in one move.
//we can have three faiths i.e 
//faith1=> getStairsPaths(n-1)->will give all paths by moving 1 step down in next step
//faith2=> getStairsPaths(n-2)->will give all paths by moving 2 step down in next step
//faith3=> getStairsPaths(n-3)->will give all paths by moving 3 step down in next step
//Expectaion +faith=>
//getStairsPath(n)= p1=getStairsPath(n-1)+p2=getStairsPath(n-2)+p3=getStairsPath(n-3)+
//Now add 1 in all elements of path 1 representing they climbed down via path 1
//similarly for path 2 and path 3
//return the paths list
      
      
      
    

}