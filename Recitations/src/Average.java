
public class Average {

	public static void main(String[] args) {

	}
	
	public static double avg(int[] nums){
		double sum = 0;
		for (int i = 0; i < nums.length; i++){
			sum = sum + nums[i];
		}
		double average = (sum/nums.length);
		return average;
	}

}
