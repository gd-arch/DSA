/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedList;

/**
 *
 * @author g
 */
public class DoublyLinkedList {

    Node head, tail;

    class Node {

        public Node(int data) {
            this.data = data;
        }
        Node prev, next;
        int data;
    }

    Node createNode(int x) {
        return new Node(x);
    }

    public void insertAtEnd(int x) {
        if (head == null) {
            Node n = createNode(x);
            head = n;
            tail = n;
        } else {
            Node n = createNode(x);
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    public void insertAtBeginning(int x) {
        if (head == null) {
            Node n = createNode(x);
            head = n;
            tail = n;
        } else {
            Node n = createNode(x);
            head.prev = n;
            n.next = head;
            head = n;
        }
    }

    public void printList() {
        print(head);
    }

    void print(Node n) {
        while (n != null) {
            System.out.print(n.data + " ->");
            n = n.next;
        }
    }

    int search(int value) {

        if (head == null) {
            return -1;
        }
        int count = 0;
        Node n = head;
        while (n != null) {
            count++;

            if (value == n.data) {
                return count;

            }
            n = n.next;

        }
        return -1;

    }

}
