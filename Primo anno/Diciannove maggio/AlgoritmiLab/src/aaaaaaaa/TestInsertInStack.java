package aaaaaaaa;
public class TestInsertInStack{
        public static void main(String[] args){
	Stack A = new Stack();
	Exercises.insertInStack(A, 4);
	if ( !A.isEmpty() ) return;
	
	// second check
	A.push(4);
	Exercises.insertInStack(A, 3); 
	// no modification is expected
	if ( A.isEmpty() ) return;
	if ( A.pop() != 4) return;
	if ( !A.isEmpty() ) return;

	// third check
	A.push(4);
	Exercises.insertInStack(A, 4);
	// we expect: -1; 4; -1
	if ( A.pop() != -1) return;
	if ( A.pop() != 4) return;
	if ( A.pop() != -1) return;
	if ( !A.isEmpty() ) return;
	
	A.push(4);
	A.push(5);
	// 5 is on the top of A
	Exercises.insertInStack(A, 4);
	// we expect: 5; -1; 4; -1
	if ( A.pop() != 5) return;
	if ( A.pop() != -1) return;
	if ( A.pop() != 4) return;
	if ( A.pop() != -1) return;
	if ( !A.isEmpty() ) return;
	System.out.println("insertInStack passed all tests");
	
	
	}
}
