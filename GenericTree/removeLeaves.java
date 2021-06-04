import java.util.ArrayList;

public class removeLeaves {
    private static class Node {
        int data;
        ArrayList< Node > children = new ArrayList < > ();
    }
    public static void removeLeaves(Node node) {
        //pre order because post order will delete some not leaf node also
        //Iterating from last because removing from first will cause error
        for(int i=node.children.size()-1;i>=0;i--){
            Node child=node.children.get(i);
            if(child.children.size()==0){
                node.children.remove(child);
            }
        }
        for(Node n:node .children){
            removeLeaves(n);
        }
    }
}
