public class StringRec
{
	public static void main(String[] args) {
	
	}
	
public static String decompress(String compressedText)
{

	String compressed = "";
	int count = 0;
	int length = compressedText.length();	
	
	if(count >= length){
		return compressed;		
	}
	else{
		if(Character.isDigit(compressedText.charAt(count))){
			char aa = compressedText.charAt(count);
								int temp = aa-'0';
			compressed = makeString(temp, compressedText.charAt(count+1));
		}

		else{
			compressed = ""+compressedText.charAt(count);
		}
				
		count++;	
		compressed = compressed+decompress(compressedText.substring(count, compressedText.length()));
		return compressed;
		}
	}
	public static String makeString(int integer, char character)
	{
		String compressed = "";	
		if(integer == 1)
		{
			return compressed;
		}
		else
		{
			return compressed.concat(""+character+makeString((integer-1), character));
		}
	}
}
