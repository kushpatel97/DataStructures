
public class Compress {

	public static void main(String[] args) {
		System.out.println(compress(IO.readString()));
	}
	
	public static String compress(String original){
		String compressedWord = "";
		int counter = 0;
		
		while (counter < original.length()){
			int counterTwo = 1;
			if (counter < original.length()-1){
				while (original.charAt(counter) == original.charAt(counter+1)){
					counterTwo++;
					counter++;
					if (counter == original.length()-1){
						break;
					}
				}
			}
			//Don't add parenthesis
			if (counterTwo == 1)
				compressedWord = compressedWord + original.charAt(counter);
			
			else
				compressedWord = compressedWord + counterTwo + "" + original.charAt(counter);
				counter++;
			
		}
		
		return compressedWord;
	}

}
