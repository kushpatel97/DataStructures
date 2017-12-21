
public class Random2DArray {

	public static void main(String[] args) {

	}
	
	public static void printOnes(int[][] numbers){
		int zero = 0;
		int one = 0;
		// Rows outer loop
		for(int i = 0; i < numbers.length; i++){
			for(int j = 0; j < numbers[0].length; j++){
				if (numbers[i][j] == 0){
					zero++;
				}
				else{
					one++;
				}
			}
		}
	}

}
