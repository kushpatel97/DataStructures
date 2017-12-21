
public class MultiplicationTable {

	public static void main(String[] args) {
		System.out.println("Enter number:");
		int n = IO.readInt();
		//int table = MultiplicationTable.printTable(n);
	}
	
	public static void printTable(int n){
		for (int i = 1; i<=n; i++){
			for (int j = 1; j<=n; j++){
				System.out.print(i * j + " ");
			}
			System.out.println();
		}		
	}

}
