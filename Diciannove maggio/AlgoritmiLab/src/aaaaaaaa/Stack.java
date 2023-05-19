package aaaaaaaa;
public class Stack{
    private LinkedList stackOfInt = new LinkedList();
    
    
    public boolean isEmpty(){ 
	return stackOfInt.isEmpty();
    }
    
    public void push(int data){ // add data to the top of the stack
	stackOfInt.insertAsFirst(data);
    }
    
    public int pop(){ // remove the data from the top of the stack
	int data = stackOfInt.getAt(1);
	stackOfInt.deleteFirst();
	return data;
    }
    
	
    public static void main(String[] args){
	Stack my = new Stack();
	
	System.out.println("Must be true:" + my.isEmpty() + "***");
	my.push(3);
	my.push(4);
	my.push(5);
	System.out.println("Must be false:" + my.isEmpty() + "***");
	System.out.println("Must be 5" + my.pop() + "***");
	System.out.println("Must be 4" + my.pop() + "***");
	System.out.println("Must be 3" + my.pop() + "***");
	System.out.println("Must be true:" + my.isEmpty() + "***");
    }
    
}

