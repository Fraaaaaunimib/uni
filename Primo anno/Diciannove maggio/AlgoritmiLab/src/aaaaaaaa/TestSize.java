package aaaaaaaa;
public class TestSize{
    public static void main(String[] args){
	CircularLinkedList l = new CircularLinkedList();

	if (l.size() != 0){
	    System.out.println("size() returns " + l.size() + "on an empty list");
	    return;
	}
	for(int i= 1; i<10; i++){
	    l.insertAsFirst(i);
	    if (l.size() != i){
		System.out.println("size() returns " + l.size() + " on a list with " + i + " element(s).");
		return;
	    }   
	}
	System.out.println("Method size passed all tests.");
	
    } // end main

			    
} // end class TestSize
