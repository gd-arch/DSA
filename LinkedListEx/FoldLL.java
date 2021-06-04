public class FoldLL {

    public static class Node {
        int data;
        Node next;
    }
    public static class LinkedList {

        Node head;
        Node tail;
        int size;
        Node left;
    public void fold() {
        left = this.head;
        helperFold(head, 0);
    }
    public void helperFold(Node right, int floor) {
        if (right == null) return;
        helperFold(right.next, floor + 1);
        if (floor > size / 2) {
            Node temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        } else if (floor == size / 2) {
            tail = right;
            right.next = null;
        }


    }
    }

    public static void main(String[] args) {

    }
}
