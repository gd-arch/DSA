import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class IteratorAndIterable  {
    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack< >();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                if(st.size()>0)
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static void main(String[] args) throws IOException {

        int[] arr ={10,20,-50,-1,60,-1,-1,30,70,-1,-80,110,-1,-120,-1,-1,90,-1,-1,40,-100,-1,-1,-1,-1};
//-1 represents null
        Node root=construct(arr);
        GenericTree gt=new GenericTree(root);

        Iterator <Integer>it =gt.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
        }

    }

class GenericTree implements Iterable<Integer>{
    Node root;
    GenericTree(Node root){
        this.root=root;
    }
    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it= new GenericTreeIterator(root);
        return it;
    }
}
class Pair{
    Node node;
    int state;
    Pair(Node node,int state){
        this.node=node;
        this.state=state;
    }
}
class GenericTreeIterator implements Iterator<Integer>{
Integer nextVal;
Stack<Pair> stack;
GenericTreeIterator(Node root){
    stack=new Stack<Pair>();
    Pair rootPair=new Pair(root,-1);
    stack.push(rootPair);
    next();
}
    @Override
    public boolean hasNext() {
        if (nextVal==null)return false;
        else return true;
    }

    @Override
    public Integer next() {
        Integer curVal=nextVal;
//        nextVal=null;
        //return prev nextVal and then set it to the next Val of the tree using iteration

        //Change nextVal to next possible value Here we will display the tree in preorder and if there is no value then return null
        //null is returned so tht if there is null then hasNext will return false and the loop will stop
        while (!stack.isEmpty()){
            Pair currentTopNode=stack.peek();
            //preorder
            if(currentTopNode.state==-1){
               //update nextVal for next iteration of for in loop
               nextVal=currentTopNode.state;
               //increment state value so that it can represent other states for the node
                currentTopNode.state++;
                break;
            }//postorder => generally deals with removing the node as it is already visited
            else if(currentTopNode.state==currentTopNode.node.children.size()){
                stack.pop();
            }else{
                //pushing the children of the current node
                //After child of a node is visited this will be again returned to the parent node to check
                // if there are more element that need to be visited
                //state is incremented for the current node telling the current node has already been pushed and the next time
                // this will run then it will push the next element
                stack.push(new Pair(currentTopNode.node.children.get(currentTopNode.state),-1));
                currentTopNode.state++;
            }



        }


        return curVal;
    }
}

