import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class levelOrderTraversal {

    private static class Node {
    int data;
    ArrayList< Node > children = new ArrayList < > ();
}

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack< >();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
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

    public static int size(Node node) {
        int s = 0;

        for (Node child: node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child: node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child: node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static void traversals(Node node) {
        System.out.println("Node Pre " + node.data);

        for (Node child: node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);
    }

    public static void levelOrder(Node node) {
        Queue< Node > q = new ArrayDeque< >();
        //Remove Print Add child
        q.add(node);
        while (q.size() > 0) {
            Node removedNode = q.remove();
            System.out.print(removedNode.data + " ");
            for (Node child: removedNode.children) {
                q.add(child);
            }
        }
        System.out.print(".");

    }
    //MQ CQ
    //delimiter adding separator in main queue
    //Count no of elements in each level and then use a newline
    //Pair class
    public static void levelOrder2(Node node){
        //RPA
        int level=1;

        Queue<Node> q = new ArrayDeque< >();
        //Remove Print Add child
        q.add(node);
        while (q.size() > 0) {
            int size=q.size();
            for(int i=0;i<size;i++){
            Node removedNode = q.remove();
            System.out.print(removedNode.data + " ");
            for (Node child: removedNode.children) {
                q.add(child);
            }

            }
            System.out.println();

        }


    }

    public static void levelOrderLinewise(Node node) {
        Queue < Node > mq = new ArrayDeque < > ();
        Queue < Node > cq = new ArrayDeque < > ();
        mq.add(node);
        //Rpa
        while (mq.size() > 0) {
            Node removedNode = mq.remove();

            //Print the node data of removed node
            System.out.print(removedNode.data + " ");

            //push all the child elements in the cq
            for (Node child: removedNode.children) {
                cq.add(child);
            }


            // if mq is empty just transfer all the element from cq to mq
            if (mq.size() == 0) {
                //level changed
                System.out.println();
                mq = cq;
                cq = new ArrayDeque < Node > ();

            }
        }
    }

    public static boolean find(Node node, int data) {
        if(node.data==data) return true;
        boolean found=false;
        for(int i=0;i<node.children.size()&&!found;i++){
            Node child=node.children.get(i);
            found= find(child,data);
        }
        return found;

    }
}
