import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class MaxSumSubtree {
    private static class Node {
        int data;
        ArrayList< Node > children = new ArrayList < > ();
    }
    static class Pair {
        int val1, val2;
        Pair(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
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


    static Pair maxPair;
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
        maxPair = new Pair(root.data, Integer.MIN_VALUE);
        maxSubNode(root);
        System.out.println(maxPair.val1 + "@" + maxPair.val2);

    }

    static Pair maxSubNode(Node node) {
        int sum = 0;
        for (Node child: node.children) {
            Pair p = maxSubNode(child);
            sum += p.val2;
        }
        int currentNodeVal = sum + node.data;
        if (currentNodeVal > maxPair.val2) {
            maxPair.val2 = currentNodeVal;
            maxPair.val1 = node.data;
        }
        return new Pair(node.data, currentNodeVal);

    }




}
