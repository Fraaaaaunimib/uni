package aaaaaaaa;
public class TestKeepStackSorted{
    public static void main(String[] args){
	Stack A = new Stack();
	
	// first check: A is empty
	Exercises.keepStackSorted(A, 4);
	// we expect 4
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;
	
	// second check: one element
	A.push(4);
	// 4 is on the top
	Exercises.keepStackSorted(A, 2);
	// we expect 4; 2, with 4 on the top
	if ( A.isEmpty() ) return;
	if ( A.pop() != 4) return;
	if ( A.pop() != 2) return;
	if ( !A.isEmpty() ) return;
	
	//third check: 1 element
	A.push(4);
	// 4 is on the top
	Exercises.keepStackSorted(A, 6);
	// we expect 6; 4, with 6 on the top
	if ( A.isEmpty() ) return;
	if ( A.pop() != 6) return;
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;
	
	//fourth check: 2 elements
	A.push(4);
	A.push(10);
	// 10 is on the top
	Exercises.keepStackSorted(A, 20);
	// we expect 20; 10; 4, with 20 on the top
	if ( A.isEmpty() ) return;
	if ( A.pop() != 20) return;
	if ( A.pop() != 10) return;
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;

	//fifth check: 2 elements
	A.push(4);
	A.push(10);
	// 10 is on the top
	Exercises.keepStackSorted(A, 8);
	// we expect 10; 8; 4, with 10 on the top
	if ( A.isEmpty() ) return;
	if ( A.pop() != 10) return;
	if ( A.pop() != 8) return;
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;


	//6th check: 2 elements
	A.push(4);
	A.push(10);
	// 10 is on the top
	Exercises.keepStackSorted(A, 2);
	// we expect 10; 4; 2, with 10 on the top
	if ( A.isEmpty() ) return;
	if ( A.pop() != 10) return;
	if ( A.pop() != 4) return;
	if ( A.pop() != 2) return;
	if ( !A.isEmpty() ) return;
	
	
	
	System.out.println("keepStackSorted passed all tests");
    } // end main
    
} // end class TestEraseStack
