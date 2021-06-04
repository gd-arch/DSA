/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

import java.util.ArrayList;

/**
 *
 * @author g
 */
public class UseBST {
    public static void main(String[] args) {
            BinarySearchTree tree = new BinarySearchTree(); 
  
        /* Let us create following BST 
              50 
             /     \ 
          30      70 
         /  \    /     \    
   20   40  60   80 */
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
     /*solution of Question 1=
        
       int closest=Question1.maxDiff(tree.getRoot(), 78);
        System.out.println("Closest ="+closest);
*/
     ArrayList <Integer> arr=new ArrayList<>();
     arr=Question2.branchSum(tree.getRoot(), 0);
     for(Integer i:arr){
         System.out.println(i);
     }
     
     
     
    }
  
    
    
}
