
public class F2C {

	public static void main(String[] args) {
		
		System.out.println("Pleas, enter temperature in F: ");
		double tempF = IO.readDouble();
		
		if (tempF <-459.67){
			System.out.println("Error: temperature is less than -459.67.");
			return;
		}
		
		double tempC = (tempF - 32) * 5 / 9;
		IO.outputDoubleAnswer(tempC);
		

	}

}
