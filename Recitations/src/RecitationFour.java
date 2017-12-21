
public class RecitationFour {

	public static void main(String[] args) {
		
		int sum = 0;
		
		System.out.println("Enter the number of scores you eant to average:");
		int numTests = IO.readInt();	
		int num = numTests;
		
		while (numTests > 0) {
			
			System.out.println("Enter the scores you want to average");
			int testScores = IO.readInt();	
			
			numTests--;
			sum += testScores;
		}	
		
		int average = sum/num;
		
		System.out.println("Your average is : " + average );
		
			
			
		
			
				
	}

}
