import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class DiameterOfTree {
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
    static int diameter(Node node){
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE;
        if(node.children.size()<2) return 0;
        for(Node child:node.children){
            int h=1+height(child);
            if(h>=max1){
                max2=max1;
                max1=h;

            }else if(max2<h){
                max2=h;
            }
        }
        return max1+max2;
    }
    static int height(Node node){
        int max=Integer.MIN_VALUE;
        if(node.children.size()==0)return 0;
        for(Node child:node.children){
            max=Math.max(max,height(child));

        }
        return max+1;

    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here
        System.out.print(diameter(root));
    }


}
