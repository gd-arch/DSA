public class LinkedList {
   static class LList{
       static  class Node{
          int data;
          Node next;
        }
        Node head,tail;
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

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
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

        public void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;

                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;

                temp.next = node;
                size++;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                tail.next = null;
                size--;
            }
        }
       public void removeAt(int idx) {
           if (idx < 0 || idx >= size) {
               System.out.println("Invalid arguments");
           } else if (idx == 0) {
               removeFirst();
           } else if (idx == size - 1) {
               removeLast();
           } else {
               Node temp = head;
               for (int i = 0; i < idx - 1; i++) {
                   temp = temp.next;
               }

               temp.next = temp.next.next;
               size--;
           }
       }
        public int kthFromLast(int k) {
           Node n = head;
           Node kn = head;
           for (int i = 0; i < k; i++) {
               n = n.next;
           }
           while (n.next != null) {
               n = n.next;
               kn = kn.next;
           }
           return kn.data;
       }

       public int mid() {
           Node mid=head;
           Node end=head;
           int count=0;
           while(end.next!=null){
               count++;
               end=end.next;
               if(count%2==0){
                   mid=mid.next;
               }
           }
           return mid.data;



       }
       void removeDuplicates(){
            LList l=new LList();

            l.addLast(head.data);
            Node ptr=head.next;
            while(ptr!=null){
                if(l.getLast()!=ptr.data){
                    l.addLast(ptr.data);
                }
                ptr=ptr.next;
            }
            this.head=l.head;
            this.tail=l.tail;
            this.size=l.size;
       }





    }
    public static void main(String[] args) {
LList l=new LList();
l.addLast(10);
l.addLast(20);
l.addLast(20);
        l.addLast(20);
        l.addLast(30);
        l.addLast(30);
        l.addLast(30);
        l.addLast(70);
        l.addLast(90);
        l.display();
        l.removeDuplicates();
       // l.removeNode(l.head.next,l.head.next.next);
        l.display();


    }
}
