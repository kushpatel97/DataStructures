
public class MAxWithArray {

	public static int[] getValues(){
		System.out.println("How many values? ");
		int n = IO.readInt();
		int[] array = new int[n]; //Creates an integer with length n
		
		//read n values
		for (int i = 0; i < n; i++){
			System.out.print("Enter next value: ");
			int value = IO.readInt();
			array[i] = value; //insert vallue into array position
		}
		return array;
	}
	
	public static void print(int[] array){
		for (int item : array){
			System.out.println(item);
		}
	}
	
	public static void main(String[] args) {
		
		int[] values = getValues();
		
		print(values);
		
		//find the maximum
		int max = values[0];
		for (int i = 1; i < values.length; i++){
			max = Math.max(max, values[i]);
		}
		System.out.println("Maximum value is: " + max);
		
	}

}
