package aaaaaaaa;
public class TestExists{
    public static void main(String[] args){
	CircularLinkedList l = new CircularLinkedList();
	if (l.exists(10) != false) {
	    System.out.println("Error of method exists on an empty list");
	    return;
	}

	l.insertAsFirst(20);
	if (l.exists(10) != false){
	    System.out.println("Error of method exists on a list with one element");
	    return;
	}

	l.insertAsFirst(30);
	if (l.exists(10) != false){
	    System.out.println("Error of method exists on a list with two elements");
	    return;
	}

	if (l.exists(30) != true){
	    System.out.println("Error of method exists on a list with two elements");
	    return;
	}

	if (l.exists(20) != true){
	    System.out.println("Error of method exists on a list with two elements");
	    return;
	}

	System.out.println("Method exists passed all tests.");
	
    }//end main
    
} // end class
