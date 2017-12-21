
public class PayFriend {
//Assignment 1
	public static void main(String[] args) {
		System.out.println("java PyFriend");
		System.out.println("What is your payment amount?");
		double payment = IO.readDouble();
		
		if (payment <= 100){
			IO.outputIntAnswer(5);
		}
		else if (payment > 100 && payment < 1000){
			if (payment*0.03 > 6) {
				IO.outputDoubleAnswer(payment*0.03);
			}
			else {
				IO.outputDoubleAnswer(6);
			}
		}
		else if (payment >= 1000 && payment < 10000){
			if (payment*0.01 > 15){
				IO.outputDoubleAnswer(payment*0.01);
			}
			else {
				IO.outputDoubleAnswer(15);
			}
		}
		else if (payment  >= 10000){
			if (payment == 10000){
				IO.outputDoubleAnswer(payment*0.01);
			}
			else if (payment >= 10000 && payment <=15000){
				IO.outputDoubleAnswer((payment*0.01)+((payment-10000)*0.02));
			}
			else if (payment > 15000){
				IO.outputDoubleAnswer((10000*0.01)+(5000*0.02)+((payment-15000)*0.03));				
			}
		}
		
		
	}

}
