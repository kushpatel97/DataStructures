import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inputreader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Say Something: ");
		String str = br.readLine();
		System.out.println(str + " back!");

	}

}
