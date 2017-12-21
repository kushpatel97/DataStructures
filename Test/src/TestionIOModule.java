
public class TestionIOModule {
	
	//Main is the entry point of our program
	public static void main(String[] args) {
		
		//Reading and print in an int
		System.out.println("Enter an Integer: ");
		int a = IO.readInt();  //Reads an Integer from the keyboard
		IO.outputIntAnswer(a); //Prints the value of a

		//Reading an printing a double
		System.out.println("Enter a double: ");
		double b = IO.readDouble();  //Reads a double from the keyboard
		IO.outputDoubleAnswer(b);    //Prints the value of b
		
		//Reading and printing a character
		System.out.println("Enter a charcter: ");
		char c = IO.readChar();  //Reads a char from the keyboard
		IO.outputCharAnswer(c);  //Prints the value of c
		
		///Reading and printing a boolean variable
		System.out.println("Enter a boolean: ");
		boolean d = IO.readBoolean();  //Read a boolean from the keyboard
		IO.outputBooleanAnswer(d);     //Prints the value of d
		
		//Use math to power subroutine
		System.out.println("Enter a degree of power of 2 to compute: ");
		int degree = IO.readInt();
		double value = Math.pow(2, degree);
		IO.outputDoubleAnswer(degree);
		
		
	}

}
