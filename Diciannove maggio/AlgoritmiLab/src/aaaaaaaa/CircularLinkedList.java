package aaaaaaaa;
public class CircularLinkedList{
    private class Node{
        int data;
        Node next;
    } // end Node
    
    private Node last; //last.next points to the head list 
    
    public CircularLinkedList(){
        //creates an empty list
        last = null;
    } // end constructor
    
    // creates  a list with a node 
    public CircularLinkedList(int x){
        last = new Node();
        last.data = x;
        last.next = last; //this is both the first and the last node of the list
    } // end constructor
    
    public boolean isEmpty(){
	return last == null;
    }
    
    public int getFirst(){ // returns the value in the first node of the list
	                   // note that if last == null holds we get an error
	
	return last.next.data;
    }
    
    public boolean deleteFirst(){
	if (last == null) return false; // the list is empty
	
	if (last.next != last){ //there are at least 2 elements
	    last.next = last.next.next;
	}
	else last = null;
	return true;
    }
    
    // exists in recursive version
    public boolean exists(int x){
        // returns true if x occurs as a data in a node of the list, 
        // false otherwise
        
        if (last == null) return false; //the list is empty
	return exists(last.next, x); //call a private method
    }
    
    private boolean exists(Node p, int x){
        if ( p == last ) return (last.data == x);
        return  (p.data == x)  || (exists(p.next, x)) ;
    }
    
    public boolean existsIterative(int x){
	if (last == null) return false; // the list is empty
	// if we are here the list is not empty
	if (last.data == x) return true;
	// iterate starting from the first node
	Node t = last.next;
	while (t != last){
	    if (t.data == x) return true;
	    t = t.next;
	}
	return false;
    } // end existsIterative
    
    /* ************************************************* */
    
    public void print(){
        if ( last != null ){ //the list is not empty
	    System.out.println("Data in the list");
            print(last.next);
        }
        else System.out.println("The list is empty");
    } // end print()
    
    private void print(Node p){
        System.out.println("data: " + p.data);
	if (p != last){
	    print(p.next);
        }
    } // end print(Node)
    
    public void insertAsFirst(int x){
	if (last == null){ //the list is empty
	    last = new Node();
	    last.data = x ;
	    last.next = last; // the first element is also the last
	}
	else {
	    Node n = new Node();
	    n.data = x;
	    n.next = last.next; // the successor of n is the first element
	    last.next = n; // the successor of the last node is n
	}
    } // end insertAsFirst(int)
    
    public void insertAsLast(int x){
	if (last == null) insertAsFirst(x);
	else {
	    Node n = new Node();
	    n.data = x;
	    n.next = last.next; //the successor of n is the first element
	    last.next = n; // the predecessor of n is last
	    last = n; // makes the new node the last element
	}
    } // end insertAsLast(int)
    
    /* print in reverse */
    public void printReverse(){
        if ( last != null ){ 
	    //the list is not empty
	    System.out.println("Data in the list:");
	    
	    printReverse(last.next);
	}
        else System.out.println("The list is empty.");
    } // end printReverse()
    
    private void printReverse(Node p){
	if (p != last){
	    printReverse(p.next);
	    System.out.println("data: " + p.data + "; ");
	}
	else System.out.println("data: " + last.data + "; ");
    } // end printReverse(Node)

    /* size: returns the number of nodes */
    public int size(){
	if (last == null) return 0;
	// if we are here the list is not empty
        return size(last.next);
    } // end size
    
    private int size(Node p){
        if (p == last){
            return 1;
        }
        else return 1 + size(p.next);
    } // end size(Node)

    /* size iterative */
    public int sizeIterative(){
	if (last == null) return 0;
	// if we are here the list is not empty
        Node t = last.next;
	int count = 1;
	while(t != last){
	    count ++;
	    t = t.next;
	}
	return count;
    } // end size


    /* getAt */
    public int getAt(int k){
	/* returns -1 if the list is empty or k<1 */
	if (last == null  || k<1 ) return -1;
	return getAt(last.next, k);
    }
    private int getAt(Node p, int i){
	/* first base case */
	if (i == 1) return p.data;
	/* the list has less than k nodes */
	if (p == last ) return p.data;
	
	return getAt(p.next, i-1);
    }

    public int getAtIterative(int k){
	/* returns -1 if the list is empty or k<1 */
	if (last == null  || k<1 ) return -1;
	Node p = last.next;
	while(p != last && k > 1){
	    p = p.next;
	    k--;
	}
	return p.data;
    }
}
