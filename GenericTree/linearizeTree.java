import java.util.ArrayList;

public class linearizeTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList < > ();
    }
    public static void linearize(Node node) {
        //expectation that child node can be linearized on the application of linearize function
        for(Node child:node.children){
            linearize(child);
        }
        //traverse to the last  node of the child
        for(int i=node.children.size()-2;i>=0;i--){
            Node ptr=node.children.get(i);
            while(ptr.children.size()!=0){
                ptr=ptr.children.get(0);
            }
            //connect leaf node with the next child in node children list and remove that elemenet
            Node link=node.children.get(i+1);
            ptr.children .add(link);
            node.children.remove(link);
        }

    }
    public static Node linearize2(Node node){
        //get the last element
        if (node.children.size()==0){
            return null;
        }
        Node last=node.children.get(node.children.size()-1);
        //linearize =linearize node +gives tail of the node
        int i=0;
        Node lastTail= linearize2(last);
        while(node.children.size()>1){
             last=node.children.remove(node.children.size()-1);
             Node last2ndTail= linearize2(node.children.get(node.children.size()-1));
             last2ndTail.children.add(last);
        }
        return lastTail;
    }
}
