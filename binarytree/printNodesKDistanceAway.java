import java.util.ArrayList;

public class printNodesKDistanceAway {
    public static void main(String[] args) {

    }
    static  void printKDistanceAwayFrom(Node root,int data,int k){
        ArrayList<Node> path=nodeToRootPath(root,data);
        Node blocker = null;
        for(int i=0;i<path.size();i++){
            kLevelDown(path.get(i),k-i,blocker);

            blocker=path.get(i);
        }

    }

    private static void kLevelDown(Node node, int level, Node blocker) {
        if(node==null||node==blocker||level<0) return;
        if(level==0) System.out.println(node.data);
        kLevelDown(node.left,level-1,blocker);
        kLevelDown(node.right,level-1,blocker);

    }

    private static ArrayList<Node> nodeToRootPath(Node node, int data) {
        if(node==null) return new ArrayList<Node>();;
        if(node.data==data){
            ArrayList<Node> al=new ArrayList<Node>();
            al.add(node);
            return al;
        }
        ArrayList<Node> left=nodeToRootPath(node.left,data);
        ArrayList<Node> right=nodeToRootPath(node.right,data);
        if(left.size()!=0) {
            left.add(node);
            return left;
        }
         if(right.size()!=0) {
            right.add(node);
            return right;
        }
         return new ArrayList<Node>();

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
}
