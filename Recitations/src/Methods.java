
public class Methods {

	public static void main(String[] args) {
		System.out.println("Enter a number");
		int num1 = IO.readInt();
		System.out.println("Enter a number");
		int num2 = IO.readInt();
		int ans = Methods.gcf(num1, num2);
		System.out.println(ans);
		
		Methods.simplify(12, 15);
		
	}
	
	public static int gcf(int num1, int num2){
		int smaller;
		if (num1 > num2){
			smaller = num1;
		}
		else{
			smaller = num2;
		}
		for (int divisor=smaller; divisor > 0; divisor--){
			if (num1 % divisor == 0 && num2 % divisor == 0){
				return divisor;
			}
			
		}
		return 1;
	}
	
	public static void simplify(int num, int denom){
		int div = gcf(num, denom);
		num = num/div;
		denom = denom/div;
		System.out.println(num + "/" +denom);
	}

}
