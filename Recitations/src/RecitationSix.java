
public class RecitationSix {

	public static void main(String[] args) {
		/*
		 * String str = IO.readString();
		 * Boolean apple = RecitationSix.isPalindrome(str);
		 * IO.outputBooleanAnswer);
		*/
		/*
		 * String word1 = IO.readString();
		 * String word2 = IO.readString();
		 * Boolean result = RecitationSix.isAnagram(word1, word2);
		 * IO.outputBooleanAnswer(result);
		 */
		
	}
	
	public static boolean isPalindrome(String str){
		str = str.toLowerCase();
		for (int i = 0;i < str.length()/2;i++){
			if (str.charAt(0) != str.charAt(str.length()-1)){
				return false;
				
			}
		}
		return true;
	}
	/*public static String deleteSpace(String s){
		String new1 = "";
		for (int i = 0; i < s.length();i++){
			if(s.charAt(i) != new1){
				new1 += s.charAt(i);
			}
		}
	}
	*/
	public static boolean isAnagram(String word1, String word2){
		if(word1.length() != word2.length()){
			return false;
		}
		for(int i = 0; i <word1.length(); i++){
			char letter = word1.charAt(i);
			int index = word2.indexOf(letter);
			if (index == -1){
				return false;
			}
			String before = word2.substring(0, index);
			String after = word2.substring(index, word2.length());
			word2 = before + after;
			
		}
		return true;
	}
	
	public static String subseq(String s){
		int largestSublength  = 1;
		
		int maxSubIndStart = 0;
		int maxSubIndEnd = 0;
		int curStart;
		int curEnd;
		for (int i = 1; i < s.length(); i++){
			int currentLargestSub = 1;
			if (s.charAt(i) == s.charAt(i-1)){
				currentLargestSub++; 
				if (currentLargestSub > largestSublength){
					largestSublength = currentLargestSub;
					//maxSubIndStart = curStart;
				}
			}
		}
		return s;
	}

}
