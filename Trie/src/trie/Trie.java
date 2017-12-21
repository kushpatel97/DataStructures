package trie;

import java.util.ArrayList;

/**
 * This class implements a Trie. 
 * 
 * @author Sesh Venugopal
 *
 */
public class Trie {
	
	// prevent instantiation
	private Trie() { }
	
	/**
	 * Builds a trie by inserting all words in the input array, one at a time,
	 * in sequence FROM FIRST TO LAST. (The sequence is IMPORTANT!)
	 * The words in the input array are all lower case.
	 * 
	 * @param allWords Input array of words (lowercase) to be inserted.
	 * @return Root of trie with all words inserted from the input array
	 */


	
	public static TrieNode buildTrie(String[] allWords) {
		TrieNode root=new TrieNode(null,null,null);		
		short zero = 0;
		
		if (allWords.length==0){
			return root;
		}
		
		if(allWords.length==1){
			root.firstChild=new TrieNode(null, null, null);
			root.firstChild.substr = new Indexes(0, zero, (short)(allWords[0].length()-1));
			return root;
		}
		
		TrieNode fNode = new TrieNode(null, null, null);
		fNode.substr = new Indexes(0, zero, (short)(allWords[0].length()-1));
		TrieNode ptr=fNode;
		short prefixlen;
		boolean flag = true;

		
		for(int i=0;i<=allWords.length;){
			i++;
			if(i == allWords.length){
				break;
			}
			String word = allWords[i];
			ptr = fNode;
			while(flag == true){
				prefixlen = countPrefixChars(word, ptr, allWords);
				
				if(prefixlen < ptr.substr.startIndex){
					if(ptr.sibling==null){
						ptr.sibling=new TrieNode(null, null, null);
						ptr.sibling.substr = new Indexes(i, (short)(prefixlen+1), (short)(word.length()-1));
						break;
					}
					else{
						ptr=ptr.sibling;
						continue;
					}
				}
				else if(prefixlen > ptr.substr.startIndex){
					if(ptr.firstChild==null){
						ptr.firstChild=new TrieNode(null, null,null);
						ptr.firstChild.substr = new Indexes(ptr.substr.wordIndex, (short)(prefixlen+1),ptr.substr.endIndex);
						ptr.firstChild.sibling=new TrieNode(null, null, null);
						ptr.firstChild.sibling.substr = new Indexes(i, (short)(prefixlen+1), (short)(word.length()-1));
						ptr.substr.endIndex=(short)(prefixlen);
						break;
					}
				
					else{
						ptr=ptr.firstChild;
						continue;
					}
				}
				
				else if(prefixlen == ptr.substr.startIndex){
					if(prefixlen == ptr.substr.endIndex){
						ptr=ptr.firstChild;
						continue;
					}
					
					TrieNode temp = new TrieNode(null, null, null);
					temp.substr = new Indexes(i, (short)(prefixlen+1),(short)(word.length()-1));
					TrieNode curr=new TrieNode(null, ptr.firstChild, temp);
					curr.substr = new Indexes(ptr.substr.wordIndex, (short)(prefixlen+1),ptr.substr.endIndex);

					ptr.substr.endIndex=prefixlen;
					ptr.firstChild=curr;
					break;
				}
			}		
		}
	
		root.firstChild=fNode;
		return root;
	}
	

	private static String getPrefix(String word, TrieNode node, String[] array) {
		String ans = "";
		String trieVal = array[node.substr.wordIndex];
		for(int i=0; i<word.length() && i < trieVal.length(); i++) {
			if(word.charAt(i) == trieVal.charAt(i)) {
				ans = ans + word.charAt(i);
			}
			else {
				break;
			}
		}if(!ans.isEmpty()){
			return ans;
		}
		return null;		
	}
	
	private static short countPrefixChars(String word, TrieNode node, String[] array) {
		short ans = -1;
		String trieVal = array[node.substr.wordIndex];
		int minLength = Math.min(word.length(),trieVal.length());
		for(int i=0; i<minLength; i++) {
			if(word.charAt(i) == trieVal.charAt(i)) {
				ans = (short)i;
			}
			else {
				return ans;
			}
		}
		return ans;		
	}

	
	
	/**
	 * Given a trie, returns the "completion list" for a prefix, i.e. all the leaf nodes in the 
	 * trie whose words start with this prefix. 
	 * For instance, if the trie had the words "bear", "bull", "stock", and "bell",
	 * the completion list for prefix "b" would be the leaf nodes that hold "bear", "bull", and "bell"; 
	 * for prefix "be", the completion would be the leaf nodes that hold "bear" and "bell", 
	 * and for prefix "bell", completion would be the leaf node that holds "bell". 
	 * (The last example shows that an input prefix can be an entire word.) 
	 * The order of returned leaf nodes DOES NOT MATTER. So, for prefix "be",
	 * the returned list of leaf nodes can be either hold [bear,bell] or [bell,bear].
	 *
	 * @param root Root of Trie that stores all words to search on for completion lists
	 * @param allWords Array of words that have been inserted into the trie
	 * @param prefix Prefix to be completed with words in trie
	 * @return List of all leaf nodes in trie that hold words that start with the prefix, 
	 * 			order of leaf nodes does not matter.
	 *         If there is no word in the tree that has this prefix, null is returned.
	 */
	public static ArrayList<TrieNode> completionList(TrieNode root,String[] allWords, String prefix) {
		ArrayList<TrieNode> completionList = new ArrayList<TrieNode>();

		TrieNode ptr = root.firstChild;
		if (root.firstChild == null) {
			return null;
		}
		if(ptr.firstChild == null && ptr.sibling == null){
			String checkPrefix = getPrefix(prefix, ptr, allWords);
			if(checkPrefix != null) {
				completionList.add(ptr);
				return completionList;
			}else {
				return null;
			}
		}
		
		while(ptr != null){
			String checkPrefix = getPrefix(prefix, ptr, allWords);
			if(ptr.firstChild == null){ 
				if(checkPrefix != null){ 
					completionList.add(ptr);
				}
			} else { 
				if(checkPrefix != null){
					ArrayList<TrieNode> getPrefixRecur = recursiveCompletionList(prefix, ptr, allWords);
					completionList.addAll(getPrefixRecur);
				}
			}
			ptr = ptr.sibling;
		}
		return completionList;
	}
	

	private static ArrayList<TrieNode> recursiveCompletionList(String word, TrieNode node, String[] allWords){
		ArrayList<TrieNode> completeList = new ArrayList<TrieNode>();
		TrieNode ptr = node.firstChild;
		
		while(ptr != null){
			String checkPrefix = getPrefix(word, ptr, allWords);
			if(ptr.firstChild == null){
				if(checkPrefix != null){
					completeList.add(ptr);
				}
			} else { 
				if(checkPrefix != null){ 
					completeList.addAll(recursiveCompletionList(word, ptr, allWords));
				}
			}
			ptr = ptr.sibling;
		}
		if(completeList.isEmpty()){
			return null;
		}
		return completeList;
	}
	
	
	
	
	public static void print(TrieNode root, String[] allWords) {
		System.out.println("\nTRIE\n");
		print(root, 1, allWords);
	}
	
	private static void print(TrieNode root, int indent, String[] words) {
		if (root == null) {
			return;
		}
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		
		if (root.substr != null) {
			String pre = words[root.substr.wordIndex]
							.substring(0, root.substr.endIndex+1);
			System.out.println("      " + pre);
		}
		
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		System.out.print(" ---");
		if (root.substr == null) {
			System.out.println("root");
		} else {
			System.out.println(root.substr);
		}
		
		for (TrieNode ptr=root.firstChild; ptr != null; ptr=ptr.sibling) {
			for (int i=0; i < indent-1; i++) {
				System.out.print("    ");
			}
			System.out.println("     |");
			print(ptr, indent+1, words);
		}
	}
 }
