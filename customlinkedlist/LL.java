package customlinkedlist;

public class LL {
   private int size;
   public Node head;
   public Node tail;

   // Constructor initializes the linked list
   public LL(){
      this.size = 0;
      this.head = null;
      this.tail = null;
   }

   public int headvalue(){
      return head.data;
   }
   public int tailvalue(){
      return tail.data;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      Node temp = head;
      while (temp != null) {
         sb.append(temp.data);
         if (temp.next != null) {
            sb.append(" -> ");
         }
         temp = temp.next;
      }
      sb.append(" END");
      return sb.toString();
   }



   // Append a node at the end of the list
   public void append(int data){
      Node newNode = new Node(data);
      if (tail == null) {
         // If the list is empty, set both head and tail to the new node
         head = newNode;
         tail = newNode;
      } else {
         // Otherwise, link the new node after the tail and update the tail reference
         tail.next = newNode;
         tail = newNode;
      }
      size++;
   }
public Node get(int index){
      Node temp = head;
      int count = 0;
      if(index == 0){
         return head;
      }
      while(temp.next != null){
         if(count == index){
            return temp;
         }
         temp = temp.next;
         count++;
      }
      return null;

}
public int length(){
      return size;

}
public int remove(int index){
      Node prev=get(index-1);
      int value=prev.next.data;
      prev.next=prev.next.next;
      size--;
 return  value;}

   public int findindex(int value){
      Node temp = head;
      int count = 0;
      if(head.data == value){
         return 0;
      }
      while(temp.next != null){
         if(temp.next.data==value){

            return count+1;
         }
         count+=1;
         temp = temp.next;
      }
      return -1;
   }
   // Insert a node at a specific index
   public void insert(int data, int index){
      if (index > size || index < 0) {
         System.out.println("Index out of bounds");
         return;
      }

      if (index == size) {
         append(data);  // Append to the end
         return;
      } else if (index == 0) {
         addNode(data);  // Add to the front
         return;
      }

      Node newNode = new Node(data);
      Node current = head;
      for (int i = 0; i < index - 1; i++) {
         current = current.next;
      }

      // Insert the new node in the middle
      newNode.next = current.next;
      current.next = newNode;
      size++;
   }
public int poptail(){
      if (size<=1) {
return  pophead();


      }
      int val=tail.data;
      Node secondlast=get(size-2);

   tail=secondlast;
   secondlast.next=null;

   return val;
}



   // Pop the head (remove the first node)
   public int pophead(){
      if (head == null) {
         throw new IllegalStateException("List is empty");
      }

      int value = head.data;
      head = head.next;
      if (head == null) {
         tail = null; // If the list becomes empty, set tail to null
      }
      size--;
      return value;
   }

   // Display the linked list
   public void display(){
      Node temp = head;
      while (temp != null) {
         System.out.print(temp.data);
         if (temp.next != null) {
            System.out.print(" -> ");
         }
         temp = temp.next;
      }
      System.out.println(" END");
   }

   // Add a node to the front of the list
   public int addNode(int data){
      Node newNode = new Node(data);
      newNode.next = head; // Link the new node to the old head
      head = newNode; // Update head to be the new node
      if (tail == null) { // If the list was empty, the new node is both head and tail
         tail = newNode;
      }
      size++;
      return size;
   }

   // Remove the tail (last node)
   public void removetail(){
      if (tail == null) {
         System.out.println("List is empty");
         return;
      }

      if (head == tail) {
         // Only one node in the list
         head = null;
         tail = null;
      } else {
         // Traverse to the second-to-last node
         Node current = head;
         while (current.next != tail) {
            current = current.next;
         }
         current.next = null;
         tail = current; // Update tail to second-to-last node
      }
      size--;
   }

   // Inner Node class
   private class Node {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
         this.next = null;
      }

      public Node(int data, Node next) {
         this.data = data;
         this.next = next;
      }
   }
}
