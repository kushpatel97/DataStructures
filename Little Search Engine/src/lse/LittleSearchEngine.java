package lse;

import java.io.*;
import java.util.*;

/**
 * This class builds an index of keywords. Each keyword maps to a set of pages in
 * which it occurs, with frequency of occurrence in each page.
 *
 */
public class LittleSearchEngine {
	
	/**
	 * This is a hash table of all keywords. The key is the actual keyword, and the associated value is
	 * an array list of all occurrences of the keyword in documents. The array list is maintained in 
	 * DESCENDING order of frequencies.
	 */
	HashMap<String,ArrayList<Occurrence>> keywordsIndex;
	
	/**
	 * The hash set of all noise words.
	 */
	HashSet<String> noiseWords;
	
	/**
	 * Creates the keyWordsIndex and noiseWords hash tables.
	 */
	public LittleSearchEngine() {
		keywordsIndex = new HashMap<String,ArrayList<Occurrence>>(1000,2.0f);
		noiseWords = new HashSet<String>(100,2.0f);
	}
	
	/**
	 * Scans a document, and loads all keywords found into a hash table of keyword occurrences
	 * in the document. Uses the getKeyWord method to separate keywords from other words.
	 * 
	 * @param docFile Name of the document file to be scanned and loaded
	 * @return Hash table of keywords in the given document, each associated with an Occurrence object
	 * @throws FileNotFoundException If the document file is not found on disk
	 */
	public HashMap<String,Occurrence> loadKeywordsFromDocument(String docFile) 
	throws FileNotFoundException {
		if(docFile == null) {
			throw new FileNotFoundException("The document file is not found on disk");
		}
		HashMap<String,Occurrence> keywords = new HashMap<String,Occurrence>();
		Scanner scanfile = new Scanner(new File(docFile));
		
		while(scanfile.hasNext()) {
			String word = getKeyword(scanfile.next());
			if(word != null) {
				if(keywords.containsKey(word)) {
					Occurrence rep = keywords.get(word);
					rep.frequency++;
					keywords.put(word, rep);
				}
				else {
					keywords.put(word, new Occurrence(docFile, 1));
				}
			}
			
		}
		return keywords;
	}
	
	/**
	 * Merges the keywords for a single document into the master keywordsIndex
	 * hash table. For each keyword, its Occurrence in the current document
	 * must be inserted in the correct place (according to descending order of
	 * frequency) in the same keyword's Occurrence list in the master hash table. 
	 * This is done by calling the insertLastOccurrence method.
	 * 
	 * @param kws Keywords hash table for a document
	 */
	public void mergeKeywords(HashMap<String,Occurrence> kws) {
		ArrayList<Occurrence> occurrences = new ArrayList<Occurrence>();
		for(String word : kws.keySet()) {
			Occurrence getKWS = kws.get(word);
			if(keywordsIndex.containsKey(word)) {
				keywordsIndex.get(word).add(getKWS);
				insertLastOccurrence(keywordsIndex.get(word));
			}
			else {
				occurrences.add(getKWS);
				keywordsIndex.put(word, occurrences);
			}
		}
	}
	
	/**
	 * Given a word, returns it as a keyword if it passes the keyword test,
	 * otherwise returns null. A keyword is any word that, after being stripped of any
	 * trailing punctuation, consists only of alphabetic letters, and is not
	 * a noise word. All words are treated in a case-INsensitive manner.
	 * 
	 * Punctuation characters are the following: '.', ',', '?', ':', ';' and '!'
	 * 
	 * @param word Candidate word
	 * @return Keyword (word without trailing punctuation, LOWER CASE)
	 */
	public String getKeyword(String word) {
		word = word.trim();
		if(word.isEmpty() || word == null || !Character.isLetter(word.charAt(0))) {
			return null;
		}
		for(int i = word.length()-1; i >= 0; i--) {
			char sym = word.charAt(i);
			if (sym == '.' || sym == ',' || sym == '?' || sym == ':' || sym == ';' || sym == '!') {
				word = word.substring(0, i);
			}
		}
		word = word.toLowerCase();
		for(int i = 0; i < word.length(); i++) {
			if(!Character.isLetter(word.charAt(i))) {
				return null;
			}
		}
		if(noiseWords.contains(word)) {
			return null;
		}
		String keyword = word.toLowerCase();
		return keyword;
	}
	
	/**
	 * Inserts the last occurrence in the parameter list in the correct position in the
	 * list, based on ordering occurrences on descending frequencies. The elements
	 * 0..n-2 in the list are already in the correct order. Insertion is done by
	 * first finding the correct spot using binary search, then inserting at that spot.
	 * 
	 * @param occs List of Occurrences
	 * @return Sequence of mid point indexes in the input list checked by the binary search process,
	 *         null if the size of the input list is 1. This returned array list is only used to test
	 *         your code - it is not used elsewhere in the program.
	 */
	public ArrayList<Integer> insertLastOccurrence(ArrayList<Occurrence> occs) {
		ArrayList<Integer> occurrencesList = new ArrayList<Integer>();
		if(occs.size() == 1) {
			return null;
		}
		int lo = 0;
		int hi = occs.size()-1;
		int mid = 0;
		Occurrence lastval = occs.get(hi);
		int lastFreq = lastval.frequency;
		
		while(lo <= hi) {
			mid = (lo + hi)/2;
			occurrencesList.add(mid);
			if(occs.get(mid).frequency == lastFreq) {
				break;
			}
			else if(occs.get(mid).frequency < lastFreq) {
				hi = mid - 1;
			}
			else {
				lo = mid + 1;
			}
		}
		int lastMP = occurrencesList.get(occurrencesList.size()-1);
		occs.add(lastMP, lastval);
		
		return occurrencesList;
	}
	
	/**
	 * This method indexes all keywords found in all the input documents. When this
	 * method is done, the keywordsIndex hash table will be filled with all keywords,
	 * each of which is associated with an array list of Occurrence objects, arranged
	 * in decreasing frequencies of occurrence.
	 * 
	 * @param docsFile Name of file that has a list of all the document file names, one name per line
	 * @param noiseWordsFile Name of file that has a list of noise words, one noise word per line
	 * @throws FileNotFoundException If there is a problem locating any of the input files on disk
	 */
	public void makeIndex(String docsFile, String noiseWordsFile) 
	throws FileNotFoundException {
		// load noise words to hash table
		Scanner sc = new Scanner(new File(noiseWordsFile));
		while (sc.hasNext()) {
			String word = sc.next();
			noiseWords.add(word);
		}
		
		// index all keywords
		sc = new Scanner(new File(docsFile));
		while (sc.hasNext()) {
			String docFile = sc.next();
			HashMap<String,Occurrence> kws = loadKeywordsFromDocument(docFile);
			mergeKeywords(kws);
		}
		sc.close();
	}
	
	/**
	 * Search result for "kw1 or kw2". A document is in the result set if kw1 or kw2 occurs in that
	 * document. Result set is arranged in descending order of document frequencies. (Note that a
	 * matching document will only appear once in the result.) Ties in frequency values are broken
	 * in favor of the first keyword. (That is, if kw1 is in doc1 with frequency f1, and kw2 is in doc2
	 * also with the same frequency f1, then doc1 will take precedence over doc2 in the result. 
	 * The result set is limited to 5 entries. If there are no matches at all, result is null.
	 * 
	 * @param kw1 First keyword
	 * @param kw1 Second keyword
	 * @return List of documents in which either kw1 or kw2 occurs, arranged in descending order of
	 *         frequencies. The result size is limited to 5 documents. If there are no matches, returns null.
	 */
	public ArrayList<String> top5search(String kw1, String kw2) {
		
		ArrayList<String> top5 = new ArrayList<String>();
		ArrayList<Occurrence> kw1List = new ArrayList<Occurrence>();
		ArrayList<Occurrence> kw2List = new ArrayList<Occurrence>();
		
		if (keywordsIndex.get(kw1) != null) {
			kw1List = keywordsIndex.get(kw1);
		}
		if (keywordsIndex.get(kw2) != null) {
			kw2List = keywordsIndex.get(kw2);
		}
		if (kw1List == null && kw2List == null) {
			return null;
		} else {
			int count = 0;
			int i = 0;
			int j = 0;
		
			
			while (count < 5 && (i < kw1List.size() || j < kw2List.size())) {
				if (i == kw1List.size()) {
					if (!top5.contains(kw2List.get(j).document)) {
						top5.add(kw2List.get(j).document);
						count++;
					}
					j++;
				} 
				else if (j == kw2List.size()) {
					if (!top5.contains(kw1List.get(i).document)) {
						top5.add(kw1List.get(i).document);
						count++;
					}
					i++;
				} 
				else {
					if (kw1List.get(i).frequency >= kw2List.get(j).frequency) {
						if (!top5.contains(kw1List.get(i).document)) {
							top5.add(kw1List.get(i).document);
							count++;
						}
						i++;
					} if(kw1List.get(i).frequency < kw2List.get(j).frequency) {
						if (!top5.contains(kw2List.get(j).document)) {
							top5.add(kw2List.get(j).document);

							count++;
						}
						j++;
					}
					}
				}
			}
		
		return top5;
	}
}
