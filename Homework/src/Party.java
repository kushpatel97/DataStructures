
public class Party {
//Assignment 1

	public static void main(String[] args) {
		System.out.println("How many people will be attending the party?");
		int people = IO.readInt();
		
		System.out.println("How many slices of pizza will each person eat?");
		int slices  = IO.readInt();
		
		System.out.println("How many cans of soda should each person be able to drink?");
		int cans = IO.readInt();
		
		System.out.println("What is the cost of a pie?");
		double costPie = IO.readDouble();
		
		System.out.println("What is the number of slices in a pie?");
		int slices_in_pie = IO.readInt();
		
		System.out.println("What is the cost of a case of soda?");
		double costCase = IO.readDouble();
		
		System.out.println("How many cans are in a single case of soda?");
		int caseSoda = IO.readInt();
		
		IO.outputDoubleAnswer( (((Math.ceil((Math.ceil(people*slices)/slices_in_pie))*costPie) + ((Math.ceil(Math.ceil(people*cans)/caseSoda))*costCase)) *100/100));

	}

}
