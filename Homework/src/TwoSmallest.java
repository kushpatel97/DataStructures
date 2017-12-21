
public class TwoSmallest {

	public static void main(String[] args) {
		double smallest = Double.POSITIVE_INFINITY;
		double secondSmallest = Double.POSITIVE_INFINITY;
		
		System.out.println("Enter a terminating value to stop entering more numbers");
		double terminatingValue = IO.readDouble();
		
		System.out.println("Enter numbers:");
		double num = IO.readDouble();
	
			while (num != terminatingValue){					
				if (num < smallest){
					secondSmallest = smallest;
					smallest = num;
				}
				else if (num < secondSmallest){
					secondSmallest = num;
				}	
				num = IO.readDouble();
			}
			IO.outputDoubleAnswer(smallest);
			IO.outputDoubleAnswer(secondSmallest);
	}
				
}


