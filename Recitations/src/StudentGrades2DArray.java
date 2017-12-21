
public class StudentGrades2DArray {

	public static void main(String[] args) {

	}
	
	public static void averages(int[][] grades){
		for(int students = 0; students < grades.length; students++){
			int minScore = grades[students][0];
			int sum = 0;
			for(int assignments = 0; assignments < grades[0].length; assignments++){
				if (grades[students][assignments] < minScore){
					minScore = grades[students][assignments];
				}
				sum = sum + grades[students][assignments];
			}
			
			double average = (sum-minScore)/(grades[0].length-1);
		}
	}

}
