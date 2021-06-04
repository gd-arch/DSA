public class Add2LL {
    public static class Node {
        int data;
        Node next;
    }
    public static class LinkedList {

        Node head;
        Node tail;
        int size;
        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }
        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            LinkedList res=new LinkedList();
            int lastCarry=addLLHelper(one.head,one.size,two.head,two.size,res);
            if(lastCarry>0){
                res.addFirst(lastCarry);
            }
            return res;

        }
        static int addLLHelper(Node l1, int pv1, Node l2, int pv2, LinkedList result){
            //return value is carry after addition
            if(l1==null||l2==null){
                return 0;
            }
            int addVal=0;
            //based on place value 3 division of conditions
            if(pv1>pv2){
                //trying to reach to pv =0 for both the LL
                int prevCarry=addLLHelper(l1.next,pv1-1,l2,pv2,result);
                 addVal=(l1.data+prevCarry);

            }else if(pv1<pv2){
                int prevCarry=addLLHelper(l1,pv1,l2.next,pv2-1,result);
                 addVal=(l2.data+prevCarry);

            }
            else {//place value is equal and we decrease both the pv value and move ptr to next val
                int prevCarry=addLLHelper(l1.next,pv1-1,l2.next,pv2-1,result);
                 addVal=(l1.data+l2.data+prevCarry);
            }
            int newval=addVal%10;
            int newCarry=addVal/10;
            result.addFirst(newval);
            return newCarry;

        }
        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }
    }


}
