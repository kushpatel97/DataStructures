
public class SmallestLargest {

	public static void main(String[] args) {
		double num = 0;
								
		System.out.print("Enter a number that you want to use as the ternimating value: ");
		double terminatingValue = IO.readDouble();
		
		System.out.println("Enter a list of numbers");
		num = IO.readDouble();
		double smallest = num;
		double largest = num;
		
		
		if(num == terminatingValue){
			IO.reportBadInput();
			return;
		}					
		while (num!=terminatingValue){
				if (num < smallest || num == smallest){
					smallest = num;
				}
				else if (num > largest || num == largest){
					largest = num;
				}	
				num = IO.readDouble();
		}
			IO.outputDoubleAnswer(smallest);
			IO.outputDoubleAnswer(largest);			
	}		
}

