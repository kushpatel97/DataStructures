package sq;
public class Client<T>{
	
	public static void main(String[] args){
		Stack<Integer> test = new Stack<Integer>();
		
		test.push(5);
		test.push(6);
		test.push(8);
		test.push(9);
		test.push(4);
		test.push(2);
		test.push(1);
		
		System.out.println("Stack from top to bottom");
		printStack(test);
		
		flipStack(test);
		
		System.out.println("Stack flipped");
		printStack(test);


	}
    // prints the contents of stack of Integers s, in
    // top-to-bottom order. This method may change s
    // temporarily, but by the time it exits, s must be
    // set back to the contents it had when printStack was
    // called.
	public static void printStack(Stack<Integer> s){
	    Stack<Integer> temp = new Stack<Integer>();
	    
	    while(!s.isEmpty()){
	    	int popped = s.pop();
	    	System.out.println(popped);
	    	temp.push(popped); 
	    }
	    while(!temp.isEmpty()){
	       	s.push(temp.pop()); 
	    }      
	}

    // this method reverses the order of the items in the
    // stack.  What was the top Integer becomes the bottom,
    // next-to-top become next-to-bottom, etc.
	public static void flipStack(Stack<Integer> s){
	    Queue<Integer> q = new Queue<Integer>();
	    
		    while(!s.isEmpty()){
		    	q.enqueue(s.pop());
		    }
		    while(!q.isEmpty()){
		    	s.push(q.dequeue());
		    }
		    
	    
	}
}