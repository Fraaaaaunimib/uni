package linkedlist;
public class LinkedList {
    Node head;

    public LinkedList(int x) {
        head = new Node();
        head.setData(x);
        head.setNext(null);
    }

    public static class Node {
        int data;
        Node next;

        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertAsFirst(int x){
        Node n = new Node();
        n.data = x;
        n.next = head;
        head = n;
    }

    public boolean deleteFirst(){
        if (head == null) return false;
        head = head.next;
        return true;
    }

    public boolean exists(int x){
        return exists(head,x);
    }

    public boolean exists (Node p, int x){ //verifica se esiste la x
        if (p == null) return false;
        return (p.data == x) || (exists(p.next,x));
    }

    public void multiplyBy(int x){
        multiplyBy(head,x);
    }

    public void multiplyBy(Node p, int x){
        if (p != null){
            p.data *=  x;
            multiplyBy(p.next,x);
        }
    }

    public void insertAsLast(int x){
        if (head == null) insertAsFirst(x); //the list is empty
        else insertAsLast(head,x);
    }
    private void insertAsLast(Node p, int x){
        /*
         * Write a method void insertAsLast(int x) that inserts a new node as last node of the list. Write
            a (recursive) private helper method void insertAsLast(Node p, int x).
            The (public) method void insertAsLast(int x) relies on the methods:
            - void insertAsFirst(int), described before;
            - a (private) method void insertAsLast(Node p, int x).
         */

         if (p != null){
            if (p.next == null){
                Node n = new Node();
                n.data = x;
                n.next = null;
                p.next = n;
                return;
            } 
                insertAsLast(p.next,x);
            
         }
    }

    public void print(){
        if ( head != null ){
        System.out.println("Data in the list");
        print(head);
        }
        else System.out.println("The list is empty");
        } 

        private void print(Node p){
            if (p != null){
                System.out.println("Data: " + p.getData());
                print(p.next);
            }
        }

        public int size(){
            return size(head);
            }

        private int size(Node p){
 
          if (p == null) return 0;
          return size(p.next)+1;
        }

        public static void main(String[] args) {
            LinkedList a = new LinkedList(5);
            a.insertAsFirst(1);
            a.insertAsFirst(2);
            a.insertAsFirst(2);
            System.out.println(a.size());
        }

        public int getAt(int k){
            if (head == null || k < 1) {  // empty list or invalid index
                return -1;  // return some default value
            } else if (k == 1) {  // base case: k-th node is the head node
                return head.getData();
            } else if (head.getNext() == null) {  // base case: list has only one node
                return head.getData();
            } else {  // recursive case: move to the next node
                return getAt(head.getNext(), k-1);
            }
        }

        private int getAt(Node node, int k){
            if (k == 1 || node.getNext() == null) return node.getData();
            else return getAt(node.getNext(), k-1);
        }

        private void printReverse(Node p){
            if (p == null) return;
            if (p != null){
            printReverse(p.next);
            }
            System.out.println(p.getData());
        }

        public int getLast(){
            return getLast(head);
        }

        private int getLast(Node p){
            if (p.next == null) return p.getData();
            return getLast(p.next);
        }

        public boolean deleteLast(){
            if (head == null) return false;
            if (head.next == null){
                head = null;
                return true;
            }
            return deleteLast(head);
        }

        private boolean deleteLast(Node p){
            Node front = p.next;
                if (p.next.next == null){ // base case
                //if the successor of p is the last element --> it is if the next of the next is null
                //then p becomes the last element
                p.next = null;
                return true;
                }
                return deleteLast(front); // recursive step
    }

    public boolean deleteData(int x){
        if (head == null) return false; // the list is empty,
        // nothing to do
        if (head.data == x) {
        //the first node has to be deleted
        head = head.next;
        deleteData(x);
        return true;
        }
        //the first node must not be deleted
        return deleteData(head,x);
        
    }

    private boolean deleteData(Node p, int x){
      //p points a node that does not contain x
Node front = p.next; // front points to the successor of p, if any
if (front == null) return false; //p has no successor
if (front.data == x) {
// delete the successor of p
p.next = front.next;
//now p.next different from front
deleteData(p, x);
return true;
}
//the successor of p must not by deleted
//recursively proceed on the rest of the list
return deleteData(front, x);
} // deleteData(Node, int)

public void reverse() {
    if (head == null || head.getNext() == null) {
        // list is empty or has only one node, no need to reverse
        return;
    }
    
    Node current = head;
    Node prev = null;
    Node next = null;

    while (current != null) {
        next = current.getNext();
        current.setNext(prev);
        prev = current;
        current = next;
    }

    head = prev;
}

}
