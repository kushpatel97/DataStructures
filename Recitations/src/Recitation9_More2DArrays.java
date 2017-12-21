
public class Recitation9_More2DArrays {	
	/*
	 * Write	a	method	that	takes	in	an	int	2D	array	and	rotates	it	by	180	degrees.
	 * Example	run:
	 * The	original	array	is:
	 * 4	3	5	6
	 * 1	5	8	2
	 * 4	7	1	0
	 * The	180	degree	rotated	array	is:
	 * 0	1	7	4
	 * 2	8	5	1
	 * 6	5	3	4
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public static void rotate(int[][] nums){
		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < nums.length/2; j++){
				int temp = nums[i][j];
				nums[i][j] = nums[i][nums[0].length-1-j];
				nums[i][nums[0].length-1-j] = temp;		
			}
			int[] temp = nums[i];
			nums[i] = nums[nums.length-1-i];
			nums[nums.length-1-i] = temp;
		}
	}

}
