package customdoublelinkedlist;

import customlinkedlist.LL;

public class DLL extends LL {
    private Node head;
    private Node tail;
    private int size=0;

    public int getSize() {
        return size;
    }


    public void display(){
        DLL.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println(" -> END");
    }

    public Node Find(int value ){
        Node temp = head;
        while (temp.next != null){
            if (temp.data == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void insertAfter(int data, int after) {
        Node p = Find(after); // Find the node after which we want to insert

        if (p == null) {
            System.out.println("Node with data " + after + " not found.");
            return;
        }

        Node node = new Node(data);

        node.next = p.next;   // 1. Link new node's next to p's next first
        node.prev = p;        // 2. Link new node's prev to p

        if (p.next != null) { // 3. If p wasn't the last node...
            p.next.prev = node; // Link next node's prev back to the new node
        }

        p.next = node;        // 4. Finally, link p's next to the new node
    }

    public void append(int data) {
   Node temp = new Node(data);
   Node last = head;
   temp.next = null;
   if(head == null){
       temp.prev=null;
       head=temp;
       return;

   }
   while (last.next != null) {
       last = last.next;

   }
    last.next = temp;
   temp.prev=last;

    }

    public void displayInReverse() {
        Node temp = tail; // Start from the tail node
        if(head.next == null){
            display();
            return;
        }
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null) {
                System.out.print(" -> ");
            }
            temp = temp.prev; // Move to the previous node
        }
        System.out.println(" -> END");
    }
public Node getNode(int index){
        int count = 0;
        Node temp = head;
    if(index == 0){
        return head;
    }
        while (temp != null) {
            if (count == index) {
                return  temp;
            }
            count++;
            temp = temp.next;
        }
        return null;
}

public void insertfirst(int data){

             Node newNode = new Node(data);
             newNode.next = head;
             newNode.prev = null;

             if(head != null){
                 head.prev = newNode;


             }
             head = newNode;
             size++;

}
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;

        }
        public Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;

        }
    }
}
