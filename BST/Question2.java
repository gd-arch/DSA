/*
 Branch sum
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
    /   / \
11  13  4
 /  \        \
7   2      1
return list with all branch sums
 */
package BST;

import BST.BinarySearchTree.Node;
import java.util.ArrayList;

/**
 *
 * @author g
 */
public class Question2 {
  static ArrayList <Integer> arr=new ArrayList<>();
    static ArrayList<Integer> branchSum(Node root,int sum){
     if(root!=null){
       
         sum=root.key+sum;
           if(root.left==null&&root.right==null)   arr.add(sum);
         branchSum(root.left,sum);
         branchSum(root.right,sum);
        
     }
      
        return arr;
        
    }
}
