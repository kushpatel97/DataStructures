
public class Recitation9_ReferenceTypesin2DArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public static int sub(String[][] words, String substring){
		int count = 0;
		for(int i = 0; i < words.length; i++){
			for(int j = 0; j < words[0].length; j++){
				if(words[i][j].contains(substring)){
					count++;
				}
			}
		}
		return count;
	}

}
