package aaaaaaaa;
public class TestEvaluate{
    public static void main(String[] args){
	
	if ( Exercises.evaluate("8") != 8 ) return ;
	if ( Exercises.evaluate("( 8 + 4 )") != 12 ) return ;
	if ( Exercises.evaluate("((8+4)*0)") != 0 ) return ;
	if ( Exercises.evaluate("((8+4)*(1+2))") != 36 ) return ;
	if ( Exercises.evaluate("(2*((8+4)*(1+2)))") != 2*36 ) return ;
	if ( Exercises.evaluate("(( 2 * (( 8 + 4) * (1+2))) / (9*8))") != 1 ) return ;
	System.out.println("balanced passed all tests");
    }
}
