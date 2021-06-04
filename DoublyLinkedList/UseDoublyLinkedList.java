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
public class UseDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList dl=new DoublyLinkedList();
      dl.insertAtBeginning(50);
//        dl.insertAtBeginning(100);
//                dl.insertAtBeginning(250);
//        dl.insertAtBeginning(300);
         dl.printList();
        System.out.println("position of 50 is "+dl.search(50));
        
    }
    
}
