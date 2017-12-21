
public class LuckySevens {

	public static void main(String[] args) {
		
		int count = 0;
		
		System.out.println("Enter a starting number");
		int start = IO.readInt();
		
		System.out.println("Enter an ending number");
		int end = IO.readInt();
		
		if (start > end){
			IO.reportBadInput();
			return;
		}
		
		for (int i = start; i <= end; i++){
			int num = i;
			while (num != 0){
				String string = String.valueOf(num);
				if((string.charAt(string.length()-1))=='7'){
					count = count+1;
				}
				num = num/10;
			}
		}
		IO.outputIntAnswer(count);        
			
		

		
	}

}
