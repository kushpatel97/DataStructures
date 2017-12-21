package trie;

public class TrieTest {

	public static void main(String[] args) {
		String ans = "";
		String first = "dorm";
		String second = "door";
		for(int i=0; i<first.length() && i < second.length(); i++) {
			if(first.charAt(i) == second.charAt(i)) {
				ans = ans + first.charAt(i);
			}
			else {
				break;
			}
		}if(!ans.isEmpty()){
			System.out.println(ans);
		}
		System.out.println("Cats");
	
		System.out.println("Index of prefix: " + second.indexOf('r'));
		System.out.println("Substring: " + second.substring(3,3));
	}
}
