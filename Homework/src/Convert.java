
public class Convert {

	public static void main(String[] args) {
		System.out.print("Enter a binary number: ");
		String binary = IO.readString();
		System.out.print("Enter true or false: ");
		boolean tf = IO.readBoolean();
		System.out.print(convert(binary,tf));
	}
	
	public static int convert(String binaryString, boolean signBit){
		int i = Integer.parseInt(binaryString,2);
		
		if (signBit == true){
			if(binaryString.charAt(0) == '0'){
				return i;
			}
			else if(binaryString.charAt(0) == '1'){
				return i*(-1);
			}
		}
		return i;
	}

}
