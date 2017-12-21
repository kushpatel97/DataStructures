
public class Grades {
	public static void addGrade(double [][] array, int exam, int student, double grade){
		if(exam < 0 || exam >= array.length){
			System.out.println("Error: index out of bounds");
		}
		else {
			array[exam][student] = grade;
		}
	}
	public static double examAverage (double[][] array, int exam){
		if (exam < 0 || exam >= array.length){
			System.out.println("Error: index out of bounds");
			return -1;
		}
		double sum = 0;
		for(int s = 0;s < array[exam].length; s++){
			sum = sum + array[exam][s];
		}
		return sum/array[exam].length;
	}
	
	public static double studentAverage(double[][] array, int student){
		double sum = 0;
		if (student < 0 || student>= array[0].length){
			System.out.println("Error: index out of bounds");
			return -1;
		}
		for(int e = 0; e < array.length; e++){
			sum = sum + array[e][student];
		}
		return sum/array[0].length;
	}
	public static void main(String[] args){
		
		//create 2-D array
		double [][] gradeBook = new double [3][4];
		
		//Populate the array
		for (int r = 0; r<3; r++){
			for(int c=0; c<4; c++){
				System.out.print("Enter grade for exam " + (r+1) + " student " + (c+1) + ": ");
				double grade = IO.readDouble();
				addGrade(gradeBook, r, c, grade);
			}
		}
		addGrade(gradeBook, 0, 0, 9.3);
		
	}

}
