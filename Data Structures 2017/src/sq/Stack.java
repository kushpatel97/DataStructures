package sq;

public class Stack<T>{
    
	private CLL<T> stack;  
	// the circular linked list that
	// represents the stack
	// constructor - new Stack( ) returns a
	// reference to an empty Stack	
	public Stack( ){
	    stack = new CLL<T>();
	}
	
	public void push(T data){
		stack.addAtFront(data);	    
	}
	
	public T pop( ){
		if (stack.isEmpty()){
			return null;
		}
		return stack.removeFront();
	}
	
	public boolean isEmpty( ){
		if(stack.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}    
	    
}
