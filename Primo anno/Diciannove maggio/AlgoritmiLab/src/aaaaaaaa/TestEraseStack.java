package aaaaaaaa;
public class TestEraseStack{
    public static void main(String[] args){
	Stack A = new Stack();
	
	// first check: A is empty
	Exercises.eraseStack(A, 4);
	if ( !A.isEmpty() ) return;
	
	// second check: one element
	A.push(4);
	// 4 is on the top
	Exercises.eraseStack(A, 4);
	// we expect 4 on the top
	if ( A.isEmpty() ) return;
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;
	
	//third check: 2 elements
	A.push(0);
	A.push(4);
	// 4 is on the top
	Exercises.eraseStack(A, 4);
	// we expect exactly one element: the 4
	if ( A.isEmpty() ) return;
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;

	// fourth check: two elements
	A.push(4);
	A.push(0);
	// 0 is on the top
	Exercises.eraseStack(A, 4);
	// we expect exactly one element: the 4
	if ( A.isEmpty() ) return;
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;
	
	//fifth check
	A.push(0);
	A.push(4);
	A.push(1);
	// 1 is on the top
	Exercises.eraseStack(A, 4);
	// we expect expect one element: the 4
	if ( A.isEmpty() ) return;
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;

	// 6th check
	A.push(0);
	A.push(4);
	A.push(1);
	A.push(2); // 2 is on the top, 0 in the bottom
	Exercises.eraseStack(A, 4);

	// we expect 2 and 4, with 2 one the top
	if ( A.pop() != 2) return;
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;

	System.out.println("eraseStack passed all tests");
    } // end main
    
} // end class TestEraseStack
