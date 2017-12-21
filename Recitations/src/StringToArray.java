
public class StringToArray {

	public static void main(String[] args) {
		System.out.println(reverse(IO.readString()));	
	}

	public static String reverse(String s){
		String reverse = "";
		char[] arr = new char[s.length()];
		for (int i = 0; i < s.length(); i++){
			arr[i] = s.charAt(i);
		}
		for (int i = s.length()-1; i>=0; i--){
			reverse = reverse + arr[i];
		}
		return reverse;
		
	}
}
