/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n_aryTree;

import n_aryTree.NTree.Node;

/**
 *
 * @author g
 */
public class UseNTree {
    public static void main(String[] args) {
       
       NTree.Node root = new NTree.Node(10); 
    (root.child).add(new Node(2)); 
    (root.child).add(new Node(34)); 
    (root.child).add(new Node(56)); 
    (root.child).add(new Node(100)); 
    (root.child.get(0).child).add(new Node(77)); 
    (root.child.get(0).child).add(new Node(88)); 
    (root.child.get(2).child).add(new Node(1)); 
    (root.child.get(3).child).add(new Node(7)); 
    (root.child.get(3).child).add(new Node(8)); 
    (root.child.get(3).child).add(new Node(9)); 
        System.out.println(NTree.depthFirstSearch(root)); 
        
    }
}
