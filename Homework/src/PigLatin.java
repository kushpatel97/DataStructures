
public class PigLatin {
	
	public static String translate(String original){
		String lowerCase = original.toLowerCase();
		char firstLetter = lowerCase.charAt(0);
		
		if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u'){
			String way = "way";
			return lowerCase + way;
		}
		else{
			String ay = "ay";
			char letter = firstLetter;
			lowerCase = lowerCase.substring(1) + letter; 
			return lowerCase + ay;
		}
		
	}

	public static void main(String[] args) {
		System.out.println("Enter a word");
		System.out.println(translate(IO.readString()));
	}
	

}
