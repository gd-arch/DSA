//Level order traversal
package BreadthFirstSearchTree;

import java.util.LinkedList;
import java.util.Queue;


public class BFS {
    Queue <Node> q=new LinkedList<>();
   class Node{
       Node left,right;
       int data;
       Node(int data){
           this.data=data;
       }
   }
   void bfs(Node root){
       if(root==null) return;
       q.add(root);
      while(!q.isEmpty()){
          Node temp=q.poll();
          System.out.println(temp.data+" => ");
          //Explore the removed vertex
          if(temp.left!=null) q.add(temp.left);
                    if(temp.right!=null) q.add(temp.right);

                    
      }
       
       
   }
   
   
   
}
