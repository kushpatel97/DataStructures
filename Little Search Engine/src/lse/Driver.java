package lse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	
	

	public static void main(String[] args) throws IOException {
		LittleSearchEngine test = new LittleSearchEngine();
		String noise = "noisewords.txt";
		String docs = "docs.txt";
		test.makeIndex(docs, noise);
		System.out.println("GetKeyword:\n" + test.getKeyword("Greats" + "\n"));

		//test.mergeKeywords(test.makeIndex(docs, noise));
		
		//System.out.println("KeyWords Index:\n" + test.keywordsIndex.get("curious") + "\n");
		//System.out.println("KeyWords Index:\n" +test.keywordsIndex.get("forgot")+"\n");
		System.out.print("Top 5 Search:\n" + test.top5search("started","feet"));
	}

}