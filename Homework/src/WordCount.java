
public class WordCount {

	public static void main(String[] args) {
		System.out.println("Enter a string");
		String phrase = IO.readString();
		System.out.println("Enter the minimum length of letters in a word to count the number of words in the phrase");;
		int min = IO.readInt();
		System.out.println(countWords(phrase,min));
	}
	
	public static int countWords(String original, int minLength){
		int countWords = 0;
		String[] sentence = original.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		for (int i = 0; i < sentence.length; i++){
			
			if (sentence[i].length() >= minLength){
				countWords++;
			}
		}
		return countWords;
	}

}
