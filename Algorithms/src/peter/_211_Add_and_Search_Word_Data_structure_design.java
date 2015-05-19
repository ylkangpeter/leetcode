package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. A . means it
 * can represent any one letter.
 * 
 * For example:
 * 
 * <pre>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * </pre>
 * 
 * @author ylkang May 18, 2015
 */
public class _211_Add_and_Search_Word_Data_structure_design {

	private TrieNode tree = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		tree.insert(word);
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return tree.search(word);
	}

	private static class TrieNode {

		private boolean wordHere = false;

		private Map<Character, TrieNode> rootMap = new HashMap<Character, TrieNode>();

		public void insert(String word) {
			if (word != null && !word.isEmpty()) {
				insert(word.toCharArray(), 0, this);
			}
		}

		public boolean search(String word) {
			if (word != null && !word.isEmpty()) {
				return search(word.toCharArray(), 0, this);
			}
			return false;
		}

		private void insert(char[] chars, int offset, TrieNode tree) {

			if (offset >= chars.length) {
				tree.wordHere = true;
				return;
			}

			char root = chars[offset];
			TrieNode trie = new TrieNode();
			if (tree.rootMap.get(root) == null) {
				tree.rootMap.put(root, trie);
			} else {
				trie = tree.rootMap.get(root);
			}

			insert(chars, offset + 1, trie);
		}

		private boolean search(char[] chars, int offset, TrieNode tree) {
			if (offset >= chars.length) {
				if (tree.wordHere) {
					return true;
				} else {
					return false;
				}

			}

			char root = chars[offset];
			TrieNode trie = new TrieNode();
			if (root != '.') {
				if (tree.rootMap.get(root) == null) {
					return false;
				} else {
					trie = tree.rootMap.get(root);
				}
				return search(chars, offset + 1, trie);
			} else {
				for (TrieNode node : tree.rootMap.values()) {
					boolean isFound = search(chars, offset + 1, node);
					if (isFound) {
						return true;
					}
				}
				return false;
			}
		}
	}

	public static void main(String[] args) {
		_211_Add_and_Search_Word_Data_structure_design a = new _211_Add_and_Search_Word_Data_structure_design();
		a.addWord("bad");
		a.addWord("dad");
		a.addWord("mad");
		System.out.println(a.search("pad"));
		System.out.println(a.search("bad"));
		System.out.println(a.search(".ad"));
		System.out.println(a.search("b.."));

		System.out.println();
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
