
public class RecitationFiveTwo {
	public static void main(String[] args) {
		System.out.println("Enter # ");
		int n = IO.readInt();
		int biggest = IO.readInt();
		for (int i = 0; i<n; i++){
			System.out.println("enter #");
			int x = IO.readInt();
			if ( x > biggest){
				biggest = x;
			}
		}
	System.out.println(biggest);
	}
}
