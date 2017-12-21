package sq;

public class Queue<T> {

	private CLL<T> queue;  
	// the circular linked list that
	// represents the queue
	
	// constructor - new Queue( ) returns a
	// reference to an empty Queue
	public Queue( ){
	    queue = new CLL<T>();
	}
	
	public void enqueue(T data){
	    queue.addAtRear(data);  	    
	}
	
	public T dequeue( ){	
		if(queue.isEmpty()){
			return null;
		}
		return queue.removeFront();
	}
	
	public boolean isEmpty( ){
		if(queue.isEmpty()){
			return true;
		}
		else{
			return false;
		}
			    
	}	
}