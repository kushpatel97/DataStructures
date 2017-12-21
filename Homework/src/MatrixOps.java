
public class MatrixOps {

	public static void main(String[] args) {

	}
	
	public static double[][] multiply(double[][] A, double[][] B){
		if(A[0].length != B.length){
			return null;
		}
		
		double product[][] = new double[A.length][B[0].length];
		
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < B[0].length; j++){
				for(int k = 0; k < A[0].length; k++){
					product[i][j] = product[i][j] + (A[i][k] * B[k][j]); 
				}
			}
		}
		return product;
	}

}
