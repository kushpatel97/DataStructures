
public class SummingApples {

	public static void main(String[] args) {
		
		System.out.println("Please input John's number of apples: ");
		int johnApples = IO.readInt();
		
		System.out.println("Please enter Jane's number of apples: ");
		int janeApples = IO.readInt();
		
		int totalApples = johnApples + janeApples;
		
		//to output the total number of apples to system output
		IO.outputIntAnswer(totalApples);
	}

}
