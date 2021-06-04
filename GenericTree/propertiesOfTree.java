public class propertiesOfTree {
    static int size,height,max,min;

    void multisolver(Node node,int depth){
        size++;
        max=Math.max(max,node.data);
        min=Math.min(min,node.data);
        height=Math.max(height,depth);

       //height= depth of the deepest node
        for(Node child:node.children){

            multisolver(child,depth+1);
        }
    }
    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorAndSuccessor(Node node, int data) {
        if(state==0){
            if(data==node.data){
                state=1;

            }
            else {
                predecessor=node;
            }
        }else if(state==1){
            state=2;
            successor=node;
        }
        for(Node child:node.children){
            predecessorAndSuccessor(child,data);
        }
    }

}
