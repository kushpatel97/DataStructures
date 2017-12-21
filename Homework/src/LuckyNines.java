
public class LuckyNines {

	public static void main(String[] args) {
		System.out.println("Enter lower end");
		int lowerEnd = IO.readInt();
		System.out.println("Enter upper end");
		int upperEnd = IO.readInt();
		
		int ans = LuckyNines.countLuckyNines(lowerEnd, upperEnd);
		IO.outputIntAnswer(ans);
		
	}
	
	public static int countLuckyNines(int lowerEnd, int upperEnd){
		if(lowerEnd>upperEnd){
			IO.reportBadInput();
		}
		int count = 0;
		for (int i = lowerEnd; i <= upperEnd; i++){
			int num = i;
			while (num != 0){
				String string = String.valueOf(num);
				if((string.charAt(string.length()-1))=='9'){
					count = count+1;
				}
				num = num/10;
			}
		}
		return count;
	}

}
