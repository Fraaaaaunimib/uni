package aaaaaaaa;
public class TestBalanced{
    public static void main(String[] args){
	if ( ! Exercises.balanced("") ) return ;
	
	// unbalanced
	if ( Exercises.balanced("(") ) return ;
	if ( Exercises.balanced("[") ) return ;
	if ( Exercises.balanced("{") ) return ;
	
	if ( Exercises.balanced(")") ) return ;
	if ( Exercises.balanced("]") ) return ;
	if ( Exercises.balanced("}") ) return ;

	if ( Exercises.balanced("(()") ) return ;
	if ( Exercises.balanced("())") ) return ;
	
	if ( Exercises.balanced("[[]") ) return ;
	if ( Exercises.balanced("[]]") ) return ;
	
	if ( Exercises.balanced("{{}") ) return ;
	if ( Exercises.balanced("{}}") ) return ;
	
	
	
	// balanced
	if ( !Exercises.balanced("()") ) return ;

	if ( !Exercises.balanced("[]") ) return ;

	if ( !Exercises.balanced("{}") ) return ;

	if ( !Exercises.balanced("(())") ) return ;

	if ( !Exercises.balanced("[()]") ) return ;

	if ( !Exercises.balanced("{()}") ) return ;

	if ( !Exercises.balanced("(()(())())") ) return ;

	if ( !Exercises.balanced("[()()(()())]") ) return ;

	if ( !Exercises.balanced("{()[()()()][()()()][()()()]}") ) return ;
	
	
	
	System.out.println("balanced passed all tests");
    }
}
