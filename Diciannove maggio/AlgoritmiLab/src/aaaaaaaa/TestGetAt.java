package aaaaaaaa;
public class TestGetAt{
    public static void main(String[] args){
	CircularLinkedList l = new CircularLinkedList(10);
	for(int i = 1; i < 5 ; i++){
	    if (l.getAt(i) != 10){
		System.out.println("Error of method getAt on a list with one element");
		return;
	    }
	}

	l.insertAsFirst(20);
	if (l.getAt(1) != 20){
	    System.out.println("Error of method getAt on a list with two elements");
	    return;
	}

	for(int i = 2; i < 5 ; i++){
	    if (l.getAt(i) != 10){
		System.out.println("Error of method getAt on a list with two elements for getAt( " + i + ")=" +  l.getAt(i));
		return;
	    }
	}

	l.insertAsFirst(30);
	if (l.getAt(1) != 30){
	    System.out.println("Error of  getAt(1) on a list with three elements");
	    return;
	}

	if (l.getAt(2) != 20){
	    System.out.println("Error of  getAt(2) on a list with three elements");
	    return;
	}

	for(int i = 3; i < 7 ; i++){
	    if (l.getAt(i) != 10){
		System.out.println("Error of method getAt on a list with three elements for getAt( " + i + ")=" +  l.getAt(i));
		return;
	    }
	}
	
	System.out.println("Method getAt passed all tests.");
    }//end main

} // end class
