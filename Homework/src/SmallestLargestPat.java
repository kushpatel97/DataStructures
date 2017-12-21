public class SmallestLargestPat {

	public static void main(String[] args) {
		double num=0;
		System.out.println("Enter your terminating value ");
		double endingNum=IO.readDouble();
		System.out.println("Enter your numbers");
		double firstNum=IO.readDouble();
		if(firstNum==endingNum){
			IO.reportBadInput();
			return;
		}
		double x=firstNum;
		double y=firstNum;
		
		while ((num=IO.readDouble())!=endingNum){
			if(num>x||num==x){
				x=num;
				System.out.println(x);
			}
			if(num<y){
				y=num;
				System.out.println(y);
			}
			
			
		}
		IO.outputDoubleAnswer(x);
		IO.outputDoubleAnswer(y);
	
	
	}

}
