public class reverseLLrecursive {
    public class ListNode {
          int val;
            ListNode next;
             ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode tail=head;
        if(tail!=null)
            while(tail.next!=null){
                tail=tail.next;
            }
        reversePointer(head);
        head=tail;
        tail=null;
        return head;


    }
    public void reversePointer(ListNode node){
        if(node==null){
            return;
        }
        reversePointer(node.next);
        if(node.next!=null)
            node.next.next=node;
        node.next=null;
    }

}
