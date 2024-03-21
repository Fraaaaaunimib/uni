package aaaaaaaa;
//a fifo queue implemented by means of a circular linked list
public class Queue{ 
    private CircularLinkedList queueOfInt = new CircularLinkedList();
    
    public boolean isEmpty(){
	return queueOfInt.isEmpty();
    }

    public void enqueue(int data){ //insert as last element of the queue
	queueOfInt.insertAsLast(data);
    }
    
    public int dequeue(){ //delete the first item of the queue 
	int data=queueOfInt.getFirst();
	queueOfInt.deleteFirst();
	return data;
    }
    
    /*   
    public static void main(String[] args){
	Queue my = new Queue();
	System.out.println("must be true:" + my.isEmpty());
	my.enqueue(10);
	System.out.println("must be false:" + my.isEmpty());
	my.enqueue(20);
	System.out.println("must be false:" + my.isEmpty());
	my.enqueue(30);
	System.out.println("must be false:" + my.isEmpty());
	System.out.println("must be 10" + my.dequeue());
	System.out.println("must be false:" + my.isEmpty());
	System.out.println("must be 20" + my.dequeue());
	System.out.println("must be false:" + my.isEmpty());
	System.out.println("must be 30" + my.dequeue());
	System.out.println("must be true:" + my.isEmpty());
	System.out.println("deque ???:" + my.dequeue());
    }
    */
}
