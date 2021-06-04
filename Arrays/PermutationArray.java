/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author g
 */
public class PermutationArray {
    
   static void swap(List<Integer> currentSequence, int i, int right){
      
        Collections.swap(currentSequence, i, right);
      
    }
   static void permute(List<Integer> currentSequence,int left,int right,List<List<Integer>> listOfSequences){
       
       if(left==right){
           List<Integer> newSequence=new ArrayList<>();
           for(int i:currentSequence){
               newSequence.add(i);
           }
           listOfSequences.add(newSequence);
           
            return;
            
        }
       for(int i=left;i<=right;i++){
           
           
       swap(currentSequence,left,i);
       //Recursive method to find all permutations
       //left-1 represent the position which remains fixed while left element is   swapped with other elements
       permute(currentSequence,left+1,right,listOfSequences);
       //BackTracking
       swap(currentSequence,left,i);
       }
    }
    public static void main(String[] args) {
        
        Integer []arr={1,2,3,5};
        List<Integer> time=Arrays.asList(arr);
        List<List<Integer>> listOfSequences = new ArrayList<>() ;
        permute(time,0,time.size()-1,listOfSequences);
       for(List <Integer>sequence:listOfSequences){
           for(Integer e:sequence){
               System.out.print(" "+e);
           }System.out.println("");
       }
}
}