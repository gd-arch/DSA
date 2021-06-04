/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author g
 */
public class MyLinkedList {

    Node head;

    class Node {

        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }

    }
    Node createNode(int x){
        return new Node(x);
    }
   public void insertAtEnd(int x){
        if(head==null) {
            head=createNode(x);
          
        }
        else{
        Node n=createNode(x);
        //traverse
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;
    }}
  public void insertAtBegining(int x){
        if(head==null) {
            head=createNode(x);
            return;
        }else{
        Node temp=createNode(x);
        temp.next=head;
        head=temp;

   }}
  public void removeItem(int x){
       if(head==null) return;
       //traverse
         Node temp=head;
       if(temp.next!=null){
     
       if(head.key==x) head=head.next;
      if(temp.next.key==x){
          temp.next=temp.next.next;
          return;
     }
      temp=temp.next;
       }
      
   }
  public void printList(){
      print(head);
  }
   void print(Node n){
       if(head==null) return;
       Node temp=head;
     
   while(temp!=null){
       System.out.print(temp.key+"->");
       temp=temp.next;
     }
  }

}
