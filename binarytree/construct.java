import java.util.ArrayDeque;
import java.util.Deque;

public class construct {
    public static void main(String[] args) {
        Integer[] arr ={50,25,12,null,null,37,30,null,null,null,null};
        Deque <Pair> stack=new ArrayDeque<>();
        TreeNode root=new TreeNode(arr[0]);
        Pair rootpair=new Pair(root,1);
        stack.push(rootpair);
        int idx=0;
        while (!stack.isEmpty()){
            Pair top=stack.peek();
            if(top.state==1){
                idx++;
                if(arr[idx]!=null){
                    top.node.left= new TreeNode(arr[idx]);
                    stack.push(new Pair(top.node.left,1));

                }
                top.state++;
            }else if(top.state==2){
                idx++;
                if(arr[idx]!=null){

                    top.node.right= new TreeNode(arr[idx]);
                stack.push(new Pair(top.node.right,1));
              }
                top.state++;
            }else if (top.state==3){
                stack.pop();
            }
        }
    }
    static class  Pair{
        TreeNode node;
        int state;
        //1=>push the left node after accesing it from array and incr.the state of top
        //2=>push the right node after accesing it from array and incr.the state of top
        //3->pop the top

        public Pair(TreeNode root, int state) {
            this.node=root;
            this.state=state;
        }
    }


}
