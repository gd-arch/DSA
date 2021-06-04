/*
 Find the closest value in BST to  a given value ?

ANS=

complexity =similar to any insertion and deletion operation that is O(logn) in average case
worst time complexity=for one sided tree is o(n)
space complexity=o(logn)avg case
space complexity=o(n)worst  case
It is because of using recursion create stacks for each operation

summary =we start by thinking the difference between the node value and the key provided and comparing it with the 
difference between previous closest node to this node and key and then basiscally we apply search procedure and try 
to update closest accordingly

 */



package BST;

import BST.BinarySearchTree.Node;



public class Question1 {
   static  int closest=Integer.MAX_VALUE;
    static int maxDiff(Node  root, int k) 
    { if(root!=null){
      if(Math.abs(root.key-k)<Math.abs(closest-k))
          closest=root.key;
      if(root.key>k) maxDiff(root.left,k);
      else if(root.key<k)
          maxDiff(root.right,k);
   
    }
    return closest;
    } 

   
 
}
