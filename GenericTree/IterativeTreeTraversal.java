import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class IterativeTreeTraversal {
    public static void main(String[] args) {
        Stack<Pair> st= new Stack<Pair>();
        String pre="",post="";
        while(st.size()>0){
            Pair top=st.peek();
            //pre order node is being visited
            if(top.state==-1){
               pre+=top.node.data+" ";
                top.state++;
            }else if(top.state==top.node.children.size()){
                //post order
                //node completely traversed
                post+=top.node.data+" ";
                st.pop();

            }
            else {
                //we are on the node
                //for dfs try to go deeper by traversing the children of current node
                st.push(new Pair(top.node.children.get(top.state),-1));
                top.state++;
            }


        }
        System.out.println(pre);
        System.out.println(post);


    }


    private static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node=node;
            this.state=state;
        }
    }
}
