import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FReader {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		while ((line=br.readLine()) != null){
			System.out.println("Hi " + line);
		}

	}

}
