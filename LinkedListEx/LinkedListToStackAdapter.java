import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListToStackAdapter {
    public static class LLToStackAdapter {
        LinkedList< Integer > list;

        public LLToStackAdapter() {
            list = new LinkedList < > ();
        }


        int size() {
            return list.size();

        }

        void push(int val) {
            list.addLast(val);

        }

        int pop() {
            if(list.size()==0){
                System.out.println("Stack underflow");
                return -1;
            }
           return list.removeLast();

        }

        int top() {
            if(list.size()==0){
                System.out.println("Stack underflow");
                return -1;
            }
            return list.peekLast();
        }
    }


         public static void main(String[] args) 	{




         }
}
