import java.util.ArrayDeque;
import java.util.Deque;

public class IterativeTraversalBTree {
    public static void main(String[] args) {

    }
    public static void iterativePrePostInTraversal(Node node) {
        Deque <Pair> stack=new ArrayDeque<>();
        stack.push(new Pair(node,0));
        String pre="",in="",post="";
        while (!stack.isEmpty()){
            Pair top=stack.peek();
            if(top.state==0){
                //pre
                pre+=(top.node.data+" ");
                top.state++;
            }
            else if(top.state==3){
                //post
                post+=(top.node.data+" ");
                stack.pop();
            }
            else{
                //in
                if(top.state==1){
                   //left element
                    Node child=top.node.left;
                    if (child!=null) stack.push(new Pair(child,0));
                }
                else if(top.state==2){
                    //right element
                    in+=(top.node.data+" ");
                    Node child=top.node.right;
                   if (child!=null) stack.push(new Pair(child,0));
                }
                top.state++;
            }

        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}
