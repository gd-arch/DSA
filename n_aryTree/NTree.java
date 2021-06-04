/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n_aryTree;

import java.util.ArrayList;

/**
 *
 * @author g
 */
public class NTree {
    Node root;
   static ArrayList<Integer> order;
    static class Node{

        public Node(int key) {
            this.key = key;
        }
        int key;
        ArrayList<Node> child=new ArrayList<>();
    }
   static ArrayList<Integer> depthFirstSearch(Node root){
       if(root==null) return order ;
         order.add(root.key);
         for(Node n:root.child){
             depthFirstSearch(n);
             System.out.println(n);
         }
    
        return order;
        
    }
    
    
}
