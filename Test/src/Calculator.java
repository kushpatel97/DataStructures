
public class Calculator {

	public static void main(String[] args) {
		
		System.out.println("Enter [1]-Addition [2]-Subtraction [3]-Multiplication [4]-Division" );
		int op = IO.readInt();
		
		System.out.print("Enter first number: ");
		double op1 = IO.readDouble();
		
		System.out.println("Enter second number: ");
		double op2 = IO.readDouble();
		
		if (op == 1) {
			//addition
			double result = op1 + op2;
			IO.outputDoubleAnswer(result);
			return;
		}
		
		if (op == 2) {
			//subtraction
			double result = op1 - op2;
			IO.outputDoubleAnswer(result);
			return;
		}
		
		if (op == 3) {
			//multiplication
			double result = op1 * op2;
			IO.outputDoubleAnswer(result);
			return;
		}
		
		if (op == 4) {
			//division
			if (op2 != 0){
				double result = op1/op2;
				IO.outputDoubleAnswer(result);
			}			
			else {
				System.out.println("Error: division by zero");
				
			}				
			return;
		}
		System.out.print("Unknown operation");
	}

}
