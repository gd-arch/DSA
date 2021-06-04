public class Add2LL2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //result  list
        ListNode res=new ListNode();
        //tail for adding elements in o(1) in result  list
        ListNode tail=res;
        addHelper(l1,l2,res,0,tail);
        return res.next;
    }
    //prevCar=previous carry
    //car=carry generated after current operation
    void addHelper(ListNode l1,ListNode l2,ListNode res,int prevCar,ListNode tail){
        if(l1==null&&l2==null){
            if(prevCar>0){
                ListNode last=new ListNode(prevCar);
                tail.next=last;
                tail=tail.next;
            }
            return;
        }
        else if(l1!=null&&l2!=null){
            int add=l1.val+l2.val+prevCar;
            int car=add/10;
            int newVal=add%10;
            //creating a node which stores the one's place digit add it to the result using tail
            ListNode last=new ListNode(newVal);
            tail.next=last;
            tail=tail.next;
            //new carry is passed to next function call where then it acts as previous carry
            addHelper(l1.next,l2.next,res,car,tail);

        }else if(l1==null&&l2!=null){
            int add=l2.val+prevCar;
            int car=add/10;
            int newVal=add%10;
            ListNode last=new ListNode(newVal);
            tail.next=last;
            tail=tail.next;
            addHelper(l1,l2.next,res,car,tail);
        }else {
            int add=l1.val+prevCar;
            int car=add/10;
            int newVal=add%10;
            ListNode last=new ListNode(newVal);
            tail.next=last;
            tail=tail.next;
            addHelper(l1.next,l2,res,car,tail);
        }
    }
}
