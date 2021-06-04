public class IsPallindrome {
    Node rleft;
    public static class Node {
        int data;
        Node next;
    }
    public static void main(String[] args) {

    }
    public boolean isPalindrome(Node head) {
        rleft=head;
       return pallindromeHelper(head);

    }
    public boolean pallindromeHelper(Node node){
        if(node==null){
            return true;
        }
       boolean ans= pallindromeHelper(node.next);
        boolean currAns=rleft.data==node.data;
        rleft=rleft.next;
        return ans&&currAns;
    }

}
