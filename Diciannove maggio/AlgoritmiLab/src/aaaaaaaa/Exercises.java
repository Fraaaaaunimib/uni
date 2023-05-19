package aaaaaaaa;
public class Exercises{

    /*
      
      Exercise 1 
	
      write the method 
      
      void insertInStack(Stack S, int N)
      
      
      that for every occurrence of N in S inserts in the positions immediately before and
      after N the value -1. The method can define objects of the class Stack or Queue
      only.
      
    */
    
    public static void insertInStack(Stack S, int N){
      Stack stackapp = new Stack();
      int app = 0;

      while(!S.isEmpty()){
        app = S.pop();
        if (app == N){
          stackapp.push(-1);
          S.push(-1);
        }
        stackapp.push(app);
      }

      while(!stackapp.isEmpty()){
        app = stackapp.pop();
        S.push(app);
      }
    } // end insertInStack
    
    
    
    /*
      
      Exercise 2
      
      write the metohod  
      
      void eraseStack(Stack S, int N)
      
      that for every occurrence of N in S deletes the two elements that are adjacents to
      N. The method can define objects of the class Stack or Queue only. To simplify the
      problem, you can suppose that in S there are no two equal subsequent elements.
      
    */
    
    public static void eraseStack(Stack S, int N){
      Stack stackapp = new Stack();
      int app = 0;
      while (!S.isEmpty()){
        try{
        app = S.pop();
        if (app == N){
          stackapp.pop();
          S.pop();
        }
        stackapp.push(app);
      } catch (Exception e){

      }
      }

      while(!stackapp.isEmpty()){
        app = stackapp.pop();
        S.push(app);
      }
    } // end eraseStack
    
    
   
    
    /*

      Exercise 3
      
      Write the method

      public static void keepStackSorted
      
      that given the sorted stack S (where the maximum is on the top), inserts N in S
      preserving the sorting property. The method can only define objects of the class
      Stack.

    */
    
     public static void keepStackSorted(Stack S, int N){
     Stack stackapp = new Stack();
     int curr;
     boolean flag = false;
     while(!S.isEmpty() && !flag){
      curr = S.pop();
      if (curr <=N){
        stackapp.push(N);
        flag = true;
      }
      stackapp.push(curr);
     }

     while (!S.isEmpty()){
      curr = stackapp.pop();
      S.push(curr);
     }
     } // end keepStackSorted

public static void QueueErase(Queue Q, Stack S){
  Stack stackapp = new Stack();
  Queue queueapp = new Queue();
  int sapp = 0, qapp = 0;
  while (!S.isEmpty()){
    sapp = S.pop();
        stackapp.push(sapp);
    while(!Q.isEmpty()){
        
        qapp = Q.dequeue();
        if((sapp != qapp)) queueapp.enqueue(qapp);
    }
    while(!queueapp.isEmpty()){
      qapp = queueapp.dequeue();
      Q.enqueue(qapp);
    }
  }

 
  while(!stackapp.isEmpty()){
    sapp = stackapp.pop();
    S.push(sapp);
  }
}
    /*
      
      Exercise 4

      Write the  method 

      boolean balanced(String s) 

      that returns true if the parenthesis in s are balanced.
    */

    public static boolean balanced(String s){
	return false;
	
    } // end balanced

    /*
      
      Exercise 5

      Write the method

      int evaluate(String s) 

      that returns the value of the arithmetic expression contained in s. Suppose that the
      expression is fully parenthesized, the unary minus is not used and the numbers have
      one digit.

    */

    public static int evaluate(String s){
	return -1;
    }

    
    /* evaluate a boolean expression
     *
     * A boolean expression is an expression that evaluates to either true or false. 
     * It can be in one of the following shapes:

    * 't' that evaluates to true.
    
    * 'f' that evaluates to false.
   
    * '!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
   
    * '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND 
      of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
    
    * '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR 
      of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.

    Given a string expression that represents a boolean expression, 
    return the evaluation of that expression.

    It is guaranteed that the given expression is valid and follows the given rules.

    Example1: 

    Input: expression = "&(|(f))"
    Output: false

    Example 2:

    Input: expression = "|(f,f,f,t)"
    Output: true

    Example 3:

    Input: expression = "!(&(f,t))"
    Output: true

	 */

    public static boolean boolEval(String s) {
	return false;
    } // end booleveal

    
} // end class Exercises
