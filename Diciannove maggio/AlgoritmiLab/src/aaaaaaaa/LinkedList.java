package aaaaaaaa;
public class LinkedList{
    private class Node{
	int data;
	Node next;
    } // end Node
    
    private Node head;
    
    public LinkedList(){
	//creates an empty list
	head = null;
    } // end constructor
    
    // creates  a list with a node 
    public LinkedList(int x){
	head = new Node();
	head.data=x;
	head.next=null;
    } // end constructor
    
    
    public boolean isEmpty(){
	//returns true if the list is empty, 
	//false otherwise
	
	return head == null;
    } // end isEmpty()
    
    
    public boolean exists(int x){
	// returns true if x occurs as a data in a node of the list, 
	// false otherwise
	
	if (head == null) return false;
	return exists(head,x); //call a private method
    }
    
    private boolean exists(Node p, int x){
	if ( p == null ) return false;
	return  (p.data == x)  || (exists(p.next, x)) ;
    }
    
    
    public void multiplyBy(int x){
	if (head != null) multiplyBy(head, x); 
    } // end multiplyBy(int)
    
    private void multiplyBy(Node p, int x){
	if (p != null){
	    p.data *= x;
	    multiplyBy(p.next, x);
	}
    } // end multiplyBy(Node, int)

    //add a node to the head of the list
    public void insertAsFirst(int x){
	Node n = new Node();
	n.data = x;
	n.next = head;
	head = n;
    }

    public int getAt(int k){ // returns the value in the first node
	                     // there is an error if head == null holds
	                     // k=1 means first element
	Node p = head;
	Node prev=p;
	while ( p != null && k>1 ){
	    prev = p;
	    p = p.next;
	    k--;
	}
	if (p == null) return prev.data; //prev point to the last node, if the list is not
					 //empty
	return p.data;
    }
    public void insertAsLast(int x){
	if (head == null) insertAsFirst(x); //the list is empty
	else insertAsLast(head,x);
    }
    
    private void insertAsLast(Node p, int x){
	if (p.next==null) {
	    //p is pointing to the last node 
	    Node g = new Node();
	    g.data= x;
	    g.next = null;
	    p.next=g;
	    
	    /*
	      In alternative we can save g:
	     
	      p.next = new Node();
	      p.next.data = x;
	      p.next.next = null;
	    */
	    
	    return;
	}
	insertAsLast(p.next, x);
    }
    
    public boolean deleteFirst(){
	if (head == null) 
	    return false; //nothing to delete
	head = head.next;
	return true;
    }
    
    public boolean deleteLast(){
	if (head == null)
	    return false; // nothing to delete;
	
	if (head.next == null){ 
	    // the list has one element
	    head = null;
	    return true;
	}
	// the list has two or more elements
	return deleteLast(head);
    }
    
    private boolean deleteLast(Node p){
	Node front = p.next;
	if ( front.next == null){
	    p.next = null;
	    return true;
	}
	return deleteLast(front);
    }
    
    //delete all the nodes containing the value x
    public boolean deleteData(int x){
	if (head == null) return false; //nothing to do
	if (head.data == x) {
	    //the first node has to be deleted
	    head = head.next;
	    deleteData(x);
	    return true;
	}
	//the first node must not be deleted
	return deleteData(head,x);
    }// end deleteData(int)

    private boolean deleteData(Node p, int x){
	//p ponts a node that does not contain x
	Node front = p.next;
	if (front == null) return false; //p has no successor
	
	if (front.data == x) {
	    // delete the successor of p
	    p.next = front.next;
	    
	    //now p.next different from front 
	    deleteData(p, x); 
	    return true;
	}
	
	//the successor of p must not by deleted
	//proceed on the rest of the list
	return deleteData(front, x);
    } // deleteData(Node, int)
    

    //duplicates the nodes of the list pointed by head
    public LinkedList copy(){
	LinkedList theCopy = new LinkedList();
	theCopy.head = copy(head);
	return theCopy;
    }
    
    private Node copy(Node p){
	Node g;
	if (p == null) return null; //the given list is empty;
	g = new Node();
	g.data = p.data;
	g.next = copy(p.next);
	return g;	
    }
    
    public void print(){
	if ( head != null ){
	    System.out.println("Data in the list");
	    print(head);
	}
	else System.out.println("The list is empty");
    } // end print()
    
    private void print(Node p){
	if (p != null){
	    System.out.println("data: " + p.data);
	    print(p.next);
	}
    } // end print(Node)

    public void printReverse(){
	if ( head != null ){
	    System.out.println("Data of the list (printed from last to the first)");
	    printReverse(head);
	}
	else System.out.println("The list is empty");
    } // end printReverse()
    
    private void printReverse(Node p){
	if (p != null){
	    printReverse(p.next);
	    System.out.println("data: " + p.data);
	}
    } // end printReverse(Node)
    
    /***************************************
     *
     *            reverse()
     *
     * build the reverse of the given list by reversing the pointers.
     * When we finish, head points to the last node
     * No new node is created, only the value of next is changed
     *
     ***************************************/
    public void reverse(){
	if (head != null && head.next != null)
	    //there are more than one element
	    head=reverse(head);
    }
    private Node reverse(Node p){
	if (p.next == null) return p; //there is one element
	
	//there is more than one element: 
	//recursively reverse the list starting from the successor of p
	Node r = reverse(p.next); 
	//now le list starting from the node successor of p is reversed and r points to
	//it.  

	//Now, the first node of the given list pointed by p must become the last
	//node of the list pointed by r

	//we change the pointer of the the successor of p, which is the last node of the
	//list pointed by r, 
	p.next.next=p; 
	//now the successor of p points to p
	p.next=null; //the given list is fully reversed
	return r;
    }
    
    /**************************************************
     *
     * Concatenate
     * 
     ***************************************************/

    public LinkedList  concatenate(LinkedList theList){
	LinkedList cp1 =  this.copy(); //duplicates the list
	LinkedList cp2 =  theList.copy(); //duplicates the list
	
	if (cp2.head == null) return cp1; //cp2 empty
	if (cp1.head == null) return cp2; //cp1 empty
	
	//both lists are not empty
	Node g=cp1.head;
	while (g.next != null) g=g.next;
	g.next=cp2.head;
	return cp1;
	
	}
	
//size()
    public int size(){
	return size(head);
    } // end size
    
    private int size(Node p){
    	if (p == null){
	    return 0;
    	}
    	else return 1 + size(p.next);
    } // end size(Node)
    

}//end LinkedList
/*
class ciccio extends LinkedList{
    Node x;
}
*/
